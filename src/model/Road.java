package model;

public class Road {

    private int segmentCount;
    private String connects;

    Road(int segmentCount){
        this.segmentCount = segmentCount;
        Vehicles[] leftLane = new Vehicles[segmentCount];
        Vehicles[] rightLane = new Vehicles[segmentCount];

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
}
