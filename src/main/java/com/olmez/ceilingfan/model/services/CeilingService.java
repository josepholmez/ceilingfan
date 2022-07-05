package com.olmez.ceilingfan.model.services;

import com.olmez.ceilingfan.model.data.CeilingFan;
import com.olmez.ceilingfan.model.data.FanPhase;

/**
 * This allows changing the speed and direction of the ceiling fan.
 */
public interface CeilingService {

    /**
     * This allows increasing the fan speed by one phase. If the fan speed is 3
     * {@link FanPhase.HIGH}, the fan is turned off.
     * 
     * @param fan
     * @return {@link CeilingFan#getPhase()} with updated speed.
     */
    CeilingFan changeFanSpeed(CeilingFan fan);

    /**
     * This allows changing the fan direction ({@link FanDirection.CLOCKWISE} or
     * {@link FanDirection.COUNTER_CLOCKWISE}).
     * 
     * @param fan
     * @return {@link CeilingFan} with updated direction.
     */
    CeilingFan changeFanDirection(CeilingFan fan);

}
