package unet.compiladores.diagramas.vista.editores;

import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;
import unet.compiladores.diagramas.Main;
import unet.compiladores.diagramas.modelo.componentes.Figura;
import unet.compiladores.diagramas.modelo.componentes.Interprete;

/**
 *
 * @author orlandobcrra
 */
public class InterpreteEditor extends javax.swing.JDialog {

    private Interprete figuraModelo;

    public InterpreteEditor() {
        this(new Interprete());
    }

    public InterpreteEditor(Interprete figuraModelo) {
        super(Main.getMainFrame(), true);
        initComponents();
        this.l.setText(figuraModelo.getL());
        this.m.setText(figuraModelo.getM());
        this.figuraModelo = figuraModelo;
        this.setLocation(
                (Main.getMainFrame().getSize().width - this.getSize().width) / 2 + Main.getMainFrame().getLocation().x,
                (Main.getMainFrame().getSize().height - this.getSize().height) / 2 + Main.getMainFrame().getLocation().y);
        this.setVisible(true);
    }

    public Figura getFigura() {
        return figuraModelo;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        l = new javax.swing.JTextField();
        m = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Datos del Compilador");
        setResizable(false);

        l.setToolTipText("Fuente");

        m.setToolTipText("Objeto");

        jButton1.setText("Aceptar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(l, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                    .addComponent(m, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(l, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(m, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
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
        
        if(this.l.getText().isEmpty() || this.m.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(Main.getMainFrame(), "Algunos campos estan vacios", "Informacion", JOptionPane.WARNING_MESSAGE);
        }
        else
        {
            figuraModelo.setDatos(l.getText(), m.getText());
            this.setVisible(false);
            this.dispose();
        }    
    }//GEN-LAST:event_jButton1ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JTextField l;
    private javax.swing.JTextField m;
    // End of variables declaration//GEN-END:variables
}
