import java.util.ArrayList;
import java.util.List;

public class JuegoEngine {

    // distancia en sentido horario (pasos) de a -> b sobre 1..13
    private static int distanciaHorario(int a, int b) {
        int d = (b - a + 13) % 13;
        return d;
    }

    // revisa si el orden [a,b,c] forma sándwich válido (d(a,b) == d(b,c))
    public static boolean isValidSandwich(Carta a, Carta b, Carta c) {
        int va = a.getValor();
        int vb = b.getValor();
        int vc = c.getValor();
        int d1 = distanciaHorario(va, vb);
        int d2 = distanciaHorario(vb, vc);
        return d1 == d2;
    }

    // dado 3 cartas (en cualquier orden), verifica si existe alguna permutación válida
    public static boolean hasAnyValidSandwich(List<Carta> mano) {
        int n = mano.size();
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++)
                for (int k = j + 1; k < n; k++) {
                    Carta x = mano.get(i), y = mano.get(j), z = mano.get(k);
                    if (permAnyValid(x, y, z)) return true;
                }
        return false;
    }

    private static boolean permAnyValid(Carta x, Carta y, Carta z) {
        if (isValidSandwich(x, y, z)) return true;
        if (isValidSandwich(x, z, y)) return true;
        if (isValidSandwich(y, x, z)) return true;
        if (isValidSandwich(y, z, x)) return true;
        if (isValidSandwich(z, x, y)) return true;
        if (isValidSandwich(z, y, x)) return true;
        return false;
    }

    // evalúa las 6 permutaciones de las cartas en índices i,j,k y devuelve cantidad de cartas a tomar por permutacion
    // 4 = mismo palo, 3 = mismo color, 2 = distintos colores, 0 = no válido
    public static List<Integer> evaluatePermutationsForIndices(List<Carta> cartas, int i, int j, int k) {
        List<Integer> results = new ArrayList<>();
        Carta[] arr = {cartas.get(i), cartas.get(j), cartas.get(k)};
        // seis permutaciones manualmente
        int[][] perms = {{0,1,2},{0,2,1},{1,2,0},{1,0,2},{2,0,1},{2,1,0}};
        for (int[] p : perms) {
            Carta a = arr[p[0]], b = arr[p[1]], c = arr[p[2]];
            if (!isValidSandwich(a,b,c)) {
                results.add(0);
                continue;
            }
            // determine draws based on suits/colors
            boolean samePalo = (a.getPalo() == b.getPalo() && b.getPalo() == c.getPalo());
            boolean sameColor = a.getColor().equals(b.getColor()) && b.getColor().equals(c.getColor());
            if (samePalo) results.add(4);
            else if (sameColor) results.add(3);
            else results.add(2);
        }
        return results;
    }
}
