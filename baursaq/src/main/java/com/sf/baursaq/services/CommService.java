package com.sf.baursaq.services;

import com.sf.baursaq.repository.CommRepository;
import com.sf.baursaq.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommService {

    private final RecipeRepository recipeRepository;
    private final CommRepository commRepository;

    @Autowired
    public CommService(RecipeRepository recipeRepository, CommRepository commRepository){
        this.recipeRepository = recipeRepository;
        this.commRepository = commRepository;
    }

}
