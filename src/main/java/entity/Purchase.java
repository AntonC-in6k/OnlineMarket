package entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;


/**
 * Created by Mr_Blame on 21.07.2016.
 */
public class Purchase {
    private Integer purchaseId;
    private Integer customerId;
    private LocalDateTime localDateTime;
    private BigDecimal cost;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Purchase purchase = (Purchase) o;

        if (!customerId.equals(purchase.customerId)) return false;
        if (!localDateTime.equals(purchase.localDateTime)) return false;
        return cost.equals(purchase.cost);

    }

    @Override
    public int hashCode() {
        int result = customerId.hashCode();
        result = 31 * result + localDateTime.hashCode();
        result = 31 * result + cost.hashCode();
        return result;
    }

    public Integer getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Integer purchaseId) {
        this.purchaseId = purchaseId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "purchaseId=" + purchaseId +
                ", customerId=" + customerId +
                ", localDateTime=" + localDateTime +
                ", cost=" + cost +
                '}';
    }
}
