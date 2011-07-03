/*
 * xxx.java
 *
 * Created on 03/07/2011, 06:53:31 AM
 */
package unet.compiladores.diagramas.vista;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import unet.compiladores.diagramas.controlador.AreaDeTrabajoController;
import unet.compiladores.diagramas.controlador.LienzoController;
import unet.compiladores.diagramas.modelo.Modelo;
import unet.compiladores.diagramas.modelo.componentes.Figura;

/**
 *
 * @author orlandobcrra
 */
public class AreaDeTrabajo extends javax.swing.JFrame {

    /** Creates new form xxx */
    public AreaDeTrabajo(Modelo modelo, AreaDeTrabajoController controlador, LienzoController lienzoController) {
        initComponents();

        Dimension fullscreen = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension ventana = new Dimension(fullscreen.width - fullscreen.width / 2, fullscreen.height - fullscreen.height / 2);
        this.setSize(ventana);
        this.setLocation((fullscreen.width - ventana.width) / 2, (fullscreen.height - ventana.height) / 2);

        agregar.addActionListener(controlador);
        ayuda.addActionListener(controlador);
        restaurar.addActionListener(controlador);
        guardar.addActionListener(controlador);

        jScrollPane1.setViewportView(lienzoController.getVista());

        this.setVisible(true);
    }

    public ButtonGroup getTipoComponente() {
        return tipoComponente;
    }

    public JButton getAgregar() {
        return agregar;
    }

    public JButton getAyuda() {
        return ayuda;
    }

    public JButton getGuardar() {
        return guardar;
    }

    public JButton getRestaurar() {
        return restaurar;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tipoComponente = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        radioCompildor = new javax.swing.JRadioButton();
        programa = new javax.swing.JRadioButton();
        maquina = new javax.swing.JRadioButton();
        interprete = new javax.swing.JRadioButton();
        agregar = new javax.swing.JButton();
        ayuda = new javax.swing.JButton();
        restaurar = new javax.swing.JButton();
        guardar = new javax.swing.JButton();
        jSlider1 = new javax.swing.JSlider();
        jScrollPane1 = new javax.swing.JScrollPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Diagramado de Tombstone");

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tipoComponente.add(radioCompildor);
        radioCompildor.setMnemonic('C');
        radioCompildor.setText("Compilador");

        tipoComponente.add(programa);
        programa.setMnemonic('P');
        programa.setText("Programa");

        tipoComponente.add(maquina);
        maquina.setMnemonic('M');
        maquina.setText("Maquina");

        tipoComponente.add(interprete);
        interprete.setMnemonic('I');
        interprete.setText("Interprete");

        agregar.setText("Agregar");

        ayuda.setText("Ayuda");

        restaurar.setText("Restaurar");

        guardar.setText("Guardar");

        jSlider1.setMaximum(180);
        jSlider1.setMinimum(10);
        jSlider1.setValue(Figura.TAM);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(radioCompildor)
                    .addComponent(programa))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(interprete)
                    .addComponent(maquina))
                .addGap(18, 18, 18)
                .addComponent(agregar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                .addComponent(guardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(restaurar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ayuda)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(guardar, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(restaurar, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ayuda, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(radioCompildor)
                                .addComponent(maquina))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(programa)
                                .addComponent(interprete)))))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 840, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 864, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 485, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregar;
    private javax.swing.JButton ayuda;
    private javax.swing.JButton guardar;
    private javax.swing.JRadioButton interprete;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JRadioButton maquina;
    private javax.swing.JRadioButton programa;
    private javax.swing.JRadioButton radioCompildor;
    private javax.swing.JButton restaurar;
    private javax.swing.ButtonGroup tipoComponente;
    // End of variables declaration//GEN-END:variables
}
