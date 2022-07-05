package com.olmez.ceilingfan.model.services.impl;

import org.springframework.stereotype.Service;

import com.olmez.ceilingfan.model.data.CeilingFan;
import com.olmez.ceilingfan.model.data.FanDirection;
import com.olmez.ceilingfan.model.data.FanPhase;
import com.olmez.ceilingfan.model.services.CeilingService;

@Service
public class CeilingServiceImpl implements CeilingService {

    @Override
    public CeilingFan changeFanSpeed(CeilingFan fan) {
        if (fan == null) {
            return null;
        }

        var speed = fan.getPhase();
        switch (speed) {
            case OFF:
                fan.setPhase(FanPhase.LOW);
                break;
            case LOW:
                fan.setPhase(FanPhase.MEDIUM);
                break;
            case MEDIUM:
                fan.setPhase(FanPhase.HIGH);
                break;
            default:
                fan.setPhase(FanPhase.OFF);
                break;
        }
        return fan;
    }

    @Override
    public CeilingFan changeFanDirection(CeilingFan fan) {
        if (fan == null) {
            return null;
        }

        var direction = fan.getDirection();
        if (direction == FanDirection.CLOCKWISE) {
            fan.setDirection(FanDirection.COUNTER_CLOCKWISE);
        } else {
            fan.setDirection(FanDirection.CLOCKWISE);
        }
        return fan;
    }

}
