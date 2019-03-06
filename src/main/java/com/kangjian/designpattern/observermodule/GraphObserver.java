/*
 * Copyright (c) 2019. website www.ziyuele.com
 */

package com.kangjian.designpattern.observermodule;

public class GraphObserver implements Observer {

    @Override
    public void update(NumberGenerator numberGenerator) {
        System.out.println(this.getClass().getName() + ": " + numberGenerator.getNumber());
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
