package entity;

import java.math.BigDecimal;

/**
 * Created by Mr_Blame on 21.07.2016.
 */
public class Item {
    private Integer itemId;
    private String itemName;
    private Integer categoryId;
    private BigDecimal cost;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (!itemName.equals(item.itemName)) return false;
        if (!categoryId.equals(item.categoryId)) return false;
        return cost.equals(item.cost);

    }

    @Override
    public int hashCode() {
        int result = itemName.hashCode();
        result = 31 * result + categoryId.hashCode();
        result = 31 * result + cost.hashCode();
        return result;
    }

    public Integer getItemId() {
        return itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

}
