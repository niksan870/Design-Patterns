package com.company;

import java.util.Scanner;

class ClockFactory {

    private boolean produceToyClock;

    public ClockFactory(boolean produceToyClock) {
        this.produceToyClock = produceToyClock;
    }

    public Clock produce(String type) {
        switch(type){
            case "SAND":
                return new SandClock();
            case "DIGITAL":
                return new DigitalClock();
            case "MECH":
                return new MechanicalClock();
            default:
                if(this.produceToyClock == true){
                    return new ToyClock();
                } else {
                    return null;
                }
        }
    }
}

interface Clock {

    void tick();
}

class SandClock implements Clock {

    @Override
    public void tick() {
        System.out.println("...sand noise...");
    }
}

class DigitalClock implements Clock {

    @Override
    public void tick() {
        System.out.println("...pim...");
    }
}

class MechanicalClock implements Clock {

    @Override
    public void tick() {
        System.out.println("...clang mechanism...");
    }
}

class ToyClock implements Clock {

    @Override
    public void tick() {
        System.out.println("...tick...");
    }
}

public class Main {
    public static void main(String args[]) {
        final Scanner scanner = new Scanner(System.in);
        final String type = scanner.next();
        final boolean produceToy = scanner.nextBoolean();
        final ClockFactory factory = new ClockFactory(produceToy);
        final Clock clock = factory.produce(type);
        if (clock != null) {
            clock.tick();
        } else {
            System.out.println(clock);
        }
    }
}
