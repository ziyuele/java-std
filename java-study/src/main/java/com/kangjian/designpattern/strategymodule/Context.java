package com.kangjian.designpattern.strategymodule;

public class Context {
    private String name;
    private Strategy strategy;
    private int winCount;
    private int loseCount;
    private int gameCount;

    public Context(String name, Strategy strategy) {
        this.name = name;
        this.strategy = strategy;
    }

    public Head nextHand() {
       return strategy.nextHead();
    }

    public void win() {
        strategy.study(true);
        winCount ++;
        gameCount ++;
    }

    public void lose() {
        strategy.study(false);
        loseCount ++;
        gameCount ++;
    }

    public void even() {
        gameCount ++;
    }

    @Override
    public String toString() {
        return "Context{" +
                "name='" + name + '\'' +
                ", strategy=" + strategy +
                ", winCount=" + winCount +
                ", loseCount=" + loseCount +
                ", gameCount=" + gameCount +
                '}';
    }
}

