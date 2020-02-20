package org.academiadecodigo.carcrash.cars;

import org.academiadecodigo.carcrash.field.Position;
import org.academiadecodigo.carcrash.helper.RandomGenerator;

public class CarFactory {

    public static Car getNewCar() {

        int probability = RandomGenerator.generateProbability();

        Position position = new Position();

        return probability > 40 ? new Fiat(position) : new Mustang(position);

    }

}
