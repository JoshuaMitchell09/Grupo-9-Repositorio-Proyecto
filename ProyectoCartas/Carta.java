public class Carta {
    public enum Palo { CORAZONES, DIAMANTES, PICAS, TREBOLES }

    private final Palo palo;
    private final int valor; // 1..13 (A=1, J=11, Q=12, K=13)

    public Carta(Palo palo, int valor) {
        if (valor < 1 || valor > 13) throw new IllegalArgumentException("Valor fuera de rango 1..13");
        this.palo = palo;
        this.valor = valor;
    }

    public Palo getPalo() { return palo; }
    public int getValor() { return valor; }

    public String getNombre() {
        switch (valor) {
            case 1: return "A";
            case 11: return "J";
            case 12: return "Q";
            case 13: return "K";
            default: return String.valueOf(valor);
        }
    }

    public String getPaloSimbolo() {
        switch (palo) {
            case CORAZONES: return "♥";
            case DIAMANTES: return "♦";
            case PICAS: return "♠";
            case TREBOLES: return "♣";
            default: return "?";
        }
    }

    public String getColor() {
        return (palo == Palo.CORAZONES || palo == Palo.DIAMANTES) ? "ROJO" : "NEGRO";
    }

    @Override
    public String toString() {
        return String.format("[%s|%s]", getNombre(), getPaloSimbolo());
    }
}


