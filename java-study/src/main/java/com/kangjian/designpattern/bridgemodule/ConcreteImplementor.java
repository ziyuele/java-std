package com.kangjian.designpattern.bridgemodule;

public class ConcreteImplementor implements Implementor {

    private String string;
    private int width;

    public ConcreteImplementor(String string) {
        this.string = string;
        this.width = string.getBytes().length;
    }

    @Override
    public void rawOpen() {
        printLine();
    }

    @Override
    public void print() {
        System.out.println("|" + string + "|");
    }

    @Override
    public void close() {
        printLine();
    }

    private void printLine() {
        System.out.print("+");
        for (int a = 0; a < width; a ++) {
            System.out.print("-");
        }
        System.out.println("+");
    }
}
