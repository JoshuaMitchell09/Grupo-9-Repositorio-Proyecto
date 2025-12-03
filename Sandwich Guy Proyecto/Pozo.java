import java.util.ArrayDeque;
import java.util.Queue;

public class Pozo {
    private final ArrayDeque<Carta> cola = new ArrayDeque<>();

    public void descartar(Carta c) {
        if (c != null) {
            cola.addLast(c); // FIFO
        }
    }

    public int size() {
        return cola.size();
    }

    public Queue<Carta> getCartas() {
        return cola;
    }

    public void limpiar() {
        cola.clear();
    }
}