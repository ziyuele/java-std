package com.kangjian.designpattern.visitormodule;

import java.util.Iterator;

public class ListVisitor extends Visitor {

    private String currentDir = "";

    @Override
    public void visit(TFile file) {
        System.out.println(currentDir + "/" + file);
    }

    @Override
    public void visit(TDirectory directory) {
        System.out.println(currentDir + "/" + directory);
        String saveDir = currentDir;
        currentDir = currentDir + "/" + directory.getName();
        Iterator iterator = directory.iterator();
        while (iterator.hasNext()) {
            Entry entry = (Entry) iterator.next();
            entry.accept(this);
        }
        currentDir = saveDir;
    }
}
