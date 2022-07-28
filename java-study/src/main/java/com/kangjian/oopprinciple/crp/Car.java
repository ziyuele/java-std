package com.kangjian.oopprinciple.crp;

public abstract class Car {

    protected Color color;

    public Car(Color color) {
        this.color = color;
    }

   public abstract void move();
}
