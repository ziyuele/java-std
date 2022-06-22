package com.kangjian.designpattern.decoratormodule;

public class Main {

    public static void main(String[] args) {
        String name = "hello word";
        // 不使用装饰器的效果
        ConcreteComponent concreteComponent = new ConcreteComponent(name);
        concreteComponent.show();

        // 分别使用装饰器的效果
        ConcreteDecorator1 concreteDecorator1 = new ConcreteDecorator1(concreteComponent);
        concreteDecorator1.show();

        ConcreteDecorator2 concreteDecorator2 = new ConcreteDecorator2(concreteComponent);
        concreteDecorator2.show();

        // 组合使用装饰器的效果
        ConcreteDecorator2 concreteDecorator21 = new ConcreteDecorator2(new ConcreteDecorator1(new ConcreteComponent("double show")));
        concreteDecorator21.show();
        ConcreteDecorator1 concreteDecorator11 = new ConcreteDecorator1(new ConcreteDecorator2(new ConcreteComponent("double show")));
        concreteDecorator11.show();

    }
}
