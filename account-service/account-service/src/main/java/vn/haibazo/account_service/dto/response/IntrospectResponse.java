package vn.haibazo.account_service.dto.response;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IntrospectResponse {
    private boolean valid;
}
