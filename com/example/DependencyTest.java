package com.example;

import org.slf4j.Logger;

public class DependencyTest {
    public boolean LogMe(Logger l) {
        l.debug("xxx");
        return true;
    }
}
