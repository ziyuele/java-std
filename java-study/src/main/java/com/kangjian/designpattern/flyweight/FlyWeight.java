package com.kangjian.designpattern.flyweight;

public class FlyWeight {

    private static final String numOne = " ___  \n" +
            "|_  | \n" +
            "  | | \n" +
            "  | | \n" +
            "  | | \n" +
            "  |_| ";

    private static final String numTwo = " _____  \n" +
            "/___  \\ \n" +
            " ___| | \n" +
            "/  ___/ \n" +
            "| |___  \n" +
            "|_____| ";

    private static final String numThree = " _____  \n" +
            "|___  | \n" +
            "   _| | \n" +
            "  |_  { \n" +
            " ___| | \n" +
            "|_____/ ";

    private char charName;

    private String fontData;
    public FlyWeight(char charName) {
        this.charName = charName;
        try {
            if (charName == '1') {
                fontData = numOne;
            } else if (charName == '2') {
                fontData = numTwo;
            } else if (charName == '3') {
                fontData = numThree;
            } else {
                fontData = "?";
            }
        } catch (Exception e) {
            // ignore
        }
    }

    public void print() {
        System.out.println(fontData);
    }
}
