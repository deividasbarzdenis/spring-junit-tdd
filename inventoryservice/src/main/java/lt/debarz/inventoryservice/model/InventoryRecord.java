package lt.debarz.inventoryservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class InventoryRecord implements Serializable {
    private Integer productId;
    private Integer quantity;
    private String productName;
    private String productCategory;

}
