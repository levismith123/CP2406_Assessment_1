package model;

public class Car extends Vehicles {

    Car(Road road, int speed) {
        super(road, speed);
        setSize(1);
        setSpeed(speed);
        setSegment(0);
        setRoad(road);

    }
}
