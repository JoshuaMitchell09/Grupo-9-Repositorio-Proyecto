import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class VentanaPrincipal extends JFrame {

    private Juego juego;

    private JTextArea areaCaja;
    private JTextArea areaMazo;
    private JTextArea areaPozo;
    private JLabel labelEstado;
    private JToggleButton[] botonesMano;
    private JButton btnEvaluarTripleta;

    public VentanaPrincipal() {
        super("The Sandwich Guy - SC-304");

        juego = new Juego();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1100, 700);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        initUI();
        actualizarVistaCompleta();

        setVisible(true);
    }

    private void initUI() {
        // ----- Panel superior (botones de control) -----
        JPanel panelNorte = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton btnNueva   = new JButton("Nueva Partida");
        JButton btnBarajar = new JButton("Barajar");
        JButton btnOrdenar = new JButton("Ordenar Mano");
        JButton btnValidar = new JButton("Validar Mano");
        JButton btnGuardar = new JButton("Guardar");
        JButton btnCargar  = new JButton("Cargar");
        JButton btnVerMazo = new JButton("Ver Mazo");
        JButton btnVerPozo = new JButton("Ver Pozo");

        panelNorte.add(btnNueva);
        panelNorte.add(btnBarajar);
        panelNorte.add(btnOrdenar);
        panelNorte.add(btnValidar);
        panelNorte.add(btnGuardar);
        panelNorte.add(btnCargar);
        panelNorte.add(btnVerMazo);
        panelNorte.add(btnVerPozo);

        add(panelNorte, BorderLayout.NORTH);

        // ----- Panel central: Caja, Mazo, Pozo -----
        JPanel panelCentro = new JPanel(new GridLayout(1, 3));

        areaCaja = new JTextArea();
        areaCaja.setEditable(false);

        areaMazo = new JTextArea();
        areaMazo.setEditable(false);

        areaPozo = new JTextArea();
        areaPozo.setEditable(false);

        panelCentro.add(crearPanelConTitulo("Caja (Lista doble)", new JScrollPane(areaCaja)));
        panelCentro.add(crearPanelConTitulo("Mazo (Pila)", new JScrollPane(areaMazo)));
        panelCentro.add(crearPanelConTitulo("Pozo (Cola)", new JScrollPane(areaPozo)));

        add(panelCentro, BorderLayout.CENTER);

        // ----- Panel inferior: Mano + estado -----
        JPanel panelSur = new JPanel(new BorderLayout());

        JPanel panelMano = new JPanel(new GridLayout(1, 8, 5, 5));
        botonesMano = new JToggleButton[8];
        for (int i = 0; i < 8; i++) {
            JToggleButton btn = new JToggleButton("Vacío");
            btn.addActionListener(e -> actualizarBotonEvaluar());
            botonesMano[i] = btn;
            panelMano.add(btn);
        }
        panelSur.add(crearPanelConTitulo("Mano (Lista circular)", panelMano), BorderLayout.CENTER);

        JPanel panelSurInf = new JPanel(new FlowLayout(FlowLayout.LEFT));
        btnEvaluarTripleta = new JButton("Evaluar tripleta seleccionada");
        btnEvaluarTripleta.setEnabled(false);
        labelEstado = new JLabel("Estado: EN_PROGRESO");
        panelSurInf.add(btnEvaluarTripleta);
        panelSurInf.add(labelEstado);

        panelSur.add(panelSurInf, BorderLayout.SOUTH);

        add(panelSur, BorderLayout.SOUTH);

        // ====== LISTENERS ======

        btnNueva.addActionListener(e -> {
            juego.nuevaPartida();
            actualizarVistaCompleta();
        });

        btnBarajar.addActionListener(e -> {
            juego.barajar();
            actualizarVistaCompleta();
        });

        btnOrdenar.addActionListener(e -> {
            juego.ordenarMano();
            actualizarVistaCompleta();
        });

        btnValidar.addActionListener(e -> {
            boolean hay = juego.validarMano();
            if (hay) {
                JOptionPane.showMessageDialog(this,
                        "Sí existe al menos un sándwich válido en la Mano.",
                        "Validación", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this,
                        "No hay ningún sándwich válido. ¡Partida perdida!",
                        "Validación", JOptionPane.WARNING_MESSAGE);
            }
            actualizarVistaCompleta();
        });

        btnGuardar.addActionListener(e -> guardarEnArchivo());

        btnCargar.addActionListener(e -> cargarDesdeArchivo());

        btnEvaluarTripleta.addActionListener(e -> evaluarTripletaSeleccionada());

        btnVerMazo.addActionListener(e -> mostrarMazoBocaArriba());

        btnVerPozo.addActionListener(e -> mostrarPozoBocaArriba());
    }

    private JPanel crearPanelConTitulo(String titulo, JComponent contenido) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder(titulo));
        panel.add(contenido, BorderLayout.CENTER);
        return panel;
    }

    // ----- Refrescar todo en pantalla -----
    private void actualizarVistaCompleta() {
        // Caja
        StringBuilder sbCaja = new StringBuilder();
        int i = 1;
        for (Carta c : juego.getCaja().getCartas()) {
            sbCaja.append(i++).append(". ").append(c).append("\n");
        }
        areaCaja.setText(sbCaja.toString());

        // Mazo (boca abajo)
        StringBuilder sbMazo = new StringBuilder();
        sbMazo.append("Cartas en mazo: ").append(juego.getMazo().size()).append("\n\n");
        sbMazo.append("(Contenido oculto)");
        areaMazo.setText(sbMazo.toString());

        // Pozo (boca abajo)
        StringBuilder sbPozo = new StringBuilder();
        sbPozo.append("Cartas en pozo: ").append(juego.getPozo().size()).append("\n\n");
        sbPozo.append("(Contenido oculto)");
        areaPozo.setText(sbPozo.toString());

        // Mano
        List<Carta> mano = juego.getMano().getCartas();
        for (int j = 0; j < 8; j++) {
            JToggleButton btn = botonesMano[j];
            if (j < mano.size()) {
                btn.setText(mano.get(j).toString());
                btn.setEnabled(true);
            } else {
                btn.setText("Vacío");
                btn.setEnabled(false);
                btn.setSelected(false);
            }
        }

        labelEstado.setText("Estado: " + juego.getEstado().name());
        actualizarBotonEvaluar();
    }

    private void actualizarBotonEvaluar() {
        int seleccionados = 0;
        for (JToggleButton btn : botonesMano) {
            if (btn.isEnabled() && btn.isSelected()) {
                seleccionados++;
            }
        }
        btnEvaluarTripleta.setEnabled(
                seleccionados == 3 && juego.getEstado() == EstadoPartida.EN_PROGRESO
        );
    }

    // ----- Evaluar tripleta seleccionada -----
    private void evaluarTripletaSeleccionada() {
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            if (botonesMano[i].isEnabled() && botonesMano[i].isSelected()) {
                indices.add(i);
            }
        }
        if (indices.size() != 3) {
            JOptionPane.showMessageDialog(this,
                    "Debes seleccionar exactamente 3 cartas.",
                    "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        List<ResultadoPermutacion> resultados =
                juego.evaluarTripletaIndices(indices.get(0), indices.get(1), indices.get(2));

        StringBuilder msg = new StringBuilder("Permutaciones de la tripleta seleccionada:\n\n");
        int maxCartas = 0;
        for (ResultadoPermutacion r : resultados) {
            msg.append(r.toString()).append("\n");
            if (r.getCartasDelMazo() > maxCartas) {
                maxCartas = r.getCartasDelMazo();
            }
        }

        msg.append("\nMejor cantidad de cartas a tomar del mazo: ").append(maxCartas).append("\n");

        if (maxCartas == 0) {
            msg.append("\nLa tripleta NO forma un sándwich válido.");
            JOptionPane.showMessageDialog(this, msg.toString(),
                    "Evaluación de tripleta", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        int resp = JOptionPane.showConfirmDialog(this,
                msg.toString() + "\n¿Deseas enviar las cartas al Pozo y tomar cartas del Mazo?",
                "Aplicar mejor sándwich",
                JOptionPane.YES_NO_OPTION);

        if (resp == JOptionPane.YES_OPTION) {
            juego.aplicarTripletaYRobar(indices, maxCartas);
            actualizarVistaCompleta();
        }
    }

    // ----- Guardar/Cargar -----
    private void guardarEnArchivo() {
        JFileChooser chooser = new JFileChooser();
        int resp = chooser.showSaveDialog(this);
        if (resp == JFileChooser.APPROVE_OPTION) {
            File f = chooser.getSelectedFile();
            try {
                PersistenciaXML.guardarJuego(juego, f);
                JOptionPane.showMessageDialog(this,
                        "Partida guardada en:\n" + f.getAbsolutePath());
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this,
                        "Error al guardar: " + ex.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void cargarDesdeArchivo() {
        JFileChooser chooser = new JFileChooser();
        int resp = chooser.showOpenDialog(this);
        if (resp == JFileChooser.APPROVE_OPTION) {
            File f = chooser.getSelectedFile();
            try {
                juego = PersistenciaXML.cargarJuego(f);
                JOptionPane.showMessageDialog(this,
                        "Partida cargada desde:\n" + f.getAbsolutePath());
                actualizarVistaCompleta();
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this,
                        "Error al cargar: " + ex.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // ----- Ver mazo/pozo boca arriba en diálogos -----
    private void mostrarMazoBocaArriba() {
        int size = juego.getMazo().size();
        if (size == 0) {
            JOptionPane.showMessageDialog(this,
                    "No hay cartas en el mazo.",
                    "Mazo", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        StringBuilder sb = new StringBuilder("Cartas en mazo: " + size + "\n\n");
        for (Carta c : juego.getMazo().getPila()) {
            sb.append(c).append("\n");
        }
        JOptionPane.showMessageDialog(this, sb.toString(),
                "Mazo (boca arriba)", JOptionPane.INFORMATION_MESSAGE);
    }

    private void mostrarPozoBocaArriba() {
        int size = juego.getPozo().size();
        if (size == 0) {
            JOptionPane.showMessageDialog(this,
                    "No hay cartas en el pozo.",
                    "Pozo", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        StringBuilder sb = new StringBuilder("Cartas en pozo: " + size + "\n\n");
        for (Carta c : juego.getPozo().getCartas()) {
            sb.append(c).append("\n");
        }
        JOptionPane.showMessageDialog(this, sb.toString(),
                "Pozo (boca arriba)", JOptionPane.INFORMATION_MESSAGE);
    }
}




