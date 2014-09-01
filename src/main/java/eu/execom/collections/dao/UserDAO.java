package eu.execom.collections.dao;

import org.springframework.data.repository.CrudRepository;

import eu.execom.collections.model.User;

public interface UserDAO extends CrudRepository<User, Long> {

	public User findByEmail(String email);

}

