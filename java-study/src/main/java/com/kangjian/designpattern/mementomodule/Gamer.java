package com.kangjian.designpattern.mementomodule;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;


/**
 * Originator 角色
 */
public class Gamer {
    private int money;
    private List<String> fruits = new ArrayList<>();
    private Random random = new Random();
    private static String[] fruitNames = {
            "苹果", "葡萄", "香蕉", "橘子"
    };

    public Gamer(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void bet() {
        int dice = random.nextInt(6) + 1;
        if (dice == 1) {
            money += 100;
            System.out.println("所持有的金钱增加了。");
        } else if (dice == 2) {
            money /= 2;
            System.out.println("所持有的钱减半了。");
        } else if (dice == 6) {
            String f = getFruit();
            System.out.println("获得了水果:" + f);
            fruits.add(f);
        } else {
            System.out.println("什么都没发生");
        }
    }

    public Memento createMento() {
        Memento memento = new Memento(money);
        Iterator<String> iterator = fruits.iterator();
        while (iterator.hasNext()) {
            String f = iterator.next();
            if (f.startsWith("好吃的")) {
                memento.addFruits(f);
            }
        }
        return memento;
    }

    public void restoreMemento(Memento memento) {
        this.money = memento.money;
        this.fruits = memento.getFruits();
    }

    private String getFruit() {
        String prefix = "";
        if (random.nextBoolean()) {
            prefix = "好吃的";
        }
        return prefix + fruitNames[random.nextInt(fruitNames.length)];
    }

    @Override
    public String toString() {
        return "{" +
                "money:" + money +
                ", fruits:" + fruits +
                '}';
    }
}
