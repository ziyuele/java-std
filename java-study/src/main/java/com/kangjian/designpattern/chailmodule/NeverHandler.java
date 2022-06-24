package com.kangjian.designpattern.chailmodule;

public class NeverHandler extends Handler {


    public NeverHandler(String name) {
        super(name);
    }


    @Override
    protected boolean resloulve(Trouble t) {
        return false;
    }
}