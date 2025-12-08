import java.util.LinkedList;
import java.util.List;

public class Caja {
    private final LinkedList<Carta> cartas = new LinkedList<>();

    public Caja() {
        inicializarBarajaOrdenada();
    }

    private void inicializarBarajaOrdenada() {
        cartas.clear();
        for (Palo palo : Palo.values()) {
            for (Valor valor : Valor.values()) {
                cartas.add(new Carta(valor, palo));
            }
        }
    }

    public List<Carta> getCartas() {
        return cartas;
    }

    public void limpiar() {
        cartas.clear();
    }

    public void agregarCartaAlFinal(Carta c) {
        cartas.addLast(c);
    }
}
