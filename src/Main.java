import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Main {


    public static void main(String[] args) throws InterruptedException {


        int simulationStepSpeed = 1;
        Random numRand = new Random();

        //Initializing roads
        Road road = new Road();
        road.setSegmentCount(10);

        Road road2 = new Road();
        road2.setSegmentCount(10);

        //Initializing traffic lights
        TrafficLight trafficlight = new TrafficLight();
        trafficlight.setPosition(10);
        trafficlight.setRoad("road");
        trafficlight.setColour("G ");

        TrafficLight trafficlight2 = new TrafficLight();
        trafficlight2.setPosition(10);
        trafficlight2.setColour("R ");
        trafficlight2.setRoad("road2");

        //Initializing car
        Car car = new Car();
        car.setSegment(1);
        car.setRoad("road");

        //Step for 20 seconds
        for (int i = 0; i < 30; i++) {

            //Randomize traffic lights
            int trafficRand = numRand.nextInt(2) + 1;
            switch (trafficRand) {
                case 1:
                    trafficlight.setColour("R ");
                    break;
                case 2:
                    trafficlight.setColour("G ");
                    break;
            }

            build_road("road", car.getRoad(), car.getSegment(), trafficlight.getPosition(), trafficlight.getColour());

            int trafficRand2 = numRand.nextInt(2) + 1;
            switch (trafficRand2) {
                case 1:
                    trafficlight2.setColour("R ");
                    break;
                case 2:
                    trafficlight2.setColour("G ");
                    break;
            }

            build_road("road2", car.getRoad(), car.getSegment(), trafficlight2.getPosition(), trafficlight2.getColour());

            TimeUnit.SECONDS.sleep(simulationStepSpeed);
            System.out.print("\n");

            //Checking if car can move on road 1
            if (car.getRoad().equals("road")) {
                boolean[] move = canMove(car.getSegment(), car.getRoad(), trafficlight.getPosition(), road.getSegmentCount(),
                        trafficlight.getColour());
                if (move[0] && !move[1]) {
                    car.move();
                } else if (!move[0] && move[1]) {
                    car.setRoad("road2");
                    car.resetSegment();

                }
            }

            //Checking if car can move on road 2
            else {
                boolean[] move = canMove(car.getSegment(), car.getRoad(), trafficlight.getPosition(), road.getSegmentCount(),
                        trafficlight.getColour());
                if (move[0] && !move[1]) {
                    car.move();
                }
            }
        }
    }

        private static void build_road (String road, String carRoad, int carSegment, int trafficlightSegment,
        String trafficlightColour) {
            String roadSimulationChar = "- ";
            String carSimulationChar = "C ";

            if (carRoad.equals(road)) {

                for (int x = 1; x <= 10; x++) {

                    if (carSegment == x) {
                        System.out.print(carSimulationChar);
                    } else if (trafficlightSegment == x) {
                        System.out.print(trafficlightColour);
                    } else {
                        System.out.print(roadSimulationChar);
                    }
                }
            } else {
                for (int x = 1; x <= 10; x++) {

                    if (trafficlightSegment == x) {
                        System.out.print(trafficlightColour);
                    } else {
                        System.out.print(roadSimulationChar);
                    }
                }
            }
            System.out.print(" ");
        }



        //Will check if the car is able to move and if it needs to change roads
        private static boolean[] canMove ( int carSegment, String carRoad,int trafficlightSegment, int roadSegmentCount,
        String trafficlightColour){

            //Checking if car is at a traffic light and isnt at the end of a road
            if (carSegment == trafficlightSegment - 1 && carSegment != roadSegmentCount) {

                //if the traffic light isnt red the car can move
                if (!trafficlightColour.equals("G ")) {
                    return new boolean[]{false, false};
                } else {
                    return new boolean[]{true, false};
                }
            }

            //Checking if the car is at the end of a road and isnt stopped by a light
            else if (carSegment != trafficlightSegment - 1 && carSegment != roadSegmentCount) {
                return new boolean[]{true, false};
            }

            //Checking if the car is at the end of the road and is on the first road
            else if (carRoad.equals("road") && carSegment == roadSegmentCount) {
                return new boolean[]{false, true};
            } else {
                return new boolean[]{false, false};
            }
        }
    }