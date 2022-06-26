package com.kangjian.designpattern.facademodule;

public class PageFacade {

    public void makeWelcomePage() {
        DataBase dataBase = new DataBase();
        HtmlWriter htmlWriter = new HtmlWriter("Test Title page");
        String  name = dataBase.getUserName("1");
        htmlWriter.title();
        htmlWriter.body(name);
    }

    public static void main(String[] args) {
        new PageFacade().makeWelcomePage();
    }
}
