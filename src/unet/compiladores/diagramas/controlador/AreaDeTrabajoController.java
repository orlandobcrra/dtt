package unet.compiladores.diagramas.controlador;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.query.Predicate;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import unet.compiladores.diagramas.modelo.Modelo;
import unet.compiladores.diagramas.modelo.componentes.Figura;
import unet.compiladores.diagramas.vista.editores.CompiladorEditor;
import unet.compiladores.diagramas.vista.editores.InterpreteEditor;
import unet.compiladores.diagramas.vista.editores.MaquinaEditor;
import unet.compiladores.diagramas.vista.editores.ProgramaEditor;
import unet.compiladores.diagramas.vista.AreaDeTrabajo;
import unet.compiladores.diagramas.vista.AcercaDe;
import unet.compiladores.diagramas.vista.Nuevo;

public class AreaDeTrabajoController implements ActionListener {

    private Modelo modelo;
    private AreaDeTrabajo vista;
    private LienzoController lienzoController;
    private String dataBaseName = "dataBase";
    private AcercaDe acercaDe;
    private JFileChooser fileChooser;

    public AreaDeTrabajoController(Modelo modelo) {
        this.modelo = modelo;
        lienzoController = new LienzoController(modelo);
        this.vista = new AreaDeTrabajo(modelo, this, lienzoController);
        lienzoController.setX(vista, vista.jPopupMenu1);
        acercaDe = new AcercaDe(vista, true);
        fileChooser = new JFileChooser(".");
        fileChooser.setFileFilter(new FileFilter() {

            @Override
            public boolean accept(File f) {
                return f.getName().endsWith("png");
            }

            @Override
            public String getDescription() {
                return "PNG";
            }
        });
        vista.setVisible(true);

    }

    public AreaDeTrabajo getVista() {
        return vista;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(vista.compilador)) {
            agregarCompilador();
        } else if (e.getSource().equals(vista.maquina)) {
            agregarMaquina();
        } else if (e.getSource().equals(vista.interprete)) {
            agregarInterprete();
        } else if (e.getSource().equals(vista.programa)) {
            agregarPrograma();
        } else if (e.getSource().equals(vista.editar)) {
            Figura f = lienzoController.getFiguraEnPunto(lienzoController.init);
            lienzoController.editar(f);
        } else if (e.getSource().equals(vista.separar)) {
            Figura f = lienzoController.getFiguraEnPunto(lienzoController.init);
            f.separar();
            f.mover(-f.getTAM(), -f.getTAM(), false);
            lienzoController.getVista().repaint();
        } else if (e.getSource().equals(vista.eliminar)) {
            Figura f = lienzoController.getFiguraEnPunto(lienzoController.init);
            lienzoController.eliminarFigura(f);
            lienzoController.getVista().repaint();
        } else if (e.getSource().equals(vista.ayudaContenido)) {
            mostrarAyuda();
        } else if (e.getSource().equals(vista.acercaDe)) {
            acercaDe.setVisible(true);
        } else if (e.getSource().equals(vista.nuevo)) {
            new Nuevo(vista, true, modelo).setVisible(true);
            vista.setTitle("Diagramado de Tombstone - " + modelo.getNombre());
            vista.setEnunciado(modelo.getEnunciado());
            vista.setNombre(modelo.getNombre());
            lienzoController.getVista().repaint();
        } else if (e.getSource().equals(vista.guardar)) {
            guardar();
        } else if (e.getSource().equals(vista.abrir)) {
            restaurar();
        } else if (e.getSource().equals(vista.exportar)) {
            int r = fileChooser.showSaveDialog(vista);
            if (r == JFileChooser.APPROVE_OPTION) {
                try {
                    ImageIO.write(lienzoController.getVista().getBufferedImage(), "png", fileChooser.getSelectedFile());
                } catch (IOException ex) {
                    Logger.getLogger(AreaDeTrabajoController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void agregarCompilador() {
        agregarFigura(new CompiladorEditor(vista, lienzoController.init, modelo.getTAM()).getFigura());
    }

    public void agregarMaquina() {
        agregarFigura(new MaquinaEditor(vista, lienzoController.init, modelo.getTAM()).getFigura());
    }

    public void agregarInterprete() {
        agregarFigura(new InterpreteEditor(vista, lienzoController.init, modelo.getTAM()).getFigura());
    }

    public void agregarPrograma() {
        agregarFigura(new ProgramaEditor(vista, lienzoController.init, modelo.getTAM()).getFigura());
    }

    public void agregarFigura(Figura f) {
        if (f != null) {
            lienzoController.agregarFigura(f);
            lienzoController.getVista().repaint();
        }
    }

    public void mostrarAyuda() {
        try {
            java.awt.Desktop.getDesktop().open(new File("./ayuda/help.html"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void guardar() {
        modelo.setNombre(vista.getNombre());
        modelo.setEnunciado(vista.getEnunciado());
        String nombre = modelo.getNombre();
        final String n = nombre;
        if (!nombre.isEmpty()) {
            ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), dataBaseName);
            try {

                List<Modelo> modelos = db.query(new Predicate<Modelo>() {

                    @Override
                    public boolean match(Modelo modelo) {
                        return modelo.getNombre().equalsIgnoreCase(n);
                    }
                });
                if (modelos.isEmpty()) {
                    db.store(modelo);
                } else if (modelos.size() == 1) {
                    int r = JOptionPane.showConfirmDialog(vista, "¿Desea reemplazarlo?", "Modelo ya existente", JOptionPane.YES_NO_OPTION);
                    if (r == JOptionPane.YES_OPTION) {
                        db.delete(modelos.get(0));
                        db.store(modelo);
                    }
                } else if (modelos.size() > 1) {
                    JOptionPane.showMessageDialog(vista, "Existen varios diagramas con este nombre.", "Error!", JOptionPane.ERROR_MESSAGE);
                }
            } finally {
                db.close();
            }
        }
    }
    

    private void restaurar() {
        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), dataBaseName);
        try {
            List<Modelo> l = db.query(Modelo.class);
            Object o = JOptionPane.showInputDialog(vista, "mensaje", "titulo", JOptionPane.QUESTION_MESSAGE, null, l.toArray(), null);
            if (o != null) {
                this.modelo.restaurar((Modelo) o);
                vista.setEnunciado(modelo.getEnunciado());
                vista.setNombre(modelo.getNombre());
                lienzoController.getVista().repaint();
                vista.setTitle("Diagramado de Tombstone - " + modelo.getNombre());
            }
        } finally {
            db.close();
        }
    }
}