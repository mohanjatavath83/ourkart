package com.ourkart.facade.populator;

public interface Populator<SOURCE,TARGET> {
    TARGET populate(SOURCE source);
}
