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
import eu.execom.collections.dao.PictureDAO;
import eu.execom.collections.dao.UserDAO;
import eu.execom.collections.model.Picture;
import eu.execom.collections.model.Picture.pictureGenre;
import eu.execom.collections.model.Picture.pictureStyle;
import eu.execom.collections.model.Picture.pictureTechnique;
import eu.execom.collections.utility.Response;

@RestController
@RequestMapping("/picture")
public class PictureController {

    final public pictureGenre[] pictureGenres = pictureGenre.values();
    final public pictureStyle[] pictureStyles = pictureStyle.values();
    final public pictureTechnique [] pictureTechniques = pictureTechnique.values();
    
    @Resource
    PictureDAO pictureDao;
    
    @Autowired
    UserDAO userDao;
    
    //SAVE METHOD
    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(value = "/save", method = {RequestMethod.POST, RequestMethod.GET})
    public HashMap<String, String> addPicture(@RequestBody Picture picture) {
        picture.setUser(userDao.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName()));
        pictureDao.save(picture);
        return Response.setSuccess("Picture saved successfuly.");
    }
 
    //DELETE METHOD
    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public HashMap<String, String> deletePicture(@RequestBody Picture picture) {
        pictureDao.delete(picture.getId());
        return Response.setSuccess("Picture deleted successfuly.");
    }
    
    @RequestMapping(value = "/getAllPicture", method = RequestMethod.GET)
    public List<Picture> listPicture() {
        return pictureDao.findByUser(userDao.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName()));
    }
    
    @RequestMapping(value = "/getGenreTypes", method = RequestMethod.GET)
    public pictureGenre[] getpictureGenre() {
        return pictureGenres;
    }

    @RequestMapping(value = "/getpictureStyles", method = RequestMethod.GET)
    public pictureStyle[] getpictureStyle() {
        return pictureStyles;
    }
    
    @RequestMapping(value = "/getpictureTehniques", method = RequestMethod.GET)
    public pictureTechnique[] getpictureTechnique() {
        return pictureTechniques;
    }
}
    
   
    