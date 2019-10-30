package Test;

import model.TrafficLight;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrafficLightTest {

    @Test
    void trafficLightTest() {
        TrafficLight trafficlight = new TrafficLight();
        trafficlight.setColour("R");
        assertEquals("R", trafficlight.getColour());

        trafficlight.setPosition(3);
        assertEquals(3, trafficlight.getPosition());

        trafficlight.setRateOfChange(4);
        assertEquals(4, trafficlight.getRateOfChange());

    }


}