package controller;

import model.Car;
import model.Road;
import view.view;

import java.util.concurrent.TimeUnit;

public class Controller {

    public static void main(String[] args) throws InterruptedException {


        Road road = new Road();
        Car leftCar = new Car(road, "left", 50);
        Car rightCar = new Car(road, "right", 50);
        view View = new view(road);


        leftCar.spawn();
        rightCar.spawn();
        View.viewUpdate(road);
        TimeUnit.SECONDS.sleep(1);
        boolean run;
        while(true) {

            TimeUnit.MILLISECONDS.sleep(100);
            run = View.isSimRun();

            if(run) {
                leftCar.move();
                rightCar.move();
                View.viewUpdate(road);
                TimeUnit.SECONDS.sleep(1);
            }
        }
    }
}
