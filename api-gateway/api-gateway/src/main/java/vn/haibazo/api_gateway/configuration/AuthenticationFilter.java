package vn.haibazo.api_gateway.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import vn.haibazo.api_gateway.client.IdentityClient;
import vn.haibazo.api_gateway.service.IdentityService;

import java.util.Arrays;
import java.util.List;

@Component
public class AuthenticationFilter implements GlobalFilter , Ordered {
    private static final Logger log = LoggerFactory.getLogger(AuthenticationFilter.class);
    @Autowired
    IdentityService identityService ;

//    private final String[] PUBLIC_ENDPOINTS = {"/account-service/auth/register","/account-service/auth/login"};

    private final String[] PUBLIC_ENDPOINTS = {"/account-service/auth/login"};

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // check endpoint có phublic hay không ?
        // nêu có thì cho đi tiếp bỏ qua trường hợp check token
        // nếu không là pulic -> chain check token
        if(isPublicEndpoint(exchange.getRequest())){
            log.info("Allow public endpoint: {}", exchange.getRequest().getURI().getPath());
            return chain.filter(exchange);
        }
        // Get token from authorization header
        List<String> authHeader = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION);
        if (CollectionUtils.isEmpty(authHeader)) {
            log.error("Missing authorization header");
            // Return unauthorized response
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }
        // Extract the token (assuming Bearer token)
        String token = authHeader.get(0).substring(7); // (Bearer )
        log.info("token: {}",token);
        // get token
        return identityService.introspect(token).flatMap(introspectResponseApiResponse -> {
            if (introspectResponseApiResponse.getResult().isValid()) {
                return chain.filter(exchange);
            } else {
                log.error("Invalid token");
                exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                return exchange.getResponse().setComplete();
            }
        }).onErrorResume(e -> {
            log.error("Error during token introspection", e);
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        });
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

