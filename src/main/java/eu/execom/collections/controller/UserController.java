package eu.execom.collections.controller;

import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import eu.execom.collections.dao.UserDAO;
import eu.execom.collections.model.User;
import eu.execom.collections.model.User.roleType;
import eu.execom.collections.utility.Response;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserDAO userDao;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    BCryptPasswordEncoder encoder;

    @RequestMapping(value = "/getCurentUser", method = RequestMethod.GET)
    public User getCurrentUser() {
        return userDao.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());

    }

    @RequestMapping(value = "/edit", method = {RequestMethod.POST, RequestMethod.GET})
    public HashMap<String, String> editUser(@RequestBody User user) {
        userDao.save(user);
        return Response.setSuccess("Editing succsessful!");
    }

    @RequestMapping(value = "/save", method = {RequestMethod.POST, RequestMethod.GET})
    public HashMap<String, String> saveUser(@RequestBody User user) {
        final User foundUser = userDao.findByEmail(user.getEmail());
        if (foundUser != null) {
            return Response.setError("User allready in databse!");
        } else {
            user.setRole(roleType.ROLE_USER);
            user.setCurrentPassword(encoder.encode(user.getCurrentPassword()));
            userDao.save(user);
            return Response.setSuccess("Registration succsessful!");
        }
    }

    @RequestMapping(value = "/login", method = {RequestMethod.POST, RequestMethod.GET})
    public HashMap<String, String> loginUser(@RequestBody final User user) {
        final User foundUser = userDao.findByEmail(user.getEmail());
        if (foundUser == null || !encoder.matches(user.getCurrentPassword(), foundUser.getCurrentPassword())) {
            return Response.setError("Bad credentials");
        } else {
            final UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(
                    user.getEmail(), user.getCurrentPassword(), AuthorityUtils.createAuthorityList(foundUser.getRole()
                            .name()));
            final Authentication authentication = authenticationManager.authenticate(authRequest);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            return Response.setSuccess(foundUser.getRole().name());
        }
    }

    @RequestMapping(value = "/changePassword/{newPassword}/{currentPassword}", method = RequestMethod.GET)
    public HashMap<String, String> changePassword(@PathVariable("newPassword") String newPassword, @PathVariable("currentPassword") String currentPassword) {
        final User foundUser = userDao.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
        if (encoder.matches(currentPassword, foundUser.getCurrentPassword())) {
            foundUser.setCurrentPassword(encoder.encode(newPassword));
            userDao.save(foundUser);
            return Response.setSuccess("Password changed successfully!");
        } else {
            return Response.setError("Save user FAILED!");
        }
    }
}
