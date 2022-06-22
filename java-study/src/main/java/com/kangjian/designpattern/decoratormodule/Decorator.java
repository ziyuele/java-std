package com.kangjian.designpattern.decoratormodule;

public abstract class Decorator extends Component {

    protected Component component;

    public Decorator(Component component) {
        this.component = component;
    }
}
