package com.kangjian.designpattern.visitormodule;

import java.util.Iterator;

public abstract class Entry implements Element {
    public abstract String getName();
    public abstract int getSize();

    public Entry add(Entry entry)  {
        throw  new RuntimeException("not support add");
    }

    public Iterator iterator()  {
        throw new RuntimeException("not support iterator");
    }

    public String toString() {
       return getName() + "(" + getSize() +  ")";
    }
}
