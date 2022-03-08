package com.kangjian.designpattern.compositemodule;

public class Client {
    public static void main(String[] args) {
        Composite composite = new Composite("hhhhh");
        Composite composite1 = new Composite("aaaa");
        Leaf leaf = new Leaf("leaf1", 2);
        Leaf leaf1 = new Leaf("leaf2", 3);

        composite.add(composite1);
        composite.add(leaf);
        composite.add(leaf1);

        composite.printList(".");
    }

}
