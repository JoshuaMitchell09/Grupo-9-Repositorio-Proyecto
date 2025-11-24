import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Pozo {
    private final Queue<Carta> cola;

    public Pozo() {
        cola = new LinkedList<>();
    }

    public void agregar(Carta c) {
        if (c != null) cola.add(c);
    }

    public List<Carta> asList() {
        return new ArrayList<>(cola);
    }

    public boolean estaVacio() { return cola.isEmpty(); }

    @Override
    public String toString() { return asList().toString(); }
}


