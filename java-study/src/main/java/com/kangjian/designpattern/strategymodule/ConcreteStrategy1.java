package com.kangjian.designpattern.strategymodule;

import java.util.Random;

public class ConcreteStrategy1 implements Strategy {

    private Random random;
    private boolean won = false;
    private Head preHead;

    public ConcreteStrategy1(int  seed) {
        this.random = new Random(seed);
    }

    @Override
    public Head nextHead() {
        if (!won) {
           preHead = Head.getHead(random.nextInt(3));
        }

        return preHead;
    }

    @Override
    public void study(boolean win) {
        won = win;
    }
}
