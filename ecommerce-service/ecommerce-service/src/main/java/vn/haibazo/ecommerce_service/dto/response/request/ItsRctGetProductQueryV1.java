package vn.haibazo.ecommerce_service.dto.response.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItsRctGetProductQueryV1 {
    private List<Integer> variantIds ;
    private double priceMin ;
    private double priceMax ;
    private List<Double> categoryIds ;
    private String sortBy ;
    private String orderBy ;
    private String search ;
}
