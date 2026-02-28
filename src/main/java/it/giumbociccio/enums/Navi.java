package it.giumbociccio.enums;

public enum Navi {
    SOTTOMARINO(1),
    TORPEDINIERA(2),
    CACCIATORPEDINIERA(3),
    PETROLIERA(4),
    PORTAEREI(5);

    private final int dimensione; // lunghezza della nave

    Navi(int dimensione) {
        this.dimensione = dimensione;
    }

    public int getDimensione() {
        return dimensione;
    }
}