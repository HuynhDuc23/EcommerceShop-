package vn.haibazo.api_gateway.client;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.PostExchange;
import reactor.core.publisher.Mono;
import vn.haibazo.api_gateway.dto.request.IntrospectRequest;
import vn.haibazo.api_gateway.dto.response.ApiResponse;
import vn.haibazo.api_gateway.dto.response.IntrospectResponse;

@Repository
public interface IdentityClient {
    @PostExchange(url = "/auth/introspect" , contentType = MediaType.APPLICATION_JSON_VALUE)
    Mono<ApiResponse<IntrospectResponse>> introspect(@RequestBody IntrospectRequest request);
}
