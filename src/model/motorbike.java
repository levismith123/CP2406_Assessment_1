package model;

public class motorbike extends Vehicles {

    public motorbike(Road road, String lane, int speed) {
        super(road, lane, speed);
        setSize(1);
    }
}
