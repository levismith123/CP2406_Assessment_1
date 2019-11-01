package model;

public class bus extends Vehicles {

    public bus(Road road, String lane, int speed) {
        super(road, lane, speed);
        setSize(3);
    }
}
