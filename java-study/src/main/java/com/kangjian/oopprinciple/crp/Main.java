package com.kangjian.oopprinciple.crp;

public class Main {
    public static void main(String[] args) {
        new ElectricCar(new BlackColor()).move();
        new ElectricCar(new RedColor()).move();
        new GasolioneCar(new BlackColor()).move();
        new GasolioneCar(new RedColor()).move();
    }
}
