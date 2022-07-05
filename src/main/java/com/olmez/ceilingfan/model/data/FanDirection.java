package com.olmez.ceilingfan.model.data;

public enum FanDirection {
    CLOCKWISE("Clockwise"), COUNTER_CLOCKWISE("Counter Clockwise");

    private String label;

    private FanDirection(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }

}
