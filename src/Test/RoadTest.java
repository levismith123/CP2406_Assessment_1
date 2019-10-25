package Test;

import model.Car;
import model.Road;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoadTest {
        @Test
        void roadTest(){

            Road road = new Road();
            Car car = new Car(road, "left", 50);



            road.setConnects("road");
            assertEquals("road", road.getConnects());
        }
}