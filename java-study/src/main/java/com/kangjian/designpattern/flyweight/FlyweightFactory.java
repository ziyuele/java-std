package com.kangjian.designpattern.flyweight;

import java.util.HashMap;
import java.util.Map;

public class FlyweightFactory {

    Map<Character, FlyWeight> strMap = new HashMap<>();

    private static final FlyweightFactory factory = new FlyweightFactory();
    private FlyweightFactory() {
    }

    public static FlyweightFactory getInstance() {
        return factory;
    }

    public synchronized FlyWeight getFlyweight(char charName) {
        FlyWeight flyWeight = strMap.get(charName);
        if (null == flyWeight) {
            flyWeight  = new FlyWeight(charName);
            strMap.put(charName, flyWeight);
        }
        return flyWeight;
    }
}
