package org.academiadecodigo.carcrash;

import org.academiadecodigo.carcrash.cars.Car;
import org.academiadecodigo.carcrash.cars.CarFactory;
import org.academiadecodigo.carcrash.cars.CarType;
import org.academiadecodigo.carcrash.field.Field;

public class Game {

    public static final int MANUFACTURED_CARS = 15;

    /**
     * Container of Cars
     */
    private static Car[] cars;

    /**
     * Animation delay
     */
    private int delay;

    private int counter;

    public Game(int cols, int rows, int delay) {

        Field.init(cols, rows);

        this.delay = delay;

        counter = 0;

    }

    public static void lookForCrashes() {

        for (int i = 0; i < cars.length; i++) {

            for (int j = i + 1; j < cars.length; j++) {

                if (cars[i].getPos().getCol() == cars[j].getPos().getCol() &&
                        cars[i].getPos().getRow() == cars[j].getPos().getRow()) {

                    cars[i].crash();

                    cars[j].crash();

                }

            }

        }

    }

    /**
     * Creates a bunch of cars and randomly puts them in the field
     */
    public void init() {

        cars = new Car[MANUFACTURED_CARS];

        for (int i = 0; i < cars.length; i++) {

            cars[i] = CarFactory.getNewCar();

        }

        Field.draw(cars);

    }

    /**
     * Starts the animation
     *
     * @throws InterruptedException
     */
    public void start() throws InterruptedException {

        while (true) {

            // Pause for a while
            Thread.sleep(delay);

            // Move all cars
            moveAllCars();

            counter++;

            // Update screen
            Field.draw(cars);

        }

    }

    private void moveAllCars() {

        for (Car car : cars) {

            if (car.isCrashed() == CarType.MUSTANG || counter % 3 == 0) {

                car.update();

            }

        }

    }

}
