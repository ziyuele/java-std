package com.kangjian.designpattern.templatemethodmodule;

public class Main {
    public static void main(String args[]) {
        AbstractDisplay display = new CharDisplay('h');
        display.display();
        AbstractDisplay stringDisplay = new StringDisplay("test");
        stringDisplay.display();
    }
}
