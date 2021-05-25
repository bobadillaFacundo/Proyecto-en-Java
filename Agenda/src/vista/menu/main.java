package vista.menu;

import controlador.Controlador;

public class Main {
    public static void main (String [] args) {
		new Thread (new Principal(new Controlador())).start();
		}
}
