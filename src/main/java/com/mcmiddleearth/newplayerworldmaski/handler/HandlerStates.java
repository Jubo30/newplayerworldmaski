package com.mcmiddleearth.newplayerworldmaski.handler;

public enum HandlerStates {

    ONE     (1),
    TWO     (2),
    THREE   (3),
    FOUR    (4);

    private final Integer state;

    HandlerStates(Integer state){
        this.state = state;
    }
}
