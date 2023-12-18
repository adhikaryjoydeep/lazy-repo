package com.lazypractice.beans;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "STOCK_MASTER")
public class RawMateStock {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String item;
    private Double ratePerUnit;
    private Double quantity;
    private String unit;
    private Double prevValue;
    private LocalDate prevValueDate;
    private Double currValue;
    private LocalDate currValueDate;

    public RawMateStock() {
    }

    public RawMateStock(String item, Double ratePerUnit, Double quantity, String unit, Double prevValue, LocalDate prevValueDate, Double currValue, LocalDate currValueDate) {
        this.item = item;
        this.ratePerUnit = ratePerUnit;
        this.quantity = quantity;
        this.unit = unit;
        this.prevValue = prevValue;
        this.prevValueDate = prevValueDate;
        this.currValue = currValue;
        this.currValueDate = currValueDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Double getRatePerUnit() {
        return ratePerUnit;
    }

    public void setRatePerUnit(Double ratePerUnit) {
        this.ratePerUnit = ratePerUnit;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Double getPrevValue() {
        return prevValue;
    }

    public void setPrevValue(Double prevValue) {
        this.prevValue = prevValue;
    }

    public LocalDate getPrevValueDate() {
        return prevValueDate;
    }

    public void setPrevValueDate(LocalDate prevValueDate) {
        this.prevValueDate = prevValueDate;
    }

    public Double getCurrValue() {
        return currValue;
    }

    public void setCurrValue(Double currValue) {
        this.currValue = currValue;
    }

    public LocalDate getCurrValueDate() {
        return currValueDate;
    }

    public void setCurrValueDate(LocalDate currValueDate) {
        this.currValueDate = currValueDate;
    }
}
