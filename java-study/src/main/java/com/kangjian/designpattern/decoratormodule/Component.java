package com.kangjian.designpattern.decoratormodule;

public abstract class Component {
    public abstract int getColumns();
    public abstract int getRows();
    public abstract String getRowText(int row);

    public final void show() {
        for (int a = 0; a < getRows(); a ++) {
            System.out.println(getRowText(a));
        }
    }
}
