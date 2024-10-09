package com.recipeApp.Services;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class EdamamService {
// id's and keys stored in application.properties. @Value tells spring to get that value and store it as a variable
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

    //method to enable search queries using spring to the api
    public String searchRecipes(String query) {
       //stores the url as a string - base url for Edamam's api requests
        String url = "https://api.edamam.com/search";
        // UriComponentsBuilder is a Spring Utility that will build Uri's
        // fromHttpUrl initializes the builder. Tells it that you will add to the end of the base url
        String uri = UriComponentsBuilder.fromHttpUrl(url)
                // q adds the String query in the parameters to the end of the search query
                // in our example from Postman, query = "chicken" adds ?q=chicken to the URL
                .queryParam("q", query)
                // queryParam for "app_id" and "app_key" is the way that Edamam expects the id's and keys to look for authentication on it's end.
                // I think this means that Spring takes our variables recipeId and tells Edamam that this should be the same as app_id. Otherwise it won't make calls for us
                .queryParam("from", 21)
                .queryParam("to", 30)
                .queryParam("app_id", recipeId)
                .queryParam("app_key", recipeKey)
                // .toUriString formats all of it so that it functions properly in the url
                .toUriString();
// This makes our GET request for the URI using restTemplate
        // we get back a String
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
