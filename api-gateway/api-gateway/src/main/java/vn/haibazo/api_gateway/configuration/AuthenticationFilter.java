package vn.haibazo.api_gateway.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Arrays;

@Component
public class AuthenticationFilter implements GlobalFilter , Ordered {
    private static final Logger log = LoggerFactory.getLogger(AuthenticationFilter.class);

    private final String[] PUBLIC_ENDPOINTS = {"/account-service/auth/register","/account-service/auth/login"};

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        if(isPublicEndpoint(exchange.getRequest())){
            return chain.filter(exchange);
        }
        log.info("Authentication");
        System.out.println(exchange.getRequest().getPath()); // /account-service/auth/register
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return -1;
    }
    private boolean isPublicEndpoint(ServerHttpRequest request) {
        log.info("Checking if endpoint is public: {}", request.getURI().getPath());
        return Arrays.stream(PUBLIC_ENDPOINTS).anyMatch(s -> request.getURI().getPath().matches(s));
    }
}

