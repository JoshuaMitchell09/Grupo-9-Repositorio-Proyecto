public class Carta {
    private final Valor valor;
    private final Palo palo;

    public Carta(Valor valor, Palo palo) {
        this.valor = valor;
        this.palo = palo;
    }

    public Valor getValor() {
        return valor;
    }

    public Palo getPalo() {
        return palo;
    }

    public String getColor() {
        return palo.getColor();
    }

    public String getCodigo() {
        // Ej: "A-CORAZONES"
        return valor.name() + "-" + palo.name();
    }

    @Override
    public String toString() {
        return "[" + valor.name() + "|" + palo.getSimbolo() + "]";
    }
}
