package entity;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;


/**
 * Created by Mr_Blame on 21.07.2016.
 */
public class PurchaseRoster {
    private Integer purchaseId;
    private Customer customerId;
    private LocalDate localDate;
    private BigDecimal cost;

    public PurchaseRoster() {
    }

    public Integer getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Integer purchaseId) {
        this.purchaseId = purchaseId;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }
}
