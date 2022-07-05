package com.olmez.ceilingfan.model.data;

import lombok.Getter;

@Getter
public enum FanPhase {
    OFF("Off", 0), LOW("Low", 1), MEDIUM("Medium", 2), HIGH("High", 3);

    private String label;
    private int phase;

    private FanPhase(String label, int phase) {
        this.label = label;
        this.phase = phase;
    }

    @Override
    public String toString() {
        return label;
    }

}
