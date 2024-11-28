package vn.haibazo.ecommerce_service.dto.response.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItsRctMyOrderRequestV1 {
    private String firstName ;
    private String lastName ;
    private String email ;
    private String phone ;
    private String streetAddress ;
    private long countryId ;
    private long cityId ;
    private String state ;
    private String zipCode ;
    private long shippingMethodId ;
    private long paymentMethodId ;
}
