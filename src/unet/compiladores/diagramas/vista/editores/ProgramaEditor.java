/*
 * ProgramaEditor.java
 *
 * Created on 28/06/2011, 02:59:21 PM
 */
package unet.compiladores.diagramas.vista.editores;

import java.awt.Color;
import java.awt.Point;
import java.awt.Window;
import java.awt.event.WindowEvent;
import javax.swing.JColorChooser;
import javax.swing.JOptionPane;
import unet.compiladores.diagramas.modelo.componentes.Figura;
import unet.compiladores.diagramas.modelo.componentes.Programa;

/**
 *
 * @author orlandobcrra
 */
public class ProgramaEditor extends javax.swing.JDialog {

    private Programa figuraModelo;
    private Window owner;

    public ProgramaEditor(Window owner, Point init, int TAM) {
        this(new Programa(init, TAM), owner);
    }

    public ProgramaEditor(Programa figuraModelo, Window owner) {
        super(owner);
        super.setModal(true);
        initComponents();
        this.owner = owner;
        this.lenguaje.setText(figuraModelo.getLenguaje());
        this.nombre.setText(figuraModelo.getNombre());
        this.figuraModelo = figuraModelo;
        this.setLocation(
                (owner.getSize().width - this.getSize().width) / 2 + owner.getLocation().x,
                (owner.getSize().height - this.getSize().height) / 2 + owner.getLocation().y);
        //para el color del boton
        this.jButton2.setBackground(figuraModelo.getColor());
        this.jButton2.setForeground(figuraModelo.getColorInvertido());
        this.getRootPane().setDefaultButton(jButton1);
        this.setVisible(true);
    }

    public Figura getFigura() {
        return figuraModelo;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nombre = new javax.swing.JTextField();
        lenguaje = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        nombre.setToolTipText("Nombre del Programa");

        lenguaje.setToolTipText("Lenguaje");

        jButton1.setText("Aceptar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Color");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                    .addComponent(lenguaje, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lenguaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void processWindowEvent(WindowEvent e) {
        super.processWindowEvent(e);
        if (e.getID() == WindowEvent.WINDOW_CLOSING) {
            figuraModelo = null;
        }
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (this.lenguaje.getText().isEmpty() || this.nombre.getText().isEmpty()) {
            JOptionPane.showMessageDialog(owner, "Algunos campos estan vacios", "Informacion", JOptionPane.WARNING_MESSAGE);
        } else {
            figuraModelo.setDatos(nombre.getText(), lenguaje.getText());
            this.setVisible(false);
            this.dispose();
        }

}//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Color c = JColorChooser.showDialog(owner, "Color", figuraModelo.getColor());
        if (c != null) {
            figuraModelo.setColor(c);
            //color del boton
            jButton2.setBackground(c);
            jButton2.setForeground(figuraModelo.getColorInvertido());
        }
}//GEN-LAST:event_jButton2ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JTextField lenguaje;
    private javax.swing.JTextField nombre;
    // End of variables declaration//GEN-END:variables
}
