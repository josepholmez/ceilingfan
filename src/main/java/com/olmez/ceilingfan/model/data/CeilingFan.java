package com.olmez.ceilingfan.model.data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators.PropertyGenerator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonIdentityInfo(generator = PropertyGenerator.class, property = "id")
public class CeilingFan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonFilter("CeilingFanFilter")
    private Long id;
    private FanPhase phase = FanPhase.OFF;
    private FanDirection direction = FanDirection.CLOCKWISE;

    public void setPhase(FanPhase phase) {
        this.phase = phase;
        // The fan direction should be adjusted clockwise while the fan turn on and off.
        if (phase == FanPhase.OFF || phase == FanPhase.LOW) {
            this.direction = FanDirection.CLOCKWISE;
        } 
    }

}
