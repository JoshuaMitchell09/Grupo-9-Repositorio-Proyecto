public class Carta {
    private String valor;
    private String palo;
    private String color;

    public Carta(String valor, String palo) {
        this.valor = valor;
        this.palo = palo;
        this.color = (palo.equals("♥") || palo.equals("♦")) ? "Rojo" : "Negro";
    }

    public String getValor() {
        return valor;
    }

    public String getPalo() {
        return palo;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return valor + palo;
    }
}
