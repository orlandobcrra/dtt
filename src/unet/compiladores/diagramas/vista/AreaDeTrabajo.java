/*
 * xxx.java
 *
 * Created on 03/07/2011, 06:53:31 AM
 */
package unet.compiladores.diagramas.vista;

import java.awt.Dimension;
import java.awt.Toolkit;
import unet.compiladores.diagramas.controlador.AreaDeTrabajoController;
import unet.compiladores.diagramas.controlador.LienzoController;
import unet.compiladores.diagramas.modelo.Modelo;

/**
 *
 * @author orlandobcrra
 */
public class AreaDeTrabajo extends javax.swing.JFrame {

    private static int instancias = 0;

    /** Creates new form xxx */
    public AreaDeTrabajo(Modelo modelo, AreaDeTrabajoController controlador, LienzoController lienzoController) {
        initComponents();
        instancias++;
        this.setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);

        Dimension fullscreen = Toolkit.getDefaultToolkit().getScreenSize();
        //Dimension ventana = new Dimension(fullscreen.width - fullscreen.width / 2, fullscreen.height - fullscreen.height / 2);
        //this.setSize(ventana);
        this.setLocation((fullscreen.width - this.getSize().width) / 2, (fullscreen.height - this.getSize().height) / 2);
        this.setTitle("Diagramado de Tombstone - " + modelo.getNombre());
        compilador.addActionListener(controlador);
        maquina.addActionListener(controlador);
        programa.addActionListener(controlador);
        interprete.addActionListener(controlador);
        ayudaContenido.addActionListener(controlador);
        acercaDe.addActionListener(controlador);
        nuevo.addActionListener(controlador);
        guardar.addActionListener(controlador);
        abrir.addActionListener(controlador);
        exportar.addActionListener(controlador);
        editar.addActionListener(controlador);
        eliminar.addActionListener(controlador);
        separar.addActionListener(controlador);

        jScrollPane1.setViewportView(lienzoController.getVista());

        enunciadoArea.setText(modelo.getEnunciado());
        nombreField.setText(modelo.getNombre());

        jPopupMenu1.add(editar);
        jPopupMenu1.add(separar);
        jPopupMenu1.add(eliminar);
        jPopupMenu1.add(agregar);

        this.addWindowListener(new java.awt.event.WindowAdapter() {

            public void windowClosing(java.awt.event.WindowEvent e) {
                if (--instancias == 0) {
                    System.exit(0);
                } else {
                    AreaDeTrabajo.this.setVisible(false);
                    AreaDeTrabajo.this.dispose();
                }
            }
        });
    }

    public String getEnunciado() {
        return enunciadoArea.getText();
    }

    public void setEnunciado(String enunciado) {
        enunciadoArea.setText(enunciado);
    }

    public String getNombre() {
        return nombreField.getText();
    }

    public void setNombre(String nombre) {
        nombreField.setText(nombre);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tipoComponente = new javax.swing.ButtonGroup();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        enunciadoArea = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        jLabel1 = new javax.swing.JLabel();
        nombreField = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        archivo = new javax.swing.JMenu();
        nuevo = new javax.swing.JMenuItem();
        abrir = new javax.swing.JMenuItem();
        guardar = new javax.swing.JMenuItem();
        exportar = new javax.swing.JMenuItem();
        agregar = new javax.swing.JMenu();
        compilador = new javax.swing.JMenuItem();
        maquina = new javax.swing.JMenuItem();
        programa = new javax.swing.JMenuItem();
        interprete = new javax.swing.JMenuItem();
        editar = new javax.swing.JMenuItem();
        eliminar = new javax.swing.JMenuItem();
        separar = new javax.swing.JMenuItem();
        ayuda = new javax.swing.JMenu();
        ayudaContenido = new javax.swing.JMenuItem();
        acercaDe = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Diagramado de Tombstone");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Enunciado - Notas"));
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        enunciadoArea.setColumns(20);
        enunciadoArea.setRows(5);
        jScrollPane2.setViewportView(enunciadoArea);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 924, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jLabel1.setText("Nombre:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 936, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nombreField, javax.swing.GroupLayout.DEFAULT_SIZE, 863, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nombreField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
                .addContainerGap())
        );

        archivo.setText("Archivo");

        nuevo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.ALT_MASK));
        nuevo.setText("Nuevo");
        archivo.add(nuevo);

        abrir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_MASK));
        abrir.setText("Abrir");
        archivo.add(abrir);

        guardar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.ALT_MASK));
        guardar.setText("Guardar");
        archivo.add(guardar);

        exportar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.ALT_MASK));
        exportar.setText("Exportar");
        archivo.add(exportar);

        jMenuBar1.add(archivo);

        agregar.setText("Agragar");

        compilador.setText("Compilador");
        agregar.add(compilador);

        maquina.setText("Maquina");
        agregar.add(maquina);

        programa.setText("Programa");
        agregar.add(programa);

        interprete.setText("Interprete");
        agregar.add(interprete);

        editar.setText("Editar");
        agregar.add(editar);

        eliminar.setText("Eliminar");
        agregar.add(eliminar);

        separar.setText("Separar");
        agregar.add(separar);

        jMenuBar1.add(agregar);

        ayuda.setText("Ayuda");

        ayudaContenido.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        ayudaContenido.setText("Contenido");
        ayuda.add(ayudaContenido);

        acercaDe.setText("Acerca de");
        ayuda.add(acercaDe);

        jMenuBar1.add(ayuda);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 960, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 573, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JMenuItem abrir;
    public javax.swing.JMenuItem acercaDe;
    private javax.swing.JMenu agregar;
    private javax.swing.JMenu archivo;
    private javax.swing.JMenu ayuda;
    public javax.swing.JMenuItem ayudaContenido;
    public javax.swing.JMenuItem compilador;
    public javax.swing.JMenuItem editar;
    public javax.swing.JMenuItem eliminar;
    private javax.swing.JTextArea enunciadoArea;
    public javax.swing.JMenuItem exportar;
    public javax.swing.JMenuItem guardar;
    public javax.swing.JMenuItem interprete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JMenuItem maquina;
    private javax.swing.JTextField nombreField;
    public javax.swing.JMenuItem nuevo;
    public javax.swing.JMenuItem programa;
    public javax.swing.JMenuItem separar;
    private javax.swing.ButtonGroup tipoComponente;
    // End of variables declaration//GEN-END:variables
}
