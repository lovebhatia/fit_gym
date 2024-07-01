package com.gym.fit.dto;

import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "gymfit")
public record GymfitInfo(String message, Map<String, String> contactDetails, List<String> onCallSupport) {
	
	

}
