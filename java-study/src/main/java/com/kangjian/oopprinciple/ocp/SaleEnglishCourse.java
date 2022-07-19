package com.kangjian.oopprinciple.ocp;

public class SaleEnglishCourse extends EnglishCourse {

    public SaleEnglishCourse(String name, Double price, Integer type) {
        super(name, price, type);
    }

    public Double getOriginPrice() {
        return super.getPrice();
    }

    @Override
    public Double getPrice() {
        return super.getPrice() * 0.85;
    }

}
