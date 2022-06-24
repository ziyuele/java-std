package com.kangjian.designpattern.chailmodule;

public class OddHandler extends Handler {

    public OddHandler(String name) {
        super(name);
    }

    @Override
    protected boolean resloulve(Trouble t) {
        return t.getData() > 20;
    }
}

