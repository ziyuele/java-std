package com.kangjian.designpattern.abstractfactorymodule;


import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;

public abstract class AbstractProduct {

    protected String title;
    protected String author;
    protected ArrayList<Item> content = new ArrayList<>();

    public AbstractProduct(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public void add(Item item) {
        content.add(item);
    }

    public void output() {
        try {
//            String fileName = title + ".html";
//            Writer writer = new FileWriter(fileName);
//            writer.write(this.makeHtml());
//            writeriter.close();
            System.out.println(this.makeHtml());
        } catch (Exception e) {
            // ignore
        }

    }

    abstract String makeHtml();
}
