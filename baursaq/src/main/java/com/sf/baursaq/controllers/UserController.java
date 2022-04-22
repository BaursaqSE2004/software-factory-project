package com.sf.baursaq.controllers;

import com.sf.baursaq.entity.User;
import com.sf.baursaq.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {
    private UserService userService;
    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/start-page")
    public String startPage(){
        return "start-page";
    }

    @GetMapping("/guest-recipe-list")
    public String guestRecipeList(){
        return "guest-recipe-list";
    }

    @GetMapping("/sign-in-form")
    public String signInForm(){
        return "sign-in-form";
    }

    @PostMapping("/sign-in-form")
    public String signInFormPost(User user){
        boolean result = userService.login(user);
        if (!result) return "bad";
        return "user-recipe-list";
    }

    @GetMapping("/sign-up-form")
    public String signUpForm(){
        return "sign-up-form";
    }
    @PostMapping("/sign-up-form")
    public String signUpFormPost(User user){
        boolean result = userService.createUser(user);
        if (!result) return "bad";
        return "user-recipe-list";
    }
}
