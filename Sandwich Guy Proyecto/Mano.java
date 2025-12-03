import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Mano {
    private final List<Carta> cartas = new ArrayList<>();
    private static final int MAX_CARTAS = 8;

    public void agregarCarta(Carta c) {
        if (c != null && cartas.size() < MAX_CARTAS) {
            cartas.add(c);
        }
    }

    public void eliminarCarta(Carta c) {
        cartas.remove(c);
    }

    public List<Carta> getCartas() {
        return Collections.unmodifiableList(cartas);
    }

    public int size() {
        return cartas.size();
    }

    public void limpiar() {
        cartas.clear();
    }

    public void ordenarPorValor() {
        cartas.sort(Comparator.comparingInt(c -> c.getValor().getOrden()));
    }
}
