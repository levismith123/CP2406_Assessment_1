package Test;

import model.Car;
import model.Road;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    void carTest(){
        Road road = new Road();
        Car car = new Car(road, "left", 50);
        car.spawn();

        assertEquals(car, road.getLeftLaneMove()[0]);
        assertEquals(car, road.getLeftLaneUpdate().toArray()[0]);
        assertTrue(road.getLeftLaneUpdate().contains(car));

        car.move();
        assertEquals(car, road.getLeftLaneMove()[1]);
        assertNull(road.getLeftLaneMove()[0]);
    }
}