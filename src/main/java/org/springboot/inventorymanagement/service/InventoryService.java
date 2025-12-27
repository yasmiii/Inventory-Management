package org.springboot.inventorymanagement.service;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springboot.inventorymanagement.dto.InventoryDto;
import org.springboot.inventorymanagement.entity.Inventory;
import org.springboot.inventorymanagement.repo.InventoryRepo;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class InventoryService {

    private ModelMapper modelMapper;
    private InventoryRepo inventoryRepo;

    public InventoryService(ModelMapper modelMapper, InventoryRepo inventoryRepo) {
        this.modelMapper = modelMapper;
        this.inventoryRepo = inventoryRepo;
    }

    public InventoryDto getInventoryById(int id) {
        return modelMapper.map(inventoryRepo.findById(id).orElse(null), InventoryDto.class);
    }

    public List<InventoryDto> getAllInventories() {
        List<Inventory> inventoryList = inventoryRepo.findAll();
        return modelMapper.map(inventoryList, new TypeToken<List<InventoryDto>>(){}.getType());
    }

    public InventoryDto createInventory(InventoryDto inventoryDto){
        Inventory inventory = modelMapper.map(inventoryDto, Inventory.class);
        Inventory savedInventory = inventoryRepo.save(inventory);
        return modelMapper.map(savedInventory, InventoryDto.class);
    }

    public InventoryDto updateInventory(int id, InventoryDto inventoryDto){
        Inventory existingInventory = inventoryRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Inventory not found with id: " + id));

        existingInventory.setProductId(inventoryDto.getProductId());
        existingInventory.setQuantity(inventoryDto.getQuantity());
        existingInventory.setItemId(inventoryDto.getItemId());
        inventoryRepo.save(existingInventory);
        return modelMapper.map(existingInventory, InventoryDto.class);
    }

    public String deleteInventory(int id) {
        if (!inventoryRepo.existsById(id)) {
            throw new RuntimeException("Inventory not found with ID: " + id);
        }
        inventoryRepo.deleteById(id);
        return "Inventory deleted";
    }


}
