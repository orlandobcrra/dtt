package unet.compiladores.diagramas.vista.editores;

import java.awt.Color;
import java.awt.Point;
import java.awt.Window;
import java.awt.event.WindowEvent;
import javax.swing.JColorChooser;
import javax.swing.JOptionPane;
import unet.compiladores.diagramas.modelo.componentes.Compilador;
import unet.compiladores.diagramas.modelo.componentes.Figura;

/**
 *
 * @author orlandobcrra
 */
public class CompiladorEditor extends javax.swing.JDialog {

    private Compilador figuraModelo;
    private Window owner;

    public CompiladorEditor(Window owner, Point init, int TAM) {
        this(new Compilador(init, TAM), owner);
    }

    public CompiladorEditor(Compilador figuraModelo, Window owner) {
        super(owner);
        super.setModal(true);
        initComponents();
        this.owner = owner;
        this.figuraModelo = figuraModelo;
        this.fuente.setText(figuraModelo.getFuente());
        this.implementacion.setText(figuraModelo.getImplementacion());
        this.objeto.setText(figuraModelo.getObjeto());

        //para el color del boton
        this.jButton2.setBackground(figuraModelo.getColor());
        this.jButton2.setForeground(figuraModelo.getColorInvertido());

        this.setLocation(
                (owner.getSize().width - this.getSize().width) / 2 + owner.getLocation().x,
                (owner.getSize().height - this.getSize().height) / 2 + owner.getLocation().y);
        this.getRootPane().setDefaultButton(jButton1);
        this.setVisible(true);
    }

    public Figura getFigura() {
        return figuraModelo;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fuente = new javax.swing.JTextField();
        objeto = new javax.swing.JTextField();
        implementacion = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Datos del Compilador");
        setResizable(false);

        fuente.setToolTipText("Fuente");

        objeto.setToolTipText("Objeto");

        implementacion.setToolTipText("Implementacion");

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
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(fuente, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(implementacion, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(objeto, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fuente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(objeto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(implementacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
        if (this.fuente.getText().isEmpty() || this.implementacion.getText().isEmpty() || this.objeto.getText().isEmpty()) {
            JOptionPane.showMessageDialog(owner, "Algunos campos estan vacios", "Informacion", JOptionPane.WARNING_MESSAGE);
        } else {
            if (!figuraModelo.getFuente().equals(fuente.getText()) || !figuraModelo.getObjeto().equals(objeto.getText()) || !figuraModelo.getImplementacion().equals(implementacion.getText())) {
                figuraModelo.setDatos(fuente.getText(), objeto.getText(), implementacion.getText());
                figuraModelo.separar();
                figuraModelo.mover(-figuraModelo.getTAM(), -figuraModelo.getTAM(), false);
            }
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
    private javax.swing.JTextField fuente;
    private javax.swing.JTextField implementacion;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JTextField objeto;
    // End of variables declaration//GEN-END:variables
}