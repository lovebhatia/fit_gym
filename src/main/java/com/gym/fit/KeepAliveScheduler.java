package com.gym.fit;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class KeepAliveScheduler {

    private final RestTemplate restTemplate = new RestTemplate();
    private static final String HEALTH_CHECK_URL = "https://midyear-courage-427209-f3.et.r.appspot.com/api/health";

    @Scheduled(fixedRate = 120000) // 5 minutes in milliseconds
    public void keepAlive() {
        try {
            System.out.println("in keepAlive");
            restTemplate.getForObject(HEALTH_CHECK_URL, String.class);
        } catch (Exception e) {
            // Handle exceptions (e.g., log the error)
            System.out.println("Error pinging health check endpoint: " + e.getMessage());
        }
    }
}