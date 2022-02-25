package com.kangjian.designpattern.abstractfactorymodule;

public abstract class AbstractFactory {
    public static AbstractFactory getFactory(String className) {
        AbstractFactory factory = null;
        try {
            factory = (AbstractFactory) Class.forName(className).newInstance();
        }  catch (ClassNotFoundException e) {
            //ignore
        } catch (Exception e) {
            // ignore
        }
        return factory;
    }

    abstract Link createLink(String caption, String url);
    abstract Tray createTray(String caption);
    abstract AbstractProduct createProduct(String title, String author);
}
