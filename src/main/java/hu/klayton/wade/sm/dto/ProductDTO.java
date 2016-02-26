package hu.klayton.wade.sm.dto;

import hu.klayton.wade.sm.domain.Product;

import java.util.Date;

/**
 * @author Walter Krix <wkrix89@gmail.com>
 */
public class ProductDTO {


    private Long id;

    private String name;

    private String description;

    private Date creationDate;

    private Date validityDate;

    public ProductDTO() {
    }

    public ProductDTO(Long id, String name, String description, Date creationDate, Date validityDate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.validityDate = validityDate;
        this.creationDate = creationDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getValidityDate() {
        return validityDate;
    }

    public void setValidityDate(Date validityDate) {
        this.validityDate = validityDate;
    }

    public Product createProduct() {
        return new Product(getId(), getName(), getDescription(), getCreationDate(), getValidityDate());
    }

    public static ProductDTO createDTO(Product product) {
        return new ProductDTO(product.getId(), product.getName(), product.getDescription(), product.getCreationDate(), product.getValidityDate());
    }
}
