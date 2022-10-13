package com.example.k2smoney.api;

import com.example.k2smoney.api.config.property.K2smoneyApiProperty;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;

import java.util.TimeZone;

@SpringBootApplication
@EnableConfigurationProperties(K2smoneyApiProperty.class)
public class K2smoneyApiApplication {

	private static ApplicationContext APPLICATION_CONTEXT;

	public static void main(String[] args) {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
		APPLICATION_CONTEXT = SpringApplication.run(K2smoneyApiApplication.class, args);
	}

	public static <T> T getBean(Class<T> type) {
		return APPLICATION_CONTEXT.getBean(type);
	}
}
