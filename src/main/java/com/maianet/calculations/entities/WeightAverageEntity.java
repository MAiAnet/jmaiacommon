package com.maianet.calculations.entities;

/**
 * It represents an element for calculating the weighted average.
 * @author Mattia Zuliani
 * @version 0.0.1
 */
public class WeightAverageEntity {
    
    private double value = 0;
    private double weight = 0;
    
    public WeightAverageEntity() {}
    
    public WeightAverageEntity(double value, double weight) {
        this.value = value;
        this.weight = weight;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "[value=>" + value + ", weight=>" + weight + "]"; 
    }
    
}
