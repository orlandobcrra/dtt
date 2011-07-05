package unet.compiladores.diagramas;

import unet.compiladores.diagramas.vista.Nuevo;

/**
 *
 * @author orlandobcrra
 */
public class Main {

    public Main() {
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
//                Modelo modelo = new Modelo();
//                new AreaDeTrabajoController(modelo);
                Nuevo dialog = new Nuevo(new javax.swing.JFrame(), true, null);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
}
