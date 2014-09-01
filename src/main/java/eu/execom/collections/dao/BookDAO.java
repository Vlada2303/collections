package eu.execom.collections.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import eu.execom.collections.model.Book;
import eu.execom.collections.model.User;

public interface BookDAO extends CrudRepository<Book, Long> {
    
    public List<Book> findByUser(User user);
    
}
