public class Main {
    public static void main(String[] args) {
        // Necesario para que Swing use el hilo gráfico
        javax.swing.SwingUtilities.invokeLater(() -> new VentanaPrincipal());
    }
}
