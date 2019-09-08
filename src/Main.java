import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        String roadSimulationChar = "-";
        String carSimulationChar = "C ";
        int simulationStepSpeed = 1;
        Random numRand = new Random();

        //Initializing roads
        Road road = new Road();
        road.setSegmentCount(9);

        Road road2 = new Road();
        road2.setSegmentCount(9);

        //Initializing traffic lights
        TrafficLight trafficlight = new TrafficLight();
        trafficlight.setPosition(6);
        trafficlight.setColour("G ");

        TrafficLight trafficlight2 = new TrafficLight();
        trafficlight2.setPosition(3);
        trafficlight2.setColour("R ");

        //Initializing car
        Car car = new Car();
        car.setSegment(0);
        car.setRoad("road");

        //Step for 20 seconds
        for (int i = 0; i < 20; i++) {

            //Randomize traffic lights
            int trafficRand = numRand.nextInt(2)+1;
            switch(trafficRand){
                case 1:
                    trafficlight.setColour("R ");
                    break;
                case 2:
                    trafficlight.setColour("G ");
                    break;
            }

            int trafficRand2 = numRand.nextInt(2)+1;
            switch(trafficRand2){
                case 1:
                    trafficlight2.setColour("R ");
                    break;
                case 2:
                    trafficlight2.setColour("G ");
                    break;
            }

            //Build road 1
            for (int x = 0; x <= road.getSegmentCount(); x++) {
                if (x == car.getSegment() && car.getRoad().equals("road")) {
                    System.out.print(carSimulationChar);
                } else if (x == trafficlight.getPosition()) {
                    System.out.print(trafficlight.getColour());
                } else {
                    System.out.print(roadSimulationChar + ' ');
                }
            }
            System.out.print(" ");

            //Build road 2
            for (int y = 0; y <= road2.getSegmentCount(); y++) {

                if (y == car.getSegment() && car.getRoad().equals("road2")) {
                    System.out.print(carSimulationChar);
                } else if (y == trafficlight2.getPosition()) {
                    System.out.print(trafficlight2.getColour());
                } else {
                    System.out.print(roadSimulationChar + ' ');
                }
            }

            //Step time is 1 second
            TimeUnit.SECONDS.sleep(simulationStepSpeed);
            System.out.print("\n");

            //Checking if car can move forward on road 1
            if (car.getRoad().equals("road")) {
                if (car.getSegment() != trafficlight.getPosition() - 1 && car.getSegment() != road.getSegmentCount()) {
                    car.move();

                    //checking if car reached the end of road
                } else if (car.getSegment() == road.getSegmentCount()) {
                    car.setRoad("road2");
                    car.resetSegment();

                } else {
                    if (!trafficlight.getColour().equals("R ")) {
                        car.move();
                    }

                }
            } else {

                //Checking if car can move forward on road 2
                if (car.getSegment() != trafficlight2.getPosition() - 1 && car.getSegment() != road2.getSegmentCount()) {
                    car.move();
                } else {

                    //Checking if car has reached the end of road
                    if(car.getSegment() != road2.getSegmentCount()){
                        if(!trafficlight2.getColour().equals("R ")){
                            car.move();
                        }
                    }
                }
            }
        }
    }
}
