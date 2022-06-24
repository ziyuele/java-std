package com.kangjian.designpattern.chailmodule;

public class LimitHandler extends Handler {

    public LimitHandler(String name) {
        super(name);
    }

    @Override
    protected boolean resloulve(Trouble t) {
        return t.getData() < 10;
    }
}
