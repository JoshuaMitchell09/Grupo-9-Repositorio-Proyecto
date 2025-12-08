import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;

public class PersistenciaXML {

    public static void guardarJuego(Juego juego, File archivo) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.newDocument();

        Element root = doc.createElement("Juego");
        doc.appendChild(root);

        // Estado de la partida
        Element estado = doc.createElement("Estado");
        estado.setTextContent(juego.getEstado().name());
        root.appendChild(estado);

        // Caja
        Element cajaElem = doc.createElement("Caja");
        for (Carta c : juego.getCaja().getCartas()) {
            cajaElem.appendChild(crearElementoCarta(doc, c));
        }
        root.appendChild(cajaElem);

        // Mazo
        Element mazoElem = doc.createElement("Mazo");
        for (Carta c : juego.getMazo().getPila()) {
            mazoElem.appendChild(crearElementoCarta(doc, c));
        }
        root.appendChild(mazoElem);

        // Mano
        Element manoElem = doc.createElement("Mano");
        for (Carta c : juego.getMano().getCartas()) {
            manoElem.appendChild(crearElementoCarta(doc, c));
        }
        root.appendChild(manoElem);

        // Pozo
        Element pozoElem = doc.createElement("Pozo");
        for (Carta c : juego.getPozo().getCartas()) {
            pozoElem.appendChild(crearElementoCarta(doc, c));
        }
        root.appendChild(pozoElem);

        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.transform(new DOMSource(doc), new StreamResult(archivo));
    }

    private static Element crearElementoCarta(Document doc, Carta c) {
        Element carta = doc.createElement("Carta");
        carta.setAttribute("valor", c.getValor().name());
        carta.setAttribute("palo", c.getPalo().name());
        return carta;
    }

    public static Juego cargarJuego(File archivo) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(archivo);
        doc.getDocumentElement().normalize();

        Element root = doc.getDocumentElement();

        // Leemos primero el estado guardado
        String estadoStr = root.getElementsByTagName("Estado").item(0).getTextContent();

        Juego juego = new Juego();
        // Reiniciamos estructuras
        juego.getCaja().limpiar();
        juego.getMazo().getPila().clear();
        juego.getMano().limpiar();
        juego.getPozo().limpiar();

        // Cargar cada sección
        cargarSeccionCartas(root, "Caja", juego.getCaja(), null, null, null);
        cargarSeccionCartas(root, "Mazo", null, juego.getMazo(), null, null);
        cargarSeccionCartas(root, "Mano", null, null, juego.getMano(), null);
        cargarSeccionCartas(root, "Pozo", null, null, null, juego.getPozo());

        // Aplicar estado guardado (GANADA / PERDIDA / EN_PROGRESO)
        try {
            EstadoPartida est = EstadoPartida.valueOf(estadoStr);
            juego.setEstado(est);
        } catch (IllegalArgumentException e) {
            // Si algo raro pasa con el string, dejamos EN_PROGRESO
        }

        return juego;
    }

    private static void cargarSeccionCartas(Element root,
                                            String nombreSeccion,
                                            Caja caja,
                                            Mazo mazo,
                                            Mano mano,
                                            Pozo pozo) {
        NodeList listas = root.getElementsByTagName(nombreSeccion);
        if (listas.getLength() == 0) return;
        Element seccion = (Element) listas.item(0);
        NodeList cartas = seccion.getElementsByTagName("Carta");
        for (int i = 0; i < cartas.getLength(); i++) {
            Element cElem = (Element) cartas.item(i);
            Valor v = Valor.valueOf(cElem.getAttribute("valor"));
            Palo p = Palo.valueOf(cElem.getAttribute("palo"));
            Carta c = new Carta(v, p);

            if (caja != null) caja.agregarCartaAlFinal(c);
            if (mazo != null) mazo.getPila().addLast(c);
            if (mano != null) mano.agregarCarta(c);
            if (pozo != null) pozo.descartar(c);
        }
    }
}
