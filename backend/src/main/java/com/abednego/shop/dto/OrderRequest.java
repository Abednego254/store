package com.abednego.shop.dto;

import lombok.Data;
import java.util.List;

@Data
public class OrderRequest {
    private Long customerId;
    private List<OrderProductDTO> products;

    @Data
    public static class OrderProductDTO {
        private Long productId;
        private int quantity;
    }
}
