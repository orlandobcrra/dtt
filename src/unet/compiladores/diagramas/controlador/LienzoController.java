package unet.compiladores.diagramas.controlador;

import java.awt.Point;
import javax.swing.SwingUtilities;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ListIterator;
import unet.compiladores.diagramas.modelo.componentes.Compilador;
import unet.compiladores.diagramas.modelo.componentes.Figura;
import unet.compiladores.diagramas.modelo.componentes.Interprete;
import unet.compiladores.diagramas.modelo.componentes.Maquina;
import unet.compiladores.diagramas.modelo.Modelo;
import unet.compiladores.diagramas.modelo.componentes.Programa;
import unet.compiladores.diagramas.vista.editores.CompiladorEditor;
import unet.compiladores.diagramas.vista.editores.InterpreteEditor;
import unet.compiladores.diagramas.vista.editores.MaquinaEditor;
import unet.compiladores.diagramas.vista.editores.ProgramaEditor;
import unet.compiladores.diagramas.vista.Lienzo;

public class LienzoController implements MouseListener, MouseMotionListener {

    private Modelo modelo;
    private Lienzo vista;
    private Figura seleccionada;

    public LienzoController(Modelo modelo) {
        this.modelo = modelo;
        this.vista = new Lienzo(modelo, this);
        seleccionada = null;
    }

    public Figura obtenerFigura(Point posicion) {
        ListIterator<Figura> it = modelo.getListaFiguras().listIterator();
        while (it.hasNext()) {
            Figura tmp = it.next();
            if (tmp.dentroFigura(posicion)) {
                tmp.setSeleccionada(true);
                return tmp;
            }
        }
        return null;
    }

    public void cambiarPosicion(Figura f, Point p) {
        f.setPosicion(p);
    }

    public void agregarFigura(Figura f) {
        modelo.agregarFigura(f);
    }

    public void eliminarFigura(Figura f) {
        modelo.eliminarFigura(f);
    }

    public Figura getFiguraEn(Point p) {
        return modelo.getFiguraEn(p);
    }

    public Lienzo getVista() {
        return vista;
    }

    @Override
    public void mousePressed(MouseEvent ev) {
        if (SwingUtilities.isLeftMouseButton(ev)) { 			// Click boton izquierdo selecciona una figura
            seleccionada = this.getFiguraEn(ev.getPoint());
            if (seleccionada != null) {
                seleccionada.setSeleccionada(true);
            }
        } else if (SwingUtilities.isRightMouseButton(ev)) {		// Click boton derecho selecciona figura agrupada 
            //this.anyadirFigura(new Cuadrado(ev.getPoint(),40));			
        } else if (SwingUtilities.isMiddleMouseButton(ev)) {            // Click boton central para eliminar figura
            Figura f = this.getFiguraEn(ev.getPoint());
            if (f != null) {
                this.eliminarFigura(f);
            }
        }
        vista.repaint();
    }

    @Override
    public void mouseDragged(MouseEvent ev) {
        if (seleccionada != null) {
            this.cambiarPosicion(seleccionada, ev.getPoint());
            vista.repaint();
        }
    }

    @Override
    public void mouseReleased(MouseEvent ev) {
        vista.repaint();
        if (seleccionada != null) {
            seleccionada.setSeleccionada(false);
            seleccionada = null;
        }
    }

    @Override
    public void mouseClicked(MouseEvent ev) {
        if (ev.getClickCount() == 2) {
            Figura f = this.getFiguraEn(ev.getPoint());
            if (f instanceof Compilador) {
                new CompiladorEditor((Compilador) f);
            } else if (f instanceof Programa) {
                new ProgramaEditor((Programa) f);
            } else if (f instanceof Interprete) {
                new InterpreteEditor((Interprete) f);
            } else if (f instanceof Maquina) {
                new MaquinaEditor((Maquina) f);
            }
            vista.repaint();
        }
    }

    @Override
    public void mouseMoved(MouseEvent event) {
    }

    @Override
    public void mouseEntered(MouseEvent event) {
    }

    @Override
    public void mouseExited(MouseEvent event) {
    }
}
