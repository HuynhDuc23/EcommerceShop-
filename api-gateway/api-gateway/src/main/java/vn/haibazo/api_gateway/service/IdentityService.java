package vn.haibazo.api_gateway.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import vn.haibazo.api_gateway.client.IdentityClient;
import vn.haibazo.api_gateway.dto.request.IntrospectRequest;
import vn.haibazo.api_gateway.dto.response.ApiResponse;
import vn.haibazo.api_gateway.dto.response.IntrospectResponse;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class IdentityService {
    IdentityClient identityClient ;
    public Mono<ApiResponse<IntrospectResponse>> introspect(String token){
        return identityClient.introspect(IntrospectRequest.builder().token(token).build());
    }
}