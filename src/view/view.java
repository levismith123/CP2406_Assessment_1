package view;
import model.Road;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class view implements ActionListener {

    final int HEIGHT = 300;
    final int WIDTH = 750;
    final int rows = 10;
    final int cols = 10;

    JPanel[] rightPanelLane = new JPanel[rows];
    JPanel[] leftPanelLane = new JPanel[rows];

    Color carColor = Color.black;
    JFrame frame = new JFrame();

    JMenuItem run = new JMenuItem("Run");
    JMenuItem stop = new JMenuItem("Stop");

    boolean simRun = true;

    public boolean isSimRun() {
        return simRun;
    }




    public view(Road road){

        //Setting up simulator screen
        GridLayout mainScreen = new GridLayout(rows, cols);
        BorderLayout screenLayout = new BorderLayout();


        //Setting up alignments in the menu
        JPanel simulator = new JPanel();
        JPanel topSide = new JPanel();

        //Simulator setup
        simulator.setLayout(mainScreen);


        //Topside setup
        GridLayout topLayout = new GridLayout(1,2);
        topSide.setLayout(topLayout);
        JMenuBar menu = new JMenuBar();

        JMenu city = new JMenu("City");
        JMenuItem newMap = new JMenuItem("New");
        JMenuItem save = new JMenuItem("Save");
        JMenuItem create = new JMenuItem("create");
        JMenuItem load = new JMenuItem("load");

        city.add(newMap);
        city.add(save);
        city.add(create);
        city.add(load);

        JMenu simulatorMenu = new JMenu("Simulator");

        run.addActionListener(this);
        stop.addActionListener(this);

        simulatorMenu.add(run);
        simulatorMenu.add(stop);

        menu.add(city);
        menu.add(simulatorMenu);
        topSide.add(menu);

        //Adding bottom side
        JPanel bottomSide = new JPanel();
        JLabel status = new JLabel("Ready");
        bottomSide.add(status);

        frame.setLayout(screenLayout);
        frame.add(simulator, BorderLayout.CENTER);
        frame.add(topSide, BorderLayout.NORTH);
        frame.add(bottomSide, BorderLayout.SOUTH);



        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);


        //Setting up JPanels in grid format
        JPanel[][] panel = new JPanel[rows][cols];
        for(int i = 0; i<rows; i++) {
            for(int a = 0; a<cols; a++) {
                panel[a][i] = new JPanel();
                simulator.add(panel[a][i]);
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


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource() == run){
            simRun = true;
        }

        else if(actionEvent.getSource() == stop){
            simRun = false;
        }
    }
}
