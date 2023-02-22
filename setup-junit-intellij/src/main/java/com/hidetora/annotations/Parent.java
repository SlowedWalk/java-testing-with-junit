package com.hidetora.annotations;

import java.util.logging.Logger;

public class Parent {
    Logger logger = Logger.getLogger(Child.class.getName());

    public void doSomething() {

    }

    @Deprecated
    public void doSomethingElse() {
        logger.info("Doing something else");
    }
}
