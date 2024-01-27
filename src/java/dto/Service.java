/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author PC
 */
public class Service {
    private int id;
    private String name;
    private String details;
    private float minimumWeight;
    private float maximumWeight;
    private float price;
    private boolean isDisable;

    public Service() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public float getMinimumWeight() {
        return minimumWeight;
    }

    public void setMinimumWeight(float minimumWeight) {
        this.minimumWeight = minimumWeight;
    }

    public float getMaximumWeight() {
        return maximumWeight;
    }

    public void setMaximumWeight(float maximumWeight) {
        this.maximumWeight = maximumWeight;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean isIsDisable() {
        return isDisable;
    }

    public void setIsDisable(boolean isDisable) {
        this.isDisable = isDisable;
    }
    
}
