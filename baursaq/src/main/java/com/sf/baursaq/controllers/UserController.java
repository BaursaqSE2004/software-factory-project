package com.sf.baursaq.controllers;

import com.sf.baursaq.entity.User;
import com.sf.baursaq.services.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Hidden;
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
        User userRequest = userService.returnUser(user);
        return "redirect:/user/cabinet/" + userRequest.getUser_id();
    }

    @GetMapping("/sign-up-form")
    public String signUpForm(){
        return "sign-up-form";
    }
    @PostMapping("/sign-up-form")
    public String signUpFormPost(User user){
        boolean result = userService.createUser(user);
        if (!result) return "bad";
        return "redirect:/user/cabinet/" + user.getUser_id();
    }

    @GetMapping("/cabinet/{id}")
    public String cabinet(@PathVariable("id") Long user_id, Model model){
        User user = userService.findById(user_id);
        model.addAttribute("user", user);
        return "cabinet";
    }

}
