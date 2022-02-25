package com.kangjian.designpattern.abstractfactorymodule;

public class ConcreteFactory extends AbstractFactory {


    @Override
    Link createLink(String caption, String url) {
        return new ListLink(caption, url);
    }

    @Override
    Tray createTray(String caption) {
        return new ListTray(caption);
    }

    @Override
    AbstractProduct createProduct(String title, String author) {
        return new ConceteProduct(title, author);
    }
}
