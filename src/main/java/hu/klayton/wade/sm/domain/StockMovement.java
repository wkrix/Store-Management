package hu.klayton.wade.sm.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Walter Krix <wkrix89@gmail.com>
 */
@Entity
@Table(name = "Stock_Movements")
public class StockMovement {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Product product;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private WareHouse wareHouse;

    @Temporal(TemporalType.DATE)
    private Date creationDate;

    private int quantity;

    @Enumerated(value = EnumType.STRING)
    private Type type;

    private String description;

    public StockMovement() {
    }

    public StockMovement(Long id, String description, int quantity, Type type) {
        this.id = id;
        this.description = description;
        this.quantity = quantity;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public WareHouse getWareHouse() {
        return wareHouse;
    }

    public void setWareHouse(WareHouse wareHouse) {
        this.wareHouse = wareHouse;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
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

    public void addProduct(Product product) {
        setProduct(product);
        if (getProduct() != null) {
            getProduct().setStockMovement(this);
        }
    }

    public void addWareHouse(WareHouse wareHouse) {
        setWareHouse(wareHouse);
        if (getWareHouse() != null) {
            getWareHouse().addStockMovement(this);
        }
    }


    public enum Type {
        INCOMING,
        OUTGOING
    }

}
