package com.kangjian.designpattern.interpretermodule;

import java.text.ParseException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ParseException {
        // TODO 使用控制台输入。
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            Node node = new ProgramNode();
            node.parse(new Context(scanner.nextLine()));
            System.out.println("node=" + node);
        }
    }
}
