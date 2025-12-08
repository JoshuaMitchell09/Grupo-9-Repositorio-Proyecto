public class ResultadoPermutacion {
    private final Carta a;
    private final Carta b;
    private final Carta c;
    private final int cartasDelMazo;

    public ResultadoPermutacion(Carta a, Carta b, Carta c, int cartasDelMazo) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.cartasDelMazo = cartasDelMazo;
    }

    public Carta getA() { return a; }
    public Carta getB() { return b; }
    public Carta getC() { return c; }
    public int getCartasDelMazo() { return cartasDelMazo; }

    public String getClave() {
        // clave para el árbol (estructura de búsqueda)
        return a.getCodigo() + "|" + b.getCodigo() + "|" + c.getCodigo();
    }

    @Override
    public String toString() {
        return a + " " + b + " " + c + " → " + cartasDelMazo + " cartas";
    }
}
