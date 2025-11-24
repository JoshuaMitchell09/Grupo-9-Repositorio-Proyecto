import java.util.Scanner;

public class MainCLI {

    public static void main(String[] args) {
        Caja caja = new Caja();
        Mazo mazo = new Mazo();
        Mano mano = new Mano();
        Pozo pozo = new Pozo();

        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n=== The Sandwich Guy — CLI ===");
            System.out.println("1. Nueva partida (inicializar y mostrar caja)");
            System.out.println("2. Barajar (mueve caja->mazo y reparte 8 a la mano)");
            System.out.println("3. Mostrar Caja / Mazo / Mano / Pozo");
            System.out.println("4. Validar (¿existe algún sándwich en la mano?)");
            System.out.println("5. Tomar 1 carta del mazo a la mano");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            int opt = sc.nextInt(); sc.nextLine();

            switch (opt) {
                case 1:
                    caja.inicializarCaja();
                    mano.getCartas().clear();
                    pozo.asList().clear(); // asList devuelve copia => to clear pozo we can recreate; but simple:
                    System.out.println("Caja inicializada con 52 cartas.");
                    break;
                case 2:
                    if (caja.estaVacia()) {
                        System.out.println("Caja vacía, no hay cartas para barajar.");
                        break;
                    }
                    mazo.barajarDesdeCaja(caja);
                    // repartir 8 cartas a la mano (o menos si mazo menor)
                    mano.getCartas().clear();
                    for (int i=0; i<8 && !mazo.estaVacio(); i++) {
                        Carta c = mazo.sacar();
                        mano.agregar(c);
                    }
                    System.out.println("Barajado y repartidas " + mano.size() + " cartas a la mano.");
                    break;
                case 3:
                    System.out.println("Caja: " + caja.getCartas());
                    System.out.println("Mazo (size): " + mazo.size());
                    System.out.println("Mano: " + mano.getCartas());
                    System.out.println("Pozo: " + pozo.asList());
                    break;
                case 4:
                    boolean ok = JuegoEngine.hasAnyValidSandwich(mano.getCartas());
                    System.out.println("¿Existe algún sándwich en la mano? " + (ok ? "SÍ" : "NO"));
                    break;
                case 5:
                    if (mazo.estaVacio()) System.out.println("Mazo vacío.");
                    else {
                        Carta d = mazo.sacar();
                        mano.agregar(d);
                        System.out.println("Tomada: " + d);
                    }
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }

        sc.close();
    }
}

