package com.example.gateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

	@Value("${uri.userService}")
	private String userServiceUri;

	@Value("${uri.secondService}")
	private String secondServiceUri;

	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		//@formatter:off
		return builder.routes()
			.route("first", r -> r.path("**/first").uri(userServiceUri))
			.route("second", r -> r.path("**/second").uri(secondServiceUri))
			.build();
		//@formatter:on
	}

}
