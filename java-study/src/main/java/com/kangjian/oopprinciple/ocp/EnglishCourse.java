package com.kangjian.oopprinciple.ocp;

public class EnglishCourse implements ICourse {

    private String name;
    private Double price;
    private Integer type;

    public EnglishCourse(String name, Double price, Integer type) {
        this.name = name;
        this.price = price;
        this.type = type;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Double getPrice() {
        return price;
    }

    @Override
    public Integer getType() {
        return type;
    }
}