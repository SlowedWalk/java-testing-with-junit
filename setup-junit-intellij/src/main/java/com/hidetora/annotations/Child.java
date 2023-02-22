package com.hidetora.annotations;

import java.util.logging.Logger;

public class Child extends Parent {
    Logger logger = Logger.getLogger(Child.class.getName());

    @Override
    public void doSomething() {
        logger.info("Overriding method from the parent class");
    }
}
