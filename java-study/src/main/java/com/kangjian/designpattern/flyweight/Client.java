package com.kangjian.designpattern.flyweight;

public class Client {

    private FlyWeight[] chars;

    public Client(String s) {
        chars = new FlyWeight[s.length()];
        FlyweightFactory flyweightFactory = FlyweightFactory.getInstance();
        for (int i = 0; i < chars.length; i ++) {
            chars[i] = flyweightFactory.getFlyweight(s.charAt(i));
        }

    }

    public void print() {
        for (FlyWeight flyWeight : chars) {
            flyWeight.print();
        }
    }
}
