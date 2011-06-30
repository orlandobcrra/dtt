package unet.compiladores.diagramas;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import unet.compiladores.diagramas.controlador.AreaDeTrabajoController;
import unet.compiladores.diagramas.modelo.Modelo;

/*
 * Main.java
 *
 * Created on 28/06/2011, 07:41:19 AM
 */
/**
 *
 * @author orlandobcrra
 */
public class Main extends JFrame {

    private static JFrame mainFrame;
    public static final String DB_NAME = "database1";

    public Main() {
        initComponents();
        Dimension fullscreen = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension ventana = new Dimension(fullscreen.width - fullscreen.width / 10, fullscreen.height - fullscreen.height / 10);
        this.setSize(ventana);
        this.setLocation((fullscreen.width - ventana.width) / 2, (fullscreen.height - ventana.height) / 2);

        Modelo modelo = new Modelo();
        AreaDeTrabajoController controlador = new AreaDeTrabajoController(modelo);

        this.getContentPane().add(controlador.getVista());
        mainFrame = this;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Diagramas T");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static JFrame getMainFrame() {
        return mainFrame;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Main().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
