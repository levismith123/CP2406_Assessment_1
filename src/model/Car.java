package model;

public class Car extends Vehicles {

    public Car(Road road, String lane, int speed) {
        super(road, lane, speed);
        setSize(1);
        setSpeed(speed);
        setSegment(0);
        setRoad(road);
        setLane(lane);

    }
}
