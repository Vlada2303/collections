package eu.execom.collections.controller;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import eu.execom.collections.dao.BookDAO;
import eu.execom.collections.dao.UserDAO;
import eu.execom.collections.model.Book;
import eu.execom.collections.model.Book.coverType;
import eu.execom.collections.model.Book.genreType;
import eu.execom.collections.utility.Response;

@RestController
@RequestMapping("/book")
public class BookController {

    final public genreType[] genreTypes = genreType.values();
    final public coverType[] coverTypes = coverType.values();
    
    @Resource
    BookDAO bookDao;
    
    @Autowired
    UserDAO userDao;
    
    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(value = "/save", method = {RequestMethod.POST, RequestMethod.GET})
    public HashMap<String, String> addBook(@RequestBody Book book) {
        book.setUser(userDao.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName()));
        bookDao.save(book);
        return Response.setSuccess("Book saved successfuly.");
    }
    
    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public HashMap<String, String> deleteBook(@RequestBody Book book) {
        bookDao.delete(book.getId());
        return Response.setSuccess("Book deleted successfuly.");
    }
    
    @RequestMapping(value = "/getAllBooks", method = RequestMethod.GET)
    public List<Book> listBook() {
        return bookDao.findByUser(userDao.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName()));
    }
    
    @RequestMapping(value = "/getGenreTypes", method = RequestMethod.GET)
    public genreType[] getGenreTypes() {
        return genreTypes;
    }
    
    @RequestMapping(value = "/getCoverTypes", method = RequestMethod.GET)
    public coverType[] getCoverTypes() {
        return coverTypes;
    }
}
