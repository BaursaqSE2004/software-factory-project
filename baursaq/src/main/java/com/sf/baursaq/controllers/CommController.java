package com.sf.baursaq.controllers;

import com.sf.baursaq.services.CommService;
import com.sf.baursaq.services.RecipeService;
import com.sf.baursaq.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/comm")
public class CommController {

    private UserService userService;
    private RecipeService recipeService;
    private CommService commService;

    @Autowired
    public CommController(UserService userService, RecipeService recipeService, CommService commService){
        this.userService = userService;
        this.recipeService = recipeService;
        this.commService = commService;
    }

}
