package com.formation.controller;

import com.formation.model.User;
import com.formation.model.UserStatus;
import com.formation.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Chris on 23/10/14.
 */
@RequestMapping("user")
@Controller
public class UserController {
    public static final String USERS_LIST = "/user/list";
    public static final String USERS_FORM = "/user/form";

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;


    @RequestMapping("list")
    public String getAllUsers(Model model) {
        logger.info("getAllUsers");

        Iterable<User> allUsers = userService.getAllUsers();
        model.addAttribute("users", allUsers);
        return USERS_LIST;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String userForm(Model model) {
        logger.info("userForm");

        model.addAttribute("user", new User());
        return USERS_FORM;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String createUser(@Valid User user, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return USERS_FORM;
        }
        logger.info("createUser");

        userService.saveUser(user);
        return redirectToUserList();
    }

    @RequestMapping("update/{userId}")
    public String updateUser(@PathVariable Long userId, Model model) {
        logger.info("updateUser");

        User user = userService.getUser(userId);
        if(user == null){
            return redirectToUserList();
        }
        model.addAttribute("user", user);
        return USERS_FORM;
    }

    @RequestMapping("delete/{userId}")
    public String delete(@PathVariable Long userId){
        logger.info("delete");

        User user = userService.getUser(userId);
        if(user == null){
            return redirectToUserList();
        }
        return redirectToUserList();
    }

    @RequestMapping("status")
    public @ResponseBody List<UserStatus> getAllStatus(){
        logger.info("getAllStatus");
        return Arrays.asList(UserStatus.values());
    }

    private String redirectToUserList() {
        return "redirect:" + USERS_LIST;
    }

}
