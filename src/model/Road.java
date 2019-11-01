package model;

import java.util.ArrayList;

public class Road {

    //Controls the length of the road
    private int segmentCount = 10;

    private Vehicles[] leftLaneMove = new Vehicles[segmentCount];
    private Vehicles[] rightLaneMove = new Vehicles[segmentCount];
    private String connects;
    private ArrayList<Vehicles> leftLaneUpdate = new ArrayList<>();
    private ArrayList<Vehicles> rightLaneUpdate = new ArrayList<>();



    private boolean isVertical = false;

    public Road(){
    }

    public boolean isVertical() {
        return isVertical;
    }

    public Vehicles[] getLeftLaneMove() {
        return leftLaneMove;
    }

    public Vehicles[] getRightLaneMove() {
        return rightLaneMove;
    }

    public ArrayList<Vehicles> getLeftLaneUpdate() {
        return leftLaneUpdate;
    }

    public ArrayList<Vehicles> getRightLaneUpdate() {
        return rightLaneUpdate;
    }

    public void setSegmentCount(int segmentCount) {
        this.segmentCount = segmentCount;
    }

    public int getSegmentCount(){
        return this.segmentCount;
    }

    public void setConnects(String road){
        this.connects = road;
    }

    public String getConnects(){
        return this.connects;
    }

    public int getSegmentSize(){
        return 50;
    }

    //Updates the representation of the vehicles on the road
    public void update(Vehicles vehicle) {
        String lane = vehicle.getLane();
        if (lane.equals("left")){
            leftLaneMove[vehicle.getOldSegment()] = null;
            leftLaneMove[vehicle.getSegment()] = vehicle;

        }
        else{
            rightLaneMove[vehicle.getOldSegment()] = null;
            rightLaneMove[vehicle.getSegment()] = vehicle;
        }
    }

    //Spawns a vehicle in the vehicle lists
    public void newVehicle(Vehicles vehicle){
        String lane = vehicle.getLane();
        if(lane.equals("left")){
            leftLaneUpdate.add(vehicle);
            leftLaneMove[vehicle.getSegment()] = vehicle;
        }
        else{
            rightLaneUpdate.add(vehicle);
            rightLaneMove[vehicle.getSegment()] = vehicle;
        }
    }
}
