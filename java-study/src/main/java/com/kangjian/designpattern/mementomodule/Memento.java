package com.kangjian.designpattern.mementomodule;

import java.util.ArrayList;
import java.util.List;


/**
 * Memento 角色
 */
public class Memento {
     int money;
    private ArrayList<String> fruits;

    public Memento(int money) {  // wide interface
        this.money = money;
        this.fruits = new ArrayList<>();
    }

    void addFruits(String furit) {  // wide interface
        this.fruits.add(furit);
    }

    List<String> getFruits() {  //narrow interface
        return (List) fruits.clone();
    }
}
