public enum Palo {
    CORAZONES('♥', "rojo"),
    DIAMANTES('♦', "rojo"),
    PICAS('♠', "negro"),
    TREBOLES('♣', "negro");

    private final char simbolo;
    private final String color;

    Palo(char simbolo, String color) {
        this.simbolo = simbolo;
        this.color = color;
    }

    public char getSimbolo() {
        return simbolo;
    }

    public String getColor() {
        return color;
    }
}
