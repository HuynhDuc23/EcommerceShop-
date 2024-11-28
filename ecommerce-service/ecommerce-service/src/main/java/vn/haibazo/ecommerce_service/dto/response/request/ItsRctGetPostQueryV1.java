package vn.haibazo.ecommerce_service.dto.response.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItsRctGetPostQueryV1 {
    private List<Integer> categoryIds;
    private String search ;
    private String orderBy ;
    private String sortBy;
}
