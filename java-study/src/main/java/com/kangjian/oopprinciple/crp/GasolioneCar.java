package com.kangjian.oopprinciple.crp;

public class GasolioneCar extends Car {

    public GasolioneCar(Color color) {
        super(color);
    }

    @Override
   public void move() {
        System.out.println(color.getColorName() + "的汽油车开动了");
    }
}
