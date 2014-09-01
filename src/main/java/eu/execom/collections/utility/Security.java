package eu.execom.collections.utility;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import eu.execom.collections.dao.UserDAO;
import eu.execom.collections.model.User;

public class Security {

    @Autowired
    private static UserDAO userDao;
   
    @RequestMapping(value = "/getCurentUser", method = RequestMethod.GET)
    public static User getCurrentUser() {
        return userDao.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
    }
    
}
