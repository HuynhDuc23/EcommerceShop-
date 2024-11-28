package vn.haibazo.ecommerce_service.dto.response.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountRequest {
    private String username;
    private String password;
}
