package com.kangjian.designpattern.visitormodule;

public class Main {

    public static void main(String[] args) {
        System.out.println("Making root entries...");
        TDirectory rootDir = new TDirectory("root");
        TDirectory binDir = new TDirectory("bin");
        TDirectory tmpDir = new TDirectory("tmp");
        TDirectory usrDir = new TDirectory("usr");

        rootDir.add(binDir);
        rootDir.add(tmpDir);
        rootDir.add(usrDir);

        binDir.add(new TFile("vi", 100));
        binDir.add(new TFile("ls", 20));

        rootDir.accept(new ListVisitor());
    }

}
