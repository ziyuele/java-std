package com.kangjian.designpattern.facademodule;

public class HtmlWriter {
    private String title;
    public HtmlWriter(String title) {
        this.title = title;
    }

    public void title() {
        System.out.println("<html>");
        System.out.println("    <head>");
        System.out.println("\t\t" + title);
        System.out.println("    <head/>");
        System.out.println("<html/>");
    }

    public void body(String name) {
        System.out.println("----------");
        System.out.println(name + " Welcome!!");
        System.out.println("----------");
    }
}
