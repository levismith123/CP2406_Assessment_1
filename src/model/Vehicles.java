package model;

public abstract class Vehicles {



    private int oldSegment;
    private int segment;
    private int speed;
    private Road road;
    private int size;
    private String lane;

    public int getOldSegment() {
        return oldSegment;
    }

    public String getLane() {
        return lane;
    }

    public void setLane(String lane) {
        this.lane = lane;
    }

    //Sets where the car is facing: north, south, east, or west
    private String direction;

    Vehicles(Road road, String lane, int speed){
        this.road = road;
        this.speed = speed;
        if(lane.equals("left")){
            this.segment = 0;
        }

        else{
            this.segment = road.getSegmentCount();
        }
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
    public void move() {
        int simulationSpeed = 1;
        int segmentMoveCount = (this.road.getSegmentSize() / this.speed) / simulationSpeed;
        oldSegment = segment;

        if (this.lane.equals("left")) {
            if (this.segment + segmentMoveCount < road.getSegmentCount()) {

                segment += segmentMoveCount;
            }

        }

        else {
            if (this.segment - segmentMoveCount >= 0) {
                segment -= segmentMoveCount;
            }
        }
        this.road.update(this);
    }

    //Calls the road to spawn a new vehicle
    public void spawn(){
        if(this.getLane().equals("left")) {
            this.segment = 0;
            road.newVehicle(this);
        }

        else{
            this.segment = 9;
            road.newVehicle(this);
        }
    }
}
