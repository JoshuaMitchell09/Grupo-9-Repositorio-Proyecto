import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class JuegoCartas extends JFrame {
    private ArrayList<Carta> baraja = new ArrayList<>();
    private JPanel panelMazo, panelMano, panelPozo, panelCaja;

    public JuegoCartas() {
        setTitle("Juego de Cartas - Avance 1");
        setSize(900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        crearBaraja();
        crearInterfaz();

        setVisible(true);
    }

    private void crearBaraja() {
        String[] palos = {"♥", "♦", "♠", "♣"};
        String[] valores = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

        for (String palo : palos) {
            for (String valor : valores) {
                baraja.add(new Carta(valor, palo));
            }
        }
    }

    private void crearInterfaz() {
        JPanel panelPrincipal = new JPanel(new GridLayout(2, 2, 10, 10));

        panelCaja = crearPanel("Caja (52 Cartas)");
        panelMazo = crearPanel("Mazo (Boca Abajo)");
        panelMano = crearPanel("Mano (Boca Arriba)");
        panelPozo = crearPanel("Pozo (Descartadas)");

        panelPrincipal.add(panelCaja);
        panelPrincipal.add(panelMazo);
        panelPrincipal.add(panelMano);
        panelPrincipal.add(panelPozo);

        add(panelPrincipal, BorderLayout.CENTER);
        add(crearBotonera(), BorderLayout.SOUTH);
    }

    private JPanel crearPanel(String titulo) {
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createTitledBorder(titulo));
        panel.setBackground(new Color(240, 240, 240));
        panel.add(new JLabel("Contenido visual aquí (boceto)"));
        return panel;
    }

    private JPanel crearBotonera() {
        JPanel botonera = new JPanel();
        String[] botones = {"Nueva Partida", "Cargar Partida", "Barajar", "Ordenar Mano", "Salir"};

        for (String texto : botones) {
            JButton btn = new JButton(texto);
            btn.setFocusPainted(false);
            botonera.add(btn);
        }

        return botonera;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new JuegoCartas());
    }
}
