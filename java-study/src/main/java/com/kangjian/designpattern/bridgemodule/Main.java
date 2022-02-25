package com.kangjian.designpattern.bridgemodule;

public class Main {


    public static void main(String[] args) {
        Abstraction abstraction = new Abstraction(new ConcreteImplementor("hello, word")) {};

        RefinedAbstraction refinedAbstraction = new RefinedAbstraction(new ConcreteImplementor("hello, word")) {};
        abstraction.display();
        refinedAbstraction.display();
        refinedAbstraction.multiDisplay(4);
    }
}

