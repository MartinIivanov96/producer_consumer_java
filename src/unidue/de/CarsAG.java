package unidue.de;

import javax.swing.*;

public class CarsAG implements Runnable {
    private final Parkplatz parkplatz;
    private String model;
    private Motor motor;

    public CarsAG(Parkplatz parkplatz, String model, Motor motor){
        this.parkplatz = parkplatz;
        this.model = model;
        this.motor = motor;
    }

    @Override
    public void run() {
        try{
            while(true) {
                Auto auto = new Auto(model,motor);
                Thread.sleep(1000);
                parkplatz.autoParken(auto);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
