package com.kangjian.designpattern.bridgemodule;

public abstract class Abstraction {
    private Implementor implementor;

    public Abstraction(Implementor implementor) {
        this.implementor = implementor;
    }

    public void open() {
        implementor.rawOpen();
    }

    public void print() {
        implementor.print();;
    }

    public void close() {
        implementor.close();
    }

    public final void display() {
        open();
        print();
        close();
    }
}
