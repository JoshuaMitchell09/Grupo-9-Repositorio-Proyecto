import java.util.ArrayList;
import java.util.List;

public class Jugador {
    private final String nombre;
    private final List<Carta> mano;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.mano = new ArrayList<>();
    }

    public String getNombre() { return nombre; }

    // recibe una carta y la guarda en la mano
    public void recibirCarta(Carta c) {
        if (c != null) mano.add(c);
    }

    // devuelve la primera carta de la mano (útil para código simple)
    public Carta getCarta() {
        if (mano.isEmpty()) return null;
        return mano.get(0);
    }

    public List<Carta> getMano() { return mano; }

    public void limpiarMano() { mano.clear(); }
}
