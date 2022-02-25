package com.kangjian.designpattern.abstractfactorymodule;

import java.util.Iterator;

public class ConceteProduct extends AbstractProduct {

    public ConceteProduct(String title, String author) {
        super(title, author);
    }

    @Override
    String makeHtml() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("<html><head><title>" + title + "</title></head>\n");
        buffer.append("<body>\n<h1>" + title + "</h1>\n <ul>\n");
        Iterator iterator = content.iterator();
        while (iterator.hasNext()) {
           Item item = (Item) iterator.next();
           buffer.append(item.makeHtml());
        }

        buffer.append("</ul>\n<hr><address>" + author + "</address></body></html>");
        return buffer.toString();
    }
}
