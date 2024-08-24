package unidue.de;



public class Main {

    public static void main(String[] args) {
     Parkplatz autoParkplatz = new Parkplatz(10);



     Thread produzent1 = new Thread(new CarsAG(autoParkplatz, "e36", new Motor("N46B20", 1995f, 8.3f)));
     Thread produzent2 = new Thread(new CarsAG(autoParkplatz, "e46", new Motor("N52B48", 2995f, 9.4f)));
     Thread produzent3 = new Thread(new CarsAG(autoParkplatz, "e90", new Motor("N58B20", 4395f, 11.5f)));
     Thread produzent4 = new Thread(new CarsAG(autoParkplatz, "e60", new Motor("S85B50A", 4999f, 14.8f)));

     Thread autohandler1 = new Thread(new Autohaus(autoParkplatz));
     Thread autohandler2 = new Thread(new Autohaus(autoParkplatz));


    produzent1.start();
    produzent2.start();
    produzent3.start();
    produzent4.start();

    autohandler1.start();
    autohandler2.start();



    }
}
