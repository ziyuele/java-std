package com.kangjian.designpattern.adaptermodule1;

/**
 * class adapter module
 */
public class Main {
    public static void main(String args[]){
        Print p = new PrintBander("test");
        p.printWeek();
        p.printStrong();
    }
}
