package com.recipeApp.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.recipeApp.Services.EdamamService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin
@RestController
public class ApiController {

    private final EdamamService edamamService;

    public ApiController(EdamamService edamamService) {
        this.edamamService = edamamService;
    }

    @GetMapping("/recipes")
    public String getRecipes(@RequestParam String query) throws JsonProcessingException {
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
}
