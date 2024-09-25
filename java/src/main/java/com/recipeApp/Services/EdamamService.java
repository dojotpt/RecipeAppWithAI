package com.recipeApp.Services;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class EdamamService {

    @Value("${edamam.nutrition.id}") private String nutritionId;
    @Value("${edamam.nutrition.key}") private String nutritionKey;
    @Value("${edamam.recipe.id}") private String recipeId;
    @Value("${edamam.recipe.key}") private String recipeKey;
    @Value("${edamam.food.id}") private String foodId;
    @Value("${edamam.food.key}") private String foodKey;

    private final RestTemplate restTemplate;

    public EdamamService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String searchRecipes(String query) {
        String url = "https://api.edamam.com/search";
        String uri = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("q", query)
                .queryParam("app_id", recipeId)
                .queryParam("app_key", recipeKey)
                .toUriString();
        return restTemplate.getForObject(uri, String.class);
    }

    public String analyzeNutrition(String ingredients) {
        String url = "https://api.edamam.com/api/nutrition-data";
        String uri = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("ingr", ingredients)
                .queryParam("app_id", nutritionId)
                .queryParam("app_key", nutritionKey)
                .toUriString();
        return restTemplate.getForObject(uri, String.class);
    }

    public String getFoodInfo(String foodId) {
        String url = "https://api.edamam.com/api/food-database/v2/parser";
        String uri = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("ingr", foodId)
                .queryParam("app_id", this.foodId)
                .queryParam("app_key", this.foodKey)
                .toUriString();
        return restTemplate.getForObject(uri, String.class);
    }
}
