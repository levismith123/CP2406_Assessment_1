package view;

import model.Car;
import model.Road;

import javax.swing.*;
import java.awt.*;

public class view extends JFrame {

    final int HEIGHT = 300;
    final int WIDTH = 750;
    final int rows = 10;
    final int cols = 10;

    JPanel[][] rightPanelLane = new JPanel[rows][5];
    JPanel[][] leftPanelLane = new JPanel[rows][4];
    Color carColor = Color.black;



    view(){
        setLayout(new GridLayout(rows, cols));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setVisible(true);
    }

    public void viewUpdate(Road road){

        if (!road.getRightLaneUpdate().isEmpty()){
            for(int i = 0; i<road.getRightLaneMove().length; i++){
                if(road.getRightLaneMove()[i] != null){
                    rightPanelLane[i][4].setBackground(carColor);
                }
                else{
                    rightPanelLane[i][4].setBackground(Color.green);
                }
            }

            for(int i = 0; i<road.getLeftLaneMove().length; i++){
                if(road.getLeftLaneMove()[i] != null){
                    leftPanelLane[i][4].setBackground(carColor);
                }
                else{
                    leftPanelLane[i][4].setBackground(Color.red);
                }
            }
        }
    }

    //Set up screen with roads
    public void initialiseScreen(Road road){

        //Setting up JPanels in grid format
        JPanel[][] panel = new JPanel[rows][cols];
        for(int i = 0; i<rows; i++) {
            for(int a = 0; a<cols; a++) {
                panel[a][i] = new JPanel();
                add(panel[a][i]);
                panel[a][i].setBackground(Color.white);
            }
        }

        //Drawing left and right lanes
        for(int a = 0; a<road.getSegmentCount(); a++){

            leftPanelLane[a][4] = panel[a][4];
            panel[a][4].setBackground(Color.green);

            rightPanelLane[a][5] = panel[a][5];
            panel[a][5].setBackground(Color.red);
        }


    }



    public static void main(String[] args){
        new view();
        Road road = new Road();
        Car leftCar = new Car(road, "left", 50);
        Car rightCar = new Car(road, "right", 50);
        for(int i = 0; i<road.getSegmentCount(); i++){

        }


    }
}
