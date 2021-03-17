package com.hackerrank.orm.model;

import com.hackerrank.orm.enums.ItemStatus;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Data
@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int itemId;
    private String itemName;
    private String itemEnteredByUser;
    @CreationTimestamp
    private Timestamp itemEnteredDate;
    private double itemBuyingPrice;
    private double itemSellingPrice;
    private Date itemLastModifiedDate = new Date();
    private String itemLastModifiedByUser;
    @Enumerated(EnumType.STRING)
    private ItemStatus itemStatus = ItemStatus.AVAILABLE;


    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemEnteredByUser() {
        return itemEnteredByUser;
    }

    public void setItemEnteredByUser(String itemEnteredByUser) {
        this.itemEnteredByUser = itemEnteredByUser;
    }

    public Timestamp getItemEnteredDate() {
        return itemEnteredDate;
    }

    public void setItemEnteredDate(Timestamp itemEnteredDate) {
        this.itemEnteredDate = itemEnteredDate;
    }

    public double getItemBuyingPrice() {
        return itemBuyingPrice;
    }

    public void setItemBuyingPrice(double itemBuyingPrice) {
        this.itemBuyingPrice = itemBuyingPrice;
    }

    public double getItemSellingPrice() {
        return itemSellingPrice;
    }

    public void setItemSellingPrice(double itemSellingPrice) {
        this.itemSellingPrice = itemSellingPrice;
    }

    public Date getItemLastModifiedDate() {
        return itemLastModifiedDate;
    }

    public void setItemLastModifiedDate(Date itemLastModifiedDate) {
        this.itemLastModifiedDate = itemLastModifiedDate;
    }

    public String getItemLastModifiedByUser() {
        return itemLastModifiedByUser;
    }

    public void setItemLastModifiedByUser(String itemLastModifiedByUser) {
        this.itemLastModifiedByUser = itemLastModifiedByUser;
    }

    public ItemStatus getItemStatus() {
        return itemStatus;
    }

    public void setItemStatus(ItemStatus itemStatus) {
        this.itemStatus = itemStatus;
    }
}
