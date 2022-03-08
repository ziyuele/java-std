package com.kangjian.designpattern.compositemodule;

public abstract class Component {
    abstract String getName();
    abstract int getSize();

    public Component add(Component component) {
        throw new UnsupportedOperationException();
    }

    public void printList() {
        System.out.println("");
    }

    protected abstract void printList(String prefix);

    public String toString() {
        return getName() + "[" + getSize() + "]";
    }
}
