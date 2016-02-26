package hu.klayton.wade.sm.dto;

import hu.klayton.wade.sm.domain.StockMovement;

/**
 * @author Walter Krix <wkrix89@gmail.com>
 */
public class SummaryDTO {

    private String name;
    private int quantity;
    private StockMovement.Type type;


    public SummaryDTO(String name, int quantity, StockMovement.Type type) {
        this.name = name;
        this.quantity = quantity;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public StockMovement.Type getType() {
        return type;
    }

    public void setType(StockMovement.Type type) {
        this.type = type;
    }
}
