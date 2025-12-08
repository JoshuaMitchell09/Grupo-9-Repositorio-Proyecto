import java.util.ArrayList;
import java.util.List;

public class SandwichEvaluator {

    private static int distanciaCircular(Valor a, Valor b) {
        int v1 = a.getOrden();
        int v2 = b.getOrden();
        int diff = Math.abs(v1 - v2);
        return Math.min(diff, 13 - diff);
    }

    private static boolean esSandwich(Carta x, Carta y, Carta z) {
        int d1 = distanciaCircular(x.getValor(), y.getValor());
        int d2 = distanciaCircular(y.getValor(), z.getValor());
        return d1 == d2;
    }

    private static int cartasDelMazo(Carta a, Carta b, Carta c) {
        // Primero vemos si alguna permutación forma sándwich
        boolean esValido = esSandwich(a, b, c) ||
                           esSandwich(a, c, b) ||
                           esSandwich(b, a, c) ||
                           esSandwich(b, c, a) ||
                           esSandwich(c, a, b) ||
                           esSandwich(c, b, a);

        if (!esValido) return 0;

        // Ahora ver tipo de sándwich por palos/colores
        boolean mismoPalo = a.getPalo() == b.getPalo() && b.getPalo() == c.getPalo();
        if (mismoPalo) return 4;

        boolean mismoColor = a.getColor().equals(b.getColor()) &&
                             b.getColor().equals(c.getColor());
        if (mismoColor) return 3;

        return 2; // válido pero palos de distinto color
    }

    public static List<ResultadoPermutacion> evaluarTripleta(Carta c1, Carta c2, Carta c3) {
        List<ResultadoPermutacion> lista = new ArrayList<>();
        lista.add(new ResultadoPermutacion(c1, c2, c3, cartasDelMazo(c1, c2, c3)));
        lista.add(new ResultadoPermutacion(c1, c3, c2, cartasDelMazo(c1, c3, c2)));
        lista.add(new ResultadoPermutacion(c2, c3, c1, cartasDelMazo(c2, c3, c1)));
        lista.add(new ResultadoPermutacion(c2, c1, c3, cartasDelMazo(c2, c1, c3)));
        lista.add(new ResultadoPermutacion(c3, c1, c2, cartasDelMazo(c3, c1, c2)));
        lista.add(new ResultadoPermutacion(c3, c2, c1, cartasDelMazo(c3, c2, c1)));
        return lista;
    }

    public static boolean hayAlgunSandwichValido(List<Carta> mano) {
        int n = mano.size();
        if (n < 3) return false;

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    Carta a = mano.get(i);
                    Carta b = mano.get(j);
                    Carta c = mano.get(k);
                    if (cartasDelMazo(a, b, c) > 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
