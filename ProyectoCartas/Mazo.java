import java.util.Collections;
import java.util.Stack;
import java.util.List;

public class Mazo {
    private Stack<Carta> pilaCartas;

    public Mazo() {
        pilaCartas = new Stack<>();
    }

    public void barajarDesdeCaja(Caja caja) {
        List<Carta> cartas = caja.getCartas();
        Collections.shuffle(cartas);
        pilaCartas.addAll(cartas);
        cartas.clear(); // vacía la caja
    }

    public Stack<Carta> getPilaCartas() {
        return pilaCartas;
    }

    public boolean estaVacio() {
        return pilaCartas.isEmpty();
    }

    @Override
    public String toString() {
        return pilaCartas.toString();
    }
}
