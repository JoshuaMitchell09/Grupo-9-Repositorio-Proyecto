import java.util.ArrayDeque;
import java.util.Collections;
import java.util.List;

public class Mazo {
    private final ArrayDeque<Carta> pila = new ArrayDeque<>();

    public void cargarDesdeCaja(List<Carta> cartasCaja) {
        pila.clear();
        Collections.shuffle(cartasCaja);
        for (Carta c : cartasCaja) {
            pila.push(c); // LIFO
        }
    }

    public Carta tomar() {
        return pila.isEmpty() ? null : pila.pop();
    }

    public boolean estaVacio() {
        return pila.isEmpty();
    }

    public int size() {
        return pila.size();
    }

    public ArrayDeque<Carta> getPila() {
        return pila;
    }
}
