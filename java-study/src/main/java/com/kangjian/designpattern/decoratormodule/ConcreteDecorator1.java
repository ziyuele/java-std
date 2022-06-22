package com.kangjian.designpattern.decoratormodule;

public class ConcreteDecorator1 extends Decorator{
    public ConcreteDecorator1(Component component) {
        super(component);
    }

    @Override
    public int getColumns() {
        return 1 + component.getColumns() + 1;
    }

    @Override
    public int getRows() {
        return 1 + component.getRows() + 1;
    }

    @Override
    public String getRowText(int row) {
        if (row == 0) {
            return "+" + makeLine(component.getColumns(), '+') + "+";
        } else if (row == component.getRows() + 1) {
            return "+" + makeLine(component.getColumns(), '+') + "+";
        } else {
            return "+" + component.getRowText(row - 1) + "+";
        }
    }
    private String makeLine(int len, char chr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int a = 0; a < len; a ++) {
            stringBuffer.append(chr);
        }
        return stringBuffer.toString();
    }
}
