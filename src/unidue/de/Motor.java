package unidue.de;

public class Motor {
    private String name;
    private float grosse, verbrauch;

    public Motor(String name, float grosse, float verbrauch) {
        this.name = name;
        this.grosse = grosse;
        this.verbrauch = verbrauch;
    }

    @Override
    public String toString() {
        return "Motor " + name + " mit Volumen:" + grosse + " cc und verbrauch: " + verbrauch + " l/100km";
    }
}
