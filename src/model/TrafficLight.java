package model;

public class TrafficLight {

    private String colour;
    private int rateOfChange;
    private int position;
    private String roadName;

    //Setter and getter functions
    public void setColour(String colour) {
        this.colour = colour;
    }

    public void setRateOfChange(int rateOfChange) {
        this.rateOfChange = rateOfChange;
    }

    public String getColour() {
        return colour;
    }

    public int getRateOfChange() {
        return rateOfChange;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void setRoad(String road){
        this.roadName = road;
    }

    public String getRoad(){
        return this.roadName;
    }
}
