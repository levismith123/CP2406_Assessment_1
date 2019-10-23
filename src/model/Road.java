package model;

public abstract class Road {

    private int segmentSize;
    private int segmentCount;
    private String connects;

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
        return this.segmentSize;
    }

    public void setSegmentSize(int size){
        this.segmentSize = size;
    }
}
