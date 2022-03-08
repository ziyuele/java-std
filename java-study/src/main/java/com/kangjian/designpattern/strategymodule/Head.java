package com.kangjian.designpattern.strategymodule;

public class Head {
    public static final int HANDVALUE_GUU  = 0; // 表示石头的值
    public static final int HENDVALUE_CUO = 1; // 表示剪刀的值
    public static final int HANDVALUE_PAA = 2; // 表示布的值

    private int handValue;

    public static final Head[] hand = {
            new Head(HANDVALUE_GUU),
            new Head(HENDVALUE_CUO),
            new Head(HANDVALUE_PAA)
    };

    private static final String[] name = {
            "石头", "剪刀", "布"
    };


    private Head(int handValue) {
        this.handValue = handValue;
    }

    public static Head getHead(int handValue) {
       return hand[handValue];
    }

    public boolean isStrongerThan(Head h) {
        return fight(h) == 1;
    }

    public boolean isWeakerThan(Head h) {
        return fight(h) == -1;
    }

    public int fight(Head h) {
        if (this == h) {
            return 0;
        } else if ((this.handValue +1)  %3 == h.handValue) {
            return 1;
        } else {
            return -1;
        }
    }

    public String toString() {
        return name[handValue];
    }
}
