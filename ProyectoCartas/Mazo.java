import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

public class Mazo {
    private final Deque<Carta> pila;

    public Mazo() {
        pila = new ArrayDeque<>();
    }

    // Baraja desde la caja: toma todas las cartas, las mezcla y las pone en la pila
    public void barajarDesdeCaja(Caja caja) {
        List<Carta> copia = new ArrayList<>(caja.getCartas());
        Collections.shuffle(copia);
        pila.clear();
        for (Carta c : copia) pila.push(c);
        // vaciar la caja (las cartas ahora están en mazo)
        caja.getCartas().clear();
    }

    // sacar una carta (pop)
    public Carta sacar() {
        return pila.isEmpty() ? null : pila.pop();
    }

    public int size() { return pila.size(); }
    public boolean estaVacio() { return pila.isEmpty(); }

    // Devuelve una vista en lista para mostrar (no modifica el mazo)
    public List<Carta> asList() {
        return new ArrayList<>(pila);
    }

    @Override
    public String toString() { return asList().toString(); }
}


