package org.springboot.inventorymanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class InventoryDto {
    private Integer id;
    private String itemId;
    private String productId;
    private Integer quantity;
}
