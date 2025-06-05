package com.alam.Airbnb.Controller;

import com.alam.Airbnb.DTO.InventoryDTO;
import com.alam.Airbnb.DTO.UpdateInventoryDTO;
import com.alam.Airbnb.Service.Interfaces.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping("/rooms/{roomId}")
    public ResponseEntity<List<InventoryDTO>> getAllInventoryByRoom(@PathVariable Long roomId) {
        return ResponseEntity.ok(inventoryService.getAllInventoryByRoom(roomId));
    }

    @PatchMapping("/rooms/{roomId}")
    public ResponseEntity<Void> updateInventory(@PathVariable Long roomId,
                                                @RequestBody UpdateInventoryDTO updateInventoryDTO) {
        inventoryService.updateInventory(roomId, updateInventoryDTO);
        return ResponseEntity.noContent().build();
    }
}
