import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class JuegoCartas extends JFrame {
    private Caja caja;
    private Mazo mazo;
    private JTextArea areaCaja;
    private JTextArea areaMazo;

    public JuegoCartas() {
        setTitle("The Sandwich Guy - Avance II");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        caja = new Caja();
        mazo = new Mazo();

        JPanel panelPrincipal = new JPanel(new BorderLayout());

        // Panel de botones
        JPanel panelBotones = new JPanel();
        JButton btnBarajar = new JButton("Barajar");
        panelBotones.add(btnBarajar);
        panelPrincipal.add(panelBotones, BorderLayout.NORTH);

        // Panel de texto
        JPanel panelTextos = new JPanel(new GridLayout(2, 1));

        areaCaja = new JTextArea();
        areaCaja.setEditable(false);
        areaCaja.setBorder(BorderFactory.createTitledBorder("Caja (Cartas Originales)"));
        actualizarAreaCaja();

        areaMazo = new JTextArea();
        areaMazo.setEditable(false);
        areaMazo.setBorder(BorderFactory.createTitledBorder("Mazo (Barajado)"));

        panelTextos.add(new JScrollPane(areaCaja));
        panelTextos.add(new JScrollPane(areaMazo));

        panelPrincipal.add(panelTextos, BorderLayout.CENTER);

        add(panelPrincipal);

        // Acción del botón Barajar
        btnBarajar.addActionListener((ActionEvent e) -> {
            if (!caja.estaVacia()) {
                mazo.barajarDesdeCaja(caja);
                actualizarAreaCaja();
                actualizarAreaMazo();
                JOptionPane.showMessageDialog(this, "Las cartas fueron barajadas correctamente.");
            } else {
                JOptionPane.showMessageDialog(this, "La Caja está vacía.");
            }
        });
    }

    private void actualizarAreaCaja() {
        areaCaja.setText(caja.getCartas().toString());
    }

    private void actualizarAreaMazo() {
        areaMazo.setText(mazo.getPilaCartas().toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new JuegoCartas().setVisible(true);
        });
    }
}
