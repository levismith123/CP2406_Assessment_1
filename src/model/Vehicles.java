package model;

public abstract class Vehicles {



    private int oldSegment;
    private int segment;
    private int speed;
    private Road road;
    private int size;

    public int getOldSegment() {
        return oldSegment;
    }

    public String getLane() {
        return lane;
    }

    public void setLane(String lane) {
        this.lane = lane;
    }

    private String lane;


    //Sets where the car is facing: north, south, east, or west
    private String direction;

    Vehicles(Road road, String lane, int speed){
        this.road = road;
        this.speed = speed;
        this.segment = 0;
        this.lane = lane;
    }


    //setters and getters
    public Road getRoad() {
        return road;
    }

    public void setRoad(Road road) {
        this.road = road;
    }



    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

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
    public void setSize(int size){this.size = size;}

    //Will check if the car can move by working out how many segments its going to travel across and then work out if it
    //can move
    public void move(){
        int simulationSpeed = 1;
        int segmentMoveCount = (this.road.getSegmentSize()/this.speed)/simulationSpeed;

        if (this.segment + segmentMoveCount < road.getSegmentCount()){
            oldSegment = segment;
            segment = segment + segmentMoveCount;
            this.road.update(this);
        }

    }

    //Calls the road to spawn a new vehicle
    public void spawn(){
        this.segment = 0;
        road.newVehicle(this);
    }
}
