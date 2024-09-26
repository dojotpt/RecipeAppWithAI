package com.recipeApp.Services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;


@Service
public class AiModelService {
    private final String AI_SERVICE_URL = "http://localhost:5000";
    private final RestTemplate restTemplate = new RestTemplate();

    public Object getPrediction(Object data) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Object> request = new HttpEntity<>(data, headers);
        return restTemplate.postForObject(AI_SERVICE_URL + "/predict", request, Object.class);
    }

    public void trainModel(Object trainingData) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Object> request = new HttpEntity<>(trainingData, headers);
        restTemplate.postForObject(AI_SERVICE_URL + "/train", request, Object.class);
    }
}
