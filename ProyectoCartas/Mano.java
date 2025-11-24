import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Mano {
    private final LinkedList<Carta> cartas;

    public Mano() {
        cartas = new LinkedList<>();
    }

    public void agregar(Carta c) {
        if (c == null) return;
        if (cartas.size() < 8) cartas.add(c);
    }

    public Carta quitar(int index) {
        if (index < 0 || index >= cartas.size()) return null;
        return cartas.remove(index);
    }

    public List<Carta> getCartas() {
        return cartas;
    }

    public int size() { return cartas.size(); }

    public void ordenarPorValor() {
        cartas.sort(Comparator.comparingInt(Carta::getValor));
    }

    public boolean estaVacia() { return cartas.isEmpty(); }

    @Override
    public String toString() { return cartas.toString(); }
}

