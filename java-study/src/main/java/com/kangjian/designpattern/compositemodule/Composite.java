package com.kangjian.designpattern.compositemodule;

import java.util.ArrayList;
import java.util.List;

public class Composite extends Component {
    private String name;
    private List<Component> components = new ArrayList<>();

    public Composite(String name) {
        this.name = name;
    }

    @Override
    String getName() {
        return name;
    }

    @Override
    int getSize() {
        return components.stream().mapToInt(Component::getSize).sum();
    }

    @Override
    protected void printList(String prefix) {
        System.out.println(prefix + "/" + this);
        components.stream().forEach(t -> t.printList(prefix + "/" + name));
    }

    @Override
    public Component add(Component component) {
        components.add(component);
        return this;
    }
}
