package eu.execom.collections.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import eu.execom.collections.model.Picture;
import eu.execom.collections.model.User;

public interface PictureDAO extends CrudRepository<Picture, Long> {

    public List<Picture> findByUser(User user);

}