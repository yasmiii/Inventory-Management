package org.springboot.inventorymanagement.controller;

import org.springboot.inventorymanagement.dto.InventoryDto;
import org.springboot.inventorymanagement.service.InventoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/")

public class InvenrotyController {

    private InventoryService inventoryService;

    @GetMapping("/getAllInventries")
    public List<InventoryDto> getAllInventries(){
        return inventoryService.getAllInventories();
    }

    @PostMapping("/addInventory")
    public InventoryDto addInventory(@RequestBody InventoryDto inventoryDto){
        return inventoryService.createInventory(inventoryDto);
    }

    @PutMapping("/updateInventory/{inventoryId}")
    public InventoryDto updateInventory(@PathVariable Integer inventoryId, @RequestBody InventoryDto inventoryDto) {
        return inventoryService.updateInventory(inventoryId, inventoryDto);
    }

    @DeleteMapping("deleteInventory/{inventoryId}")
    public String deleteInventory(@PathVariable Integer inventoryId) {
        return inventoryService.deleteInventory(inventoryId);
    }
}
