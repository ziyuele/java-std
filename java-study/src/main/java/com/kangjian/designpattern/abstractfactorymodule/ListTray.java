package com.kangjian.designpattern.abstractfactorymodule;

import java.util.Iterator;

public class ListTray extends Tray {

    public ListTray(String caption) {
        super(caption);
    }

    @Override
    public String makeHtml() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("<li>\n");
        stringBuffer.append(caption + "\n");
        stringBuffer.append("<ul>\n");
        Iterator iterator = tray.iterator();
        while (iterator.hasNext()) {
            Item item = (Item) iterator.next();
            stringBuffer.append(item.makeHtml());
        }
        stringBuffer.append("</ul>\n");
        stringBuffer.append("</li>\n");
        return stringBuffer.toString();
    }
}
