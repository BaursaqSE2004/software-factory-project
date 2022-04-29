package com.sf.baursaq.controllers;

import com.sf.baursaq.entity.Recipe;
import com.sf.baursaq.entity.User;
import com.sf.baursaq.services.CommService;
import com.sf.baursaq.services.RecipeService;
import com.sf.baursaq.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/recipe")
public class RecipeController {

    private UserService userService;
    private RecipeService recipeService;
    private CommService commService;

    @Autowired
    public RecipeController(UserService userService, RecipeService recipeService, CommService commService){
        this.userService = userService;
        this.recipeService = recipeService;
        this.commService = commService;
    }

    @GetMapping("/guest-recipe-list")
    public String getRecipes(Model model){
        List<Recipe> recipes = recipeService.getRecipes();
        model.addAttribute("recipes", recipes);
        return "guest-recipe-list";
    }

    @GetMapping("/user-recipe-list/{id}")
    public String getRecipesUser(Model model, @PathVariable("id") Long userId){
        List<Recipe> recipes = recipeService.getRecipes();
        model.addAttribute("recipes", recipes);
        model.addAttribute("id", userId);
        return "user-recipe-list";
    }

    @GetMapping("/recipe-creation/{id}")
    public String createRecipeForm(@PathVariable("id") Long userId, Model model){
        User user = userService.findById(userId);
        model.addAttribute("user", user);
        model.addAttribute("note", new Recipe());
        return "recipe-creation";
    }
    @PostMapping("/recipe-creation/{id}")
    public String createRecipeFormPost(@PathVariable("id") Long userId, Recipe recipe){
        boolean result = recipeService.create(recipe, userId);
        if (result) return "redirect:/user/cabinet/" + userId;
        else return "bad";
    }

    @GetMapping("delete-recipe/{userId}/{title}")
    public String deleteRecipe(@PathVariable("userId") Long userId, @PathVariable("title") String title){
        recipeService.deleteRecipe(userId, title);
        return "redirect:/user/cabinet/" + userId;
    }

}
