package hu.klayton.wade.sm.dto;

import hu.klayton.wade.sm.domain.WareHouse;

import java.util.Date;

/**
 * @author Walter Krix <wkrix89@gmail.com>
 */
public class WareHouseDTO {


    private Long id;

    private String name;

    private String description;

    private Date creationDate;

    private Date validityDate;

    public WareHouseDTO() {
    }

    public WareHouseDTO(Long id, String name, String description, Date creationDate, Date validityDate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.creationDate = creationDate;
        this.validityDate = validityDate;
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

    public WareHouse createWareHouse() {
        return new WareHouse(getId(), getName(), getDescription(), getCreationDate(), getValidityDate());
    }

    public static WareHouseDTO createDTO(WareHouse wareHouse) {
        return new WareHouseDTO(wareHouse.getId(), wareHouse.getName(), wareHouse.getDescription(), wareHouse.getCreationDate(), wareHouse.getValidityDate());
    }
}
