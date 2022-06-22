package com.kangjian.designpattern.decoratormodule;

public class ConcreteComponent extends Component {
    private String str;

    public ConcreteComponent(String str) {
        this.str = str;
    }

    @Override
    public int getColumns() {
        return str.getBytes().length;
    }

    @Override
    public int getRows() {
        return 1;
    }

    @Override
    public String getRowText(int row) {
        if (row == 0) {
            return str;
        }
        else {
            return null;
        }
    }
}
