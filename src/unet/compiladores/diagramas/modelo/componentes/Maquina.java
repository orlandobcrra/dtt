package unet.compiladores.diagramas.modelo.componentes;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import javax.swing.SwingUtilities;
import unet.compiladores.diagramas.modelo.util.UnirFiguras;

/**
 *
 * @author orlandobcrra
 */
public class Maquina extends Figura {

    private String nombre = "";

    public Maquina(int TAM) {
        this(new Point(0, 0), TAM);
    }

    public Maquina(Point posicion, int TAM) {
        super(TAM);
        poligono = new Polygon();
        poligono.addPoint(0, 0);
        poligono.addPoint(TAM, 0);
        poligono.addPoint(TAM, TAM);
        poligono.addPoint(TAM / 2, 3 * TAM / 2);
        poligono.addPoint(0, TAM);
        posicionar(posicion, false);
    }

    @Override
    public void dibujar(Graphics2D g) {
        super.dibujar(g);
        int ancho=0;
        ancho = SwingUtilities.computeStringWidth(g.getFontMetrics(), nombre);
        g.drawString(nombre, posicion.x + (TAM - ancho)/2, posicion.y + 25);
    }

    //@Override
    public void setDatos(String... datos) {
        this.nombre = datos[0];
    }

    @Override
    public String toString() {
        return "Maquina: " + nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public boolean pegar(Figura f) {
        if (f instanceof Compilador){
            UnirFiguras.pegarMaquinaCompilador((Compilador)f, this);
        }

        if (f instanceof Interprete){
            UnirFiguras.pegarMaquinaInterprete((Interprete)f, this);
        }
        
         if (f instanceof Programa){
             UnirFiguras.pegarProgramaMaquina((Programa)f, this);
        }
        return false;
    }

    @Override
    public Figura unir(Figura f) {
        if ((f instanceof Compilador)){
            UnirFiguras.unirCompiladorMaquina((Compilador)f, this);
        }
        
        if ((f instanceof Interprete)){
            UnirFiguras.unirInterpreteMaquina((Interprete)f, this);
        }
        if ((f instanceof Programa)){
            UnirFiguras.unirProgramaMaquina((Programa)f, this);
        }
        return null;
    }
    
        @Override
    public void centrar(Point p) {
        int dx = p.x - posicion.x - (3 * TAM / 2);
        int dY = p.y - posicion.y - TAM;
        //mover(dx, dY, true);
    }

        @Override
    public Figura duplicar(){
        Point p= new Point(posicion.x+40, posicion.y+40);
        Maquina m = new Maquina(p, TAM);
        m.setDatos(this.nombre);
        return m;
        }
}
