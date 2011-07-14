package unet.compiladores.diagramas.controlador;

import java.awt.Point;
import java.awt.Window;
import javax.swing.SwingUtilities;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JPopupMenu;
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
    private Figura unirCon;
    private Point desplazamiento;
    private boolean moverUnidos;
    private boolean figuraPegada;
    private Window owner;
    private JPopupMenu popupMenu;
    public Point init = new Point(0, 0);

    public LienzoController(Modelo modelo) {
        this.modelo = modelo;
        this.vista = new Lienzo(modelo, this);
    }

    public void setX(Window owner, JPopupMenu popupMenu) {
        this.owner = owner;
        this.popupMenu = popupMenu;
    }

    public void moverFigura(Figura f, int x, int y, boolean moverUnidos) {
        f.mover(x, y, moverUnidos);
    }

    public void posicionarFigura(Figura f, Point p, boolean moverUnidos) {
        f.posicionar(p, moverUnidos);
    }

    public void agregarFigura(Figura f) {
        modelo.agregarFigura(f);
    }

    public boolean eliminarFigura(Figura f) {
        f.separar();
        return modelo.eliminarFigura(f);
    }

    public Figura getFiguraEnPunto(Point p) {
        return modelo.getFiguraEnPunto(p, null);
    }

    public Figura getFiguraEnPunto(Point p, Figura omitir) {
        return modelo.getFiguraEnPunto(p, omitir);
    }

    public Lienzo getVista() {
        return vista;
    }
    

    @Override
    public void mousePressed(MouseEvent ev) {
        seleccionada = this.getFiguraEnPunto(ev.getPoint());
        if (seleccionada != null) {
            seleccionada.setSeleccionada(true);
            seleccionada.centrar(ev.getPoint());
            desplazamiento = ev.getPoint();
            if (SwingUtilities.isLeftMouseButton(ev)) {			// Click boton izquierdo selecciona una figura y mover unidos
                moverUnidos = true;
            } else if (SwingUtilities.isRightMouseButton(ev)) {		// Click boton derecho 
                
            } else if (SwingUtilities.isMiddleMouseButton(ev)) {        // Click boton central para selecciona figura y separar
                moverUnidos = false;
                seleccionada.separar();
                //this.eliminarFigura(seleccionada);
                //seleccionada = null;
                //desplazamiento = null;
            }
            vista.repaint();
        }
    }

    @Override
    public void mouseDragged(MouseEvent ev) {
        if (seleccionada != null) {
            if (moverUnidos) {
                unirCon = this.getFiguraEnPunto(ev.getPoint(), seleccionada);
                if (unirCon != null) {
                    if (pegar(seleccionada, unirCon)) {
                        figuraPegada = true;
                        seleccionada.setYaSeMovio();
                        vista.repaint();
                        return;
                    }
                }
            }
            if (desplazamiento != null) {
                if (!figuraPegada) {
                    this.moverFigura(seleccionada, ev.getPoint().x - desplazamiento.x, ev.getPoint().y - desplazamiento.y, moverUnidos);
                } else {
                    this.posicionarFigura(seleccionada, ev.getPoint(), moverUnidos);
                    //seleccionada.centrar(ev.getPoint());
                    figuraPegada = false;
                }
                seleccionada.setYaSeMovio();
                desplazamiento = ev.getPoint();
                vista.repaint();
            }
        }
    }

    private boolean pegar(Figura seleccionada, Figura f) {
        return seleccionada.pegar(f);
    }

    private void unir(Figura seleccionada, Figura f) {
        if (seleccionada != null && f != null) {
            seleccionada.unir(f);
        }
    }

    @Override
    public void mouseReleased(MouseEvent ev) {
        vista.repaint();
        if (seleccionada != null) {
            unir(seleccionada, unirCon);
            seleccionada.setSeleccionada(false);
            seleccionada.setYaSeMovio();
            seleccionada = null;
            unirCon = null;
        }
        figuraPegada = false;
    }

    @Override
    public void mouseClicked(MouseEvent ev) {
        if (SwingUtilities.isLeftMouseButton(ev) && ev.getClickCount() == 2) {
            Figura f = this.getFiguraEnPunto(ev.getPoint());
            editar(f);
        }
        if (popupMenu != null
                && SwingUtilities.isRightMouseButton(ev)
                && ev.getClickCount() == 1) {
            init.x = ev.getPoint().x;
            init.y = ev.getPoint().y;
            //Figura f = this.getFiguraEnPunto(ev.getPoint());            
            popupMenu.show(vista, init.x, init.y);
        }
    }

    public void editar(Figura f) {
        if (f instanceof Compilador) {
            new CompiladorEditor((Compilador) f, owner);
        } else if (f instanceof Programa) {
            new ProgramaEditor((Programa) f, owner);
        } else if (f instanceof Interprete) {
            new InterpreteEditor((Interprete) f, owner);
        } else if (f instanceof Maquina) {
            new MaquinaEditor((Maquina) f, owner);
        }
        vista.repaint();
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
