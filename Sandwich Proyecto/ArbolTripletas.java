import java.util.ArrayList;
import java.util.List;

public class ArbolTripletas {
    private NodoTripleta raiz;

    public void insertar(ResultadoPermutacion r) {
        raiz = insertarRec(raiz, r);
    }

    private NodoTripleta insertarRec(NodoTripleta actual, ResultadoPermutacion r) {
        if (actual == null) {
            return new NodoTripleta(r);
        }
        int cmp = r.getClave().compareTo(actual.dato.getClave());
        if (cmp < 0) {
            actual.izquierda = insertarRec(actual.izquierda, r);
        } else if (cmp > 0) {
            actual.derecha = insertarRec(actual.derecha, r);
        }
        return actual;
    }

    public ResultadoPermutacion buscarPorClave(String clave) {
        NodoTripleta actual = raiz;
        while (actual != null) {
            int cmp = clave.compareTo(actual.dato.getClave());
            if (cmp == 0) return actual.dato;
            if (cmp < 0) actual = actual.izquierda;
            else actual = actual.derecha;
        }
        return null;
    }

    public List<ResultadoPermutacion> enOrden() {
        List<ResultadoPermutacion> lista = new ArrayList<>();
        enOrdenRec(raiz, lista);
        return lista;
    }

    private void enOrdenRec(NodoTripleta nodo, List<ResultadoPermutacion> lista) {
        if (nodo == null) return;
        enOrdenRec(nodo.izquierda, lista);
        lista.add(nodo.dato);
        enOrdenRec(nodo.derecha, lista);
    }
}
