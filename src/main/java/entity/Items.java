package entity;

import java.math.BigDecimal;

/**
 * Created by Mr_Blame on 21.07.2016.
 */
public class Items {
    private Integer itemId;
    private String itemName;
    private Category categoryId;
    private BigDecimal cost;
    private Integer numberOfSells;

    public Items() {
    }

    public Integer getItemId() {
        return itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public Category getCategoryId() {
        return categoryId;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public Integer getNumberOfSells() {
        return numberOfSells;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setCategoryId(Category categoryId) {
        this.categoryId = categoryId;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public void setNumberOfSells(Integer numberOfSells) {
        this.numberOfSells = numberOfSells;
    }
}
