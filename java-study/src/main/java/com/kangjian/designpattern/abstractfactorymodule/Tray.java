package com.kangjian.designpattern.abstractfactorymodule;

import java.util.ArrayList;

public abstract class Tray extends Item {
    protected String url;

    protected ArrayList<Item> tray = new ArrayList<>();
    public Tray(String caption) {
        super(caption);
    }

    public void add(Item item) {
        tray.add(item);
    }

}
