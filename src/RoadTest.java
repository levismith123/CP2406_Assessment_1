import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoadTest {
        @Test
        void roadTest(){

            Road road = new Road();
            road.setSegmentCount(5);
            assertEquals(5, road.getSegmentCount());

            road.setConnects("road");
            assertEquals("road", road.getConnects());
        }
}