package com.kangjian.oopprinciple.crp;

public class ElectricCar extends Car {

    public ElectricCar(Color color) {
        super(color);
    }

    @Override
    public void move() {
        System.out.println(color.getColorName() + "的电动车开动了");

    }
}
