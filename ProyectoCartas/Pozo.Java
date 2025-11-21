import java.util.LinkedList;
import java.util.Queue;

public class Pozo {
    private Queue<Carta> cartas;

    public Pozo() {
        cartas = new LinkedList<>();
    }

    public void agregarCarta(Carta carta) {
        cartas.add(carta);
    }

    public Queue<Carta> getCartas() {
        return cartas;
    }

    public boolean estaVacio() {
        return cartas.isEmpty();
    }

    @Override
    public String toString() {
        return cartas.toString();
    }
}
