package Test;

import model.Car;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    void carTest(){
        Car car = new Car();
        car.setSegment(1);
        assertEquals(1, car.getSegment());

        car.move();
        assertEquals(2, car.getSegment());

        car.resetSegment();
        assertEquals(1, car.getSegment());

        car.setRoad("road");
        assertEquals("road", car.getRoad());

    }
}