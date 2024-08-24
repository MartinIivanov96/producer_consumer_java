package unidue.de;

public class Auto {
    String model;
    Motor motor;

    public Auto(String model, Motor motor) {
        this.model = model;
        this.motor = motor;
    }

    @Override
    public String toString() {
        return "Das "+model+" mit " + motor;
    }
}
