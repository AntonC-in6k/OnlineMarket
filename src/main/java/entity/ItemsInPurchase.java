package entity;

import java.math.BigDecimal;

/**
 * Created by employee on 7/22/16.
 */
public class ItemsInPurchase {

    private Integer purchaseId;
    private Integer itemId;
    private int itemsNumber;
    private BigDecimal price;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ItemsInPurchase that = (ItemsInPurchase) o;

        if (itemsNumber != that.itemsNumber) return false;
        if (!itemId.equals(that.itemId)) return false;
        return price.equals(that.price);

    }

    @Override
    public int hashCode() {
        int result = itemId.hashCode();
        result = 31 * result + itemsNumber;
        result = 31 * result + price.hashCode();
        return result;
    }

    public Integer getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Integer purchaseId) {
        this.purchaseId = purchaseId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public int getItemsNumber() {
        return itemsNumber;
    }

    public void setItemsNumber(int itemsNumber) {
        this.itemsNumber = itemsNumber;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ItemsInPurchase{" +
                "purchaseId=" + purchaseId +
                ", itemId=" + itemId +
                ", itemsNumber=" + itemsNumber +
                ", price=" + price +
                '}';
    }
}
