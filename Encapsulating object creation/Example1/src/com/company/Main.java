package com.company;

import java.util.Scanner;

class MotorStaticFactory {

    public static Motor make(char type, String model, long power) {
        String result = String.valueOf(type).toLowerCase();

        switch (result) {
            case "p":
                return new PneumaticMotor(model, power);
            case "h":
                return new HydraulicMotor(model, power);
            case "e":
                return new ElectricMotor(model, power);
            case "w":
                return new WarpDrive(model, power);
            default:
                return null;
        }
    }
}

/* Do not change code below */
abstract class Motor {

    String model;
    long power;

    public Motor(String model, long power) {
        this.model = model;
        this.power = power;
    }
}

class PneumaticMotor extends Motor {

    public PneumaticMotor(String model, long power) {
        super(model, power);
    }
}

class HydraulicMotor extends Motor {

    public HydraulicMotor(String model, long power) {
        super(model, power);
    }
}

class ElectricMotor extends Motor {

    public ElectricMotor(String model, long power) {
        super(model, power);
    }
}

class WarpDrive extends Motor {

    public WarpDrive(String model, long power) {
        super(model, power);
    }
}

public class Main {
    public static void main(String args[]) {
        final Scanner scanner = new Scanner(System.in);
        final char type = scanner.next().charAt(0);
        final String model = scanner.next();
        final long power = scanner.nextLong();
        final Motor motor = MotorStaticFactory.make(type, model, power);
        if (motor == null) {
            System.out.println(motor);
        } else {
            System.out.println(motor.getClass().getName() + " " + motor.model + " " + motor.power);
        }
    }
}
