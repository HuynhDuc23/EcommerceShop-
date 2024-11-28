package vn.haibazo.ecommerce_service.dto.response.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItsRctSignUpRequestV1 {
    private String username ;
    private String password;
    private String name ;
    private String email ;
}
