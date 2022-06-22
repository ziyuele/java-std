package com.kangjian.designpattern.visitormodule;

import java.util.ArrayList;
import java.util.Iterator;

public class TDirectory extends Entry {

    private String name;
    private int size;
    private ArrayList dir = new ArrayList();

    public TDirectory(String name) {
        this.name = name;
    }

    @Override
    public void accept(Visitor v) {
       v.visit(this);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        int size = 0;
        Iterator it = dir.iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            size += entry.getSize();
        }
        return size;
    }


    @Override
    public Entry add(Entry entry)  {
        dir.add(entry);
        return this;
    }

    @Override
    public Iterator iterator()  {
        return dir.iterator();
    }
}
