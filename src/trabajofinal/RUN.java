
package trabajofinal;

import Controlador.controlador;

import Vista.vista;

public class RUN {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Vista.vista view = new vista();

        Controlador.controlador ctr = new controlador(view);

        view.setVisible(true);

    }

}
