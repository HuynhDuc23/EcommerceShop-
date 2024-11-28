package vn.haibazo.ecommerce_service.dto.response.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItsRctCollectionTypeRequestV1 {
    private String collectionType;
}
