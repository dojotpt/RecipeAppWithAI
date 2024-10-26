package com.recipeApp.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.recipeApp.Services.EdamamService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class ApiController {

    private final EdamamService edamamService;

    public ApiController(EdamamService edamamService) {
        this.edamamService = edamamService;
    }

    @GetMapping("/recipes")
    public String getRecipes(@RequestParam String query) {
        return edamamService.searchRecipes(query);
    }

    @GetMapping("/nutrition")
    public String getNutrition(@RequestParam String ingredients) {
        return edamamService.analyzeNutrition(ingredients);
    }

    @GetMapping("/food-info")
    public String getFoodInfo(@RequestParam String foodId) {
        return edamamService.getFoodInfo(foodId);
    }

    @GetMapping("/recipes/{id}")
    public String getRecipeById(@PathVariable String id) {
        return edamamService.getRecipeById(id);
    }
}
