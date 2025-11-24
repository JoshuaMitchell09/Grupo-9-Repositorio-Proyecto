import java.util.LinkedList;

public class Caja {
    private final LinkedList<Carta> cartas;

    public Caja() {
        cartas = new LinkedList<>();
        inicializarCaja();
    }

    // crea las 52 cartas (una sola vez por instancia de Caja)
    public void inicializarCaja() {
        cartas.clear();
        for (Carta.Palo p : Carta.Palo.values()) {
            for (int v = 1; v <= 13; v++) {
                cartas.add(new Carta(p, v));
            }
        }
    }

    public LinkedList<Carta> getCartas() { return cartas; }

    public boolean estaVacia() { return cartas.isEmpty(); }

    @Override
    public String toString() { return cartas.toString(); }
}


