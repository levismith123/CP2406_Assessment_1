package view;
import model.Road;

import javax.swing.*;
import java.awt.*;

public class view {

    final int HEIGHT = 300;
    final int WIDTH = 750;
    final int rows = 10;
    final int cols = 10;

    JPanel[] rightPanelLane = new JPanel[rows];
    JPanel[] leftPanelLane = new JPanel[rows];

    Color carColor = Color.black;
    JFrame frame = new JFrame();

    public view(Road road){
        frame.setLayout(new GridLayout(rows, cols));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);


        //Setting up JPanels in grid format
        JPanel[][] panel = new JPanel[rows][cols];
        for(int i = 0; i<rows; i++) {
            for(int a = 0; a<cols; a++) {
                panel[a][i] = new JPanel();
                frame.add(panel[a][i]);
                panel[a][i].setBackground(Color.white);
            }
        }

        //Drawing left and right lanes
        for(int a = 0; a<road.getSegmentCount(); a++){
            leftPanelLane[a] = panel[a][4];
            panel[a][4].setBackground(Color.green);

            rightPanelLane[a] = panel[a][5];
            panel[a][5].setBackground(Color.red);
        }
        frame.setVisible(true);


    }

    //Updates the screen to account for moving vehicles
    public void viewUpdate(Road road){
        if (!road.getRightLaneUpdate().isEmpty()){
            for(int i = 0; i<=road.getRightLaneMove().length-1; i++){
                if(road.getRightLaneMove()[i] != null){
                    rightPanelLane[i].setBackground(carColor);
                }
                else{
                    rightPanelLane[i].setBackground(Color.red);
                }
            }

            for(int i = 0; i<=road.getLeftLaneMove().length-1; i++){
                if(road.getLeftLaneMove()[i] != null){
                    leftPanelLane[i].setBackground(carColor);
                }
                else{
                    leftPanelLane[i].setBackground(Color.green);
                }
            }

        }
    }


}
