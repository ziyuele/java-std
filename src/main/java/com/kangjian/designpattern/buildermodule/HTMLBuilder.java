/*
 * Copyright (c) 2019. website www.ziyuele.com
 */

package com.kangjian.designpattern.buildermodule;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class HTMLBuilder extends Builder {

    private String fileName;
    private PrintWriter writer;

    @Override
    public void makeTitle(String title) {
      fileName = title + ".html";
      try {
          writer = new PrintWriter(new FileWriter(fileName));
      } catch (IOException e) {
          e.printStackTrace();
      }
      writer.println("<html><head><title>" + title +"</title></head><body>");
      writer.println("<h1>" + title + "</h1>");
    }

    @Override
    public void makeString(String string) {
        writer.println("<p>" + string + "</p>");
    }

    @Override
    public void makeItems(String[] items) {
        writer.println("<ul>");
        for (String item : items) {
            writer.println("<li>"  + item + "</li>");
        }
        writer.println("</ul>");
    }

    @Override
    public void close() {
        writer.println("</body></html>");
        writer.close();
    }

    public String getResult() {
        return fileName;
    }
}
