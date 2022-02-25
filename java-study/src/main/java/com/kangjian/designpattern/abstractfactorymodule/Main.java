package com.kangjian.designpattern.abstractfactorymodule;


public class Main {
    public static void main(String[] args) {
        String factoryAddr = "com.kangjian.designpattern.abstractfactorymodule.ConcreteFactory";

        AbstractFactory factory = AbstractFactory.getFactory(factoryAddr);
        Link people = factory.createLink("人民日报", "http://www.people.com.cn");
        Tray tray = factory.createTray("日报");
        tray.add(people);

        AbstractProduct abstractProduct = factory.createProduct("测试page", "kangjian");
        abstractProduct.add(tray);
        abstractProduct.output();
    }
}
