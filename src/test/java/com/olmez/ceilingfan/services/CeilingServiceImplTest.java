package com.olmez.ceilingfan.services;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.olmez.ceilingfan.model.data.CeilingFan;
import com.olmez.ceilingfan.model.data.FanDirection;
import com.olmez.ceilingfan.model.data.FanPhase;
import com.olmez.ceilingfan.model.services.impl.CeilingServiceImpl;

@ExtendWith(MockitoExtension.class)
class CeilingServiceImplTest {
    
    @InjectMocks
    private CeilingServiceImpl service;

   
    @Test
	void testChangeFanSpeed_NoFan_ExpectedNull() {
        // act
        var updateFan = service.changeFanSpeed(null);
        // assert
        assertThat(updateFan).isNull();
	}


    @Test
	void testChangeFanSpeed_DefaultCase_ExpectedPhaseOff() {
        // arrange
        var fan = new CeilingFan();
        // assert
        assertThat(fan.getPhase()).isEqualTo(FanPhase.OFF);
	}

    @Test
	void testChangeFanSpeed() {
        // arrange
        var fan = new CeilingFan();
        // act (off - low)
        var updateFan = service.changeFanSpeed(fan);
        // assert
        assertThat(updateFan.getPhase()).isEqualTo(FanPhase.LOW);

        // try again (low - medium)
        updateFan = service.changeFanSpeed(updateFan);
        assertThat(updateFan.getPhase()).isEqualTo(FanPhase.MEDIUM);

        // try again (medium - high)
        updateFan = service.changeFanSpeed(updateFan);
        assertThat(updateFan.getPhase()).isEqualTo(FanPhase.HIGH);

        // try again (high - off)
        updateFan = service.changeFanSpeed(updateFan);
        assertThat(updateFan.getPhase()).isEqualTo(FanPhase.OFF);
	}

    @Test
	void testChangeFanDirection_NoFan_ExpectedNull() {
        // act
        var updateFan = service.changeFanDirection(null);
        // assert
        assertThat(updateFan).isNull();
	}


    @Test
	void testChangeFanDirection_DefaultCase_ExpectedDirectionClockwise() {
        // arrange
        var fan = new CeilingFan();
        // assert
        assertThat(fan.getDirection()).isEqualTo(FanDirection.CLOCKWISE);
	}

    @Test
	void testChangeFanDirection() {
        // arrange
        var fan = new CeilingFan();
        // act
        var updateFan = service.changeFanDirection(fan);
        // assert
        assertThat(updateFan.getDirection()).isEqualTo(FanDirection.COUNTER_CLOCKWISE);

        // try again
        updateFan = service.changeFanDirection(updateFan);
        assertThat(updateFan.getDirection()).isEqualTo(FanDirection.CLOCKWISE);
	}

    @Test
	void testChangeFanSpeedAndDirection() {
        // arrange
        var fan = new CeilingFan();
        // change speed
        var updateFan = service.changeFanSpeed(fan);
        // change direction
        updateFan = service.changeFanDirection(updateFan);
        // assert
        assertThat(updateFan.getPhase()).isEqualTo(FanPhase.LOW);
        assertThat(updateFan.getDirection()).isEqualTo(FanDirection.COUNTER_CLOCKWISE);

        // try again
        updateFan = service.changeFanSpeed(updateFan);
        updateFan = service.changeFanDirection(updateFan);
        // assert
        assertThat(updateFan.getPhase()).isEqualTo(FanPhase.MEDIUM);
        assertThat(updateFan.getDirection()).isEqualTo(FanDirection.CLOCKWISE);

         // try again
         updateFan = service.changeFanSpeed(updateFan);
         updateFan = service.changeFanDirection(updateFan);
         // assert
         assertThat(updateFan.getPhase()).isEqualTo(FanPhase.HIGH);
         assertThat(updateFan.getDirection()).isEqualTo(FanDirection.COUNTER_CLOCKWISE);

          // try again
        updateFan = service.changeFanSpeed(updateFan);
        updateFan = service.changeFanDirection(updateFan);
        // assert
        assertThat(updateFan.getPhase()).isEqualTo(FanPhase.OFF);
        assertThat(updateFan.getDirection()).isEqualTo(FanDirection.COUNTER_CLOCKWISE);
	}
    
}
