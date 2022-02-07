package lt.debarz.inventoryservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents a quantity of a product that was purchased, so that the Inventory Manager can update its inventory accordingly.
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PurchaseRecord {
    private Integer productId;
    private Integer quantityPurchased;
}
