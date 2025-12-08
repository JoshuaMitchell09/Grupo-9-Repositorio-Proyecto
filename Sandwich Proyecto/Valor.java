public enum Valor {
    A(1, "As"),
    DOS(2, "Dos"),
    TRES(3, "Tres"),
    CUATRO(4, "Cuatro"),
    CINCO(5, "Cinco"),
    SEIS(6, "Seis"),
    SIETE(7, "Siete"),
    OCHO(8, "Ocho"),
    NUEVE(9, "Nueve"),
    DIEZ(10, "Diez"),
    J(11, "Jota"),
    Q(12, "Quina"),
    K(13, "Ka");

    private final int orden;
    private final String nombre;

    Valor(int orden, String nombre) {
        this.orden = orden;
        this.nombre = nombre;
    }

    public int getOrden() {
        return orden;
    }

    public String getNombre() {
        return nombre;
    }
}
