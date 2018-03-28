package com.chariot.totoro.controller;

import com.chariot.totoro.domain.User;
import com.chariot.totoro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.security.Principal;

/**
 * Created by Trung Vu on 2018/03/28.
 */
@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/current", method = RequestMethod.POST)
    public Principal getUser(Principal principal) {
        return principal;
    }

    /**
     * Check user's roles and scope before executing action
     *
     * @param user user information
     */
    @PreAuthorize("#oauth2.hasScope('Server')")
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public void createUser(@Valid @RequestBody User user) {
        userService.createUser(user);
    }
}
