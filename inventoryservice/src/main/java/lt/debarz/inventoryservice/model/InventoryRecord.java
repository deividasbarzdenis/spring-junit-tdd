package lt.debarz.inventoryservice.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class InventoryRecord implements Serializable {
    private Integer productId;
    private Integer quantity;
    private String productName;
    private String productCategory;
}
