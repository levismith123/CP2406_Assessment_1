package model;

public class Car {

    private int segment;
    private String road;


    public void move(){

        this.segment++;
    }

    public void resetSegment(){
        this.segment = 1;
    }


    //Setter and Getter methods
    public void setSegment(int num){
        this.segment = num;
    }

    public int getSegment(){
        return this.segment;
    }

    public void setRoad(String name){
        this.road = name;
    }

    public String getRoad(){
        return this.road;
    }

}
