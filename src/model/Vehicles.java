package model;

public abstract class Vehicles {

    private int segment;
    private int speed;
    private Road road;
    private int size;

    public String getOrientation() {
        return orientation;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    //Sets where the car is facing: north, south, east, or west
    private String orientation;

    //setters and getters
    public void setSegment(int segment){
        this.segment = segment;
    }
    public int getSegment(){
        return segment;
    }
    public int getSpeed(){
        return speed;
    }
    public void setSpeed(int speed){
        this.speed = speed;
    }

    public int getSize(){
        return this.size;
    }
    public void setSize(int size){
        this.size = size;
    }

    //Will check if the car can move by working out how many segments its going to travel across and then work out if it
    //can move
    public void move(){
        int simulationSpeed = 1;
        int segmentMoveCount = (this.road.getSegmentSize()/this.speed)/simulationSpeed;

        if (this.segment + segmentMoveCount < road.getSegmentCount()){
            segment = segment + segmentMoveCount;
        }

    }
}
