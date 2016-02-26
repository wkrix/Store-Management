package hu.klayton.wade.sm.dto;

import hu.klayton.wade.sm.domain.StockMovement;
import hu.klayton.wade.sm.domain.StockMovement.Type;

/**
 * @author Walter Krix <wkrix89@gmail.hu>
 */
public class StockMovementDTO {

    private Long id;

    private Long productId;

    private Long wareHouseId;

    private int quantity;

    private Type type;

    private String description;

    public StockMovementDTO(Long id, Long productId, Long wareHouseId, int quantity, Type type, String description) {
        this.id = id;
        this.productId = productId;
        this.wareHouseId = wareHouseId;
        this.quantity = quantity;
        this.type = type;
        this.description = description;
    }

    public StockMovementDTO() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getWareHouseId() {
        return wareHouseId;
    }

    public void setWareHouseId(Long wareHouseId) {
        this.wareHouseId = wareHouseId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public StockMovement createStockMovement() {
        return new StockMovement(getId(), getDescription(), getQuantity(), getType());
    }
}
