package lt.debarz.inventoryservice.web;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lt.debarz.inventoryservice.model.PurchaseRecord;
import lt.debarz.inventoryservice.service.InventoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getInventoryRecord(@PathVariable Integer id) {

        return inventoryService.getInventoryRecord(id)
                .map(inventoryRecord -> {
                    try {
                        return ResponseEntity
                                .ok()
                                .location(new URI("/inventory/" + inventoryRecord.getProductId()))
                                .body(inventoryRecord);
                    } catch (URISyntaxException e) {
                        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
                    }
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/purchase-record")
    public ResponseEntity<?> addPurchaseRecord(@RequestBody PurchaseRecord purchaseRecord) {
        log.info("Creating new purchase record: {}", purchaseRecord);

        return inventoryService.purchaseProduct(purchaseRecord.getProductId(), purchaseRecord.getQuantityPurchased())
                .map(inventoryRecord -> {
                    try {
                        return ResponseEntity
                                .ok()
                                .location(new URI("/inventory/" + inventoryRecord.getProductId()))
                                .body(inventoryRecord);
                    } catch (URISyntaxException e) {
                        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
                    }
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
