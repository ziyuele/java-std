package com.kangjian.designpattern.bridgemodule;

public abstract class RefinedAbstraction extends Abstraction {

    public RefinedAbstraction(Implementor implementor) {
        super(implementor);
    }

    public void multiDisplay(int times) {
        open();
        for (int a = 0; a < times; a ++) {
            print();
        }
        close();
    }
}
