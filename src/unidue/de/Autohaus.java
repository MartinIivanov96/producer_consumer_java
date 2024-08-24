package unidue.de;

public class Autohaus implements Runnable {
    private final Parkplatz parkplatz;

    public Autohaus(Parkplatz parkplatz) {
        this.parkplatz = parkplatz;
    }


    @Override
    public void run() {
        try {
            while(true) {
                Auto verkauftesAuto = parkplatz.autoAbholen();
               System.out.println(verkauftesAuto + " wurde abgeholt.");
               Thread.sleep(750);
            }
        } catch (InterruptedException a) {
            Thread.currentThread().interrupt();
        }
    }
}
