package unet.compiladores.diagramas.controlador;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import unet.compiladores.diagramas.Main;
import unet.compiladores.diagramas.modelo.Modelo;
import unet.compiladores.diagramas.modelo.componentes.Figura;
import unet.compiladores.diagramas.vista.AreaDeTrabajo;
import unet.compiladores.diagramas.vista.editores.CompiladorEditor;
import unet.compiladores.diagramas.vista.editores.InterpreteEditor;
import unet.compiladores.diagramas.vista.editores.MaquinaEditor;
import unet.compiladores.diagramas.vista.editores.ProgramaEditor;

public class AreaDeTrabajoController implements ActionListener {

    private Modelo modelo;
    private AreaDeTrabajo vista;
    private LienzoController lienzoController;

    public AreaDeTrabajoController(Modelo modelo) {
        this.modelo = modelo;
        lienzoController = new LienzoController(modelo);
        this.vista = new AreaDeTrabajo(modelo, this, lienzoController);
    }

    public AreaDeTrabajo getVista() {
        return vista;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(vista.getAgregar())) {
            agregarFigura();
        } else if (e.getSource().equals(vista.getAyuda())) {
            mostrarAyuda();
        } else if (e.getSource().equals(vista.getGuardar())) {
            guardar();
        } else if (e.getSource().equals(vista.getRestaurar())) {
            restaurar();
        }
    }

    public void agregarFigura() {
        Figura f = null;
        switch (vista.getTipoComponente().getSelection().getMnemonic()) {
            case 'C': {
                CompiladorEditor editor = new CompiladorEditor();
                f = editor.getFigura();
                break;
            }
            case 'M': {
                MaquinaEditor editor = new MaquinaEditor();
                f = editor.getFigura();
                break;
            }
            case 'I': {
                InterpreteEditor editor = new InterpreteEditor();
                f = editor.getFigura();
                break;
            }
            case 'P': {
                ProgramaEditor editor = new ProgramaEditor();
                f = editor.getFigura();
                break;
            }
        }
        if (f != null) {
            lienzoController.agregarFigura(f);
            lienzoController.getVista().repaint();
        }
    }

    public void mostrarAyuda() {
        JOptionPane.showMessageDialog(Main.getMainFrame(), "texto de la ayuda", "Ayuda!!", JOptionPane.INFORMATION_MESSAGE);
    }

    private void guardar() {
        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), Main.DB_NAME);
        try {
            String nombre=JOptionPane.showInputDialog(Main.getMainFrame(), "Nombre: ", "Guardado de DiagramaT",JOptionPane.QUESTION_MESSAGE);
            modelo.setNombre(nombre);
            db.store(modelo);
        } finally {
            db.close();
        }
    }

    private void restaurar() {
        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), Main.DB_NAME);
        try {
            List<Modelo> l = db.query(Modelo.class);
            Object o=JOptionPane.showInputDialog(Main.getMainFrame(), "mensaje", "titulo", JOptionPane.QUESTION_MESSAGE, null, l.toArray(), null);
            System.out.println(o);            
            this.modelo.restaurar((Modelo)o);
            lienzoController.getVista().repaint();
        } finally {
            db.close();
        }
    }
}