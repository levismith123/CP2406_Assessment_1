public class Road {

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
}
