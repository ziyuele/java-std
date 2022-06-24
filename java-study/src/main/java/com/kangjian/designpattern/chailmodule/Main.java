package com.kangjian.designpattern.chailmodule;

public class Main {
    public static void main(String[] args) {
        Handler limitHander = new LimitHandler(LimitHandler.class.getSimpleName());
        Handler neverHandler = new NeverHandler(NeverHandler.class.getSimpleName());
        Handler oddHandler = new OddHandler(OddHandler.class.getSimpleName());

        limitHander.setNext(oddHandler).setNext(neverHandler);

        Trouble trouble = new Trouble(15);
        Trouble trouble1 = new Trouble(1);
        Trouble trouble2 = new Trouble(21);
        limitHander.support(trouble);
        System.out.println();
        limitHander.support(trouble1);
        System.out.println();
        limitHander.support(trouble2);
    }
}
