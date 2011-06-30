package unet.compiladores.diagramas.vista;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import unet.compiladores.diagramas.controlador.AreaDeTrabajoController;
import unet.compiladores.diagramas.controlador.LienzoController;
import unet.compiladores.diagramas.modelo.Modelo;

/**
 *
 * @author orlandobcrra
 */
public class AreaDeTrabajo extends javax.swing.JPanel {

    public AreaDeTrabajo(Modelo modelo, AreaDeTrabajoController controlador, LienzoController lienzoController) {
        initComponents();

        agregar.addActionListener(controlador);
        ayuda.addActionListener(controlador);
        restaurar.addActionListener(controlador);
        guardar.addActionListener(controlador);

        jScrollPane1.setViewportView(lienzoController.getVista());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tipoComponente = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        radioCompildor = new javax.swing.JRadioButton();
        programa = new javax.swing.JRadioButton();
        maquina = new javax.swing.JRadioButton();
        interprete = new javax.swing.JRadioButton();
        agregar = new javax.swing.JButton();
        ayuda = new javax.swing.JButton();
        restaurar = new javax.swing.JButton();
        guardar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(radioCompildor)
                    .addComponent(programa))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(interprete)
                    .addComponent(maquina))
                .addGap(18, 18, 18)
                .addComponent(agregar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                .addComponent(guardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(restaurar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ayuda)
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {interprete, maquina, programa, radioCompildor});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {agregar, ayuda, guardar, restaurar});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(guardar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(restaurar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ayuda, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(radioCompildor)
                                .addComponent(maquina))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(programa)
                                .addComponent(interprete)))))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 696, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

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
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregar;
    private javax.swing.JButton ayuda;
    private javax.swing.JButton guardar;
    private javax.swing.JRadioButton interprete;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton maquina;
    private javax.swing.JRadioButton programa;
    private javax.swing.JRadioButton radioCompildor;
    private javax.swing.JButton restaurar;
    private javax.swing.ButtonGroup tipoComponente;
    // End of variables declaration//GEN-END:variables
}
