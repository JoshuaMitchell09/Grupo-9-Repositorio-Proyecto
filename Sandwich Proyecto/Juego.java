import java.util.ArrayList;
import java.util.List;

public class Juego {

    private Caja caja;
    private Mazo mazo;
    private Mano mano;
    private Pozo pozo;
    private EstadoPartida estado;

    public Juego() {
        nuevaPartida();
    }

    public void nuevaPartida() {
        caja = new Caja();
        mazo = new Mazo();
        mano = new Mano();
        pozo = new Pozo();
        estado = EstadoPartida.EN_PROGRESO;
    }

    public Caja getCaja() { return caja; }
    public Mazo getMazo() { return mazo; }
    public Mano getMano() { return mano; }
    public Pozo getPozo() { return pozo; }
    public EstadoPartida getEstado() { return estado; }

    // <-- NUEVO: setter para que PersistenciaXML pueda restaurar el estado
    public void setEstado(EstadoPartida estado) {
        this.estado = estado;
    }

    public void barajar() {
        if (estado != EstadoPartida.EN_PROGRESO) return;
        mazo.cargarDesdeCaja(new ArrayList<>(caja.getCartas()));
        caja.limpiar();
        mano.limpiar();
        pozo.limpiar();
        rellenarManoHasta8();
        verificarVictoriaPorMazoVacio();
    }

    public void rellenarManoHasta8() {
        while (!mazo.estaVacio() && mano.size() < 8) {
            mano.agregarCarta(mazo.tomar());
        }
        verificarVictoriaPorMazoVacio();
    }

    private void verificarVictoriaPorMazoVacio() {
        // Solo marcar GANADA si la partida sigue en progreso
        if (estado == EstadoPartida.EN_PROGRESO &&
            mazo.estaVacio() && mano.size() == 0) {
            estado = EstadoPartida.GANADA;
        }
    }

    public void ordenarMano() {
        mano.ordenarPorValor();
    }

    public boolean validarMano() {
        boolean hay = SandwichEvaluator.hayAlgunSandwichValido(mano.getCartas());
        if (!hay) {
            estado = EstadoPartida.PERDIDA;
        }
        return hay;
    }

    public List<ResultadoPermutacion> evaluarTripletaIndices(int i1, int i2, int i3) {
        List<Carta> cartas = mano.getCartas();
        Carta c1 = cartas.get(i1);
        Carta c2 = cartas.get(i2);
        Carta c3 = cartas.get(i3);

        List<ResultadoPermutacion> lista = SandwichEvaluator.evaluarTripleta(c1, c2, c3);

        // Cargar en árbol (estructura de búsqueda)
        ArbolTripletas arbol = new ArbolTripletas();
        for (ResultadoPermutacion r : lista) {
            arbol.insertar(r);
        }
        // devolvemos el recorrido en orden
        return arbol.enOrden();
    }

    public int aplicarTripletaYRobar(List<Integer> indicesSeleccionados, int cartasDelMazo) {
        if (estado != EstadoPartida.EN_PROGRESO) return 0;
        if (cartasDelMazo <= 0) return 0;

        // Sacar las cartas seleccionadas de la mano (por referencia)
        List<Carta> copia = new ArrayList<>(mano.getCartas());
        List<Carta> aEliminar = new ArrayList<>();
        for (int idx : indicesSeleccionados) {
            aEliminar.add(copia.get(idx));
        }

        for (Carta c : aEliminar) {
            mano.eliminarCarta(c);
            pozo.descartar(c);
        }

        // Robar del mazo según las reglas, sin pasar de 8 cartas en mano
        int robadas = 0;
        while (robadas < cartasDelMazo && !mazo.estaVacio() && mano.size() < 8) {
            mano.agregarCarta(mazo.tomar());
            robadas++;
        }

        verificarVictoriaPorMazoVacio();
        return robadas;
    }

    public void marcarPerdidaSiNoHaySandwich() {
        if (!SandwichEvaluator.hayAlgunSandwichValido(mano.getCartas())) {
            estado = EstadoPartida.PERDIDA;
        }
    }
}

