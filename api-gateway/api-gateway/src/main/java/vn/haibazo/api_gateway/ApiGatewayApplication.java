package vn.haibazo.api_gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;

@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}
	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder){
		return builder.routes()
				.route("account-service", r -> r.path("/account-service/account/**")
						.filters(f->f.stripPrefix(1).circuitBreaker(c->c.setName("CircuiltBreaker")))
						.uri("lb://account-service"))
				.route("ecommerce-service", r -> r.path("/ecommerce-service/ecommerce/**")
						.filters(f->f.stripPrefix(1).circuitBreaker(c->c.setName("CircuiltBreaker")))
						.uri("lb://ecommerce-service"))
				.build();
	}


}
