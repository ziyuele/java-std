package com.kangjian.designpattern.strategymodule;

import java.util.Random;

public class ConcreteStrategy2 implements Strategy {

    private Random random;
    private int preHeadValue = 0;
    private int currentHeadValue = 0;
    private int[][] history = {
            {1,1,1},
            {1,1,1},
            {1,1,1}
    };

    public ConcreteStrategy2(int seed) {
        this.random = new Random(seed);
    }

    @Override
    public Head nextHead() {
        int bet = random.nextInt(getSum(currentHeadValue));
        int handValue = 0;
        if (bet < history[currentHeadValue][0]) {
            handValue = 0;
        } else if (bet < history[currentHeadValue][0] + history[currentHeadValue][1]) {
            handValue = 1;
        } else {
            handValue = 2;
        }

        preHeadValue = currentHeadValue;
        currentHeadValue = handValue;
        return Head.getHead(handValue);
    }

    @Override
    public void study(boolean win) {
        if (win) {
            history[preHeadValue][currentHeadValue] ++;
        } else {
            history[preHeadValue][(currentHeadValue + 1) % 3] ++;
            history[preHeadValue][(currentHeadValue + 2) % 3] ++;
        }
    }

    private int getSum(int hv) {
        int sum = 0;
        for (int i = 0; i < 3; i ++) {
            sum += history[hv][i];
        }

        return sum;
    }


}
