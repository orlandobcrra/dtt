package unet.compiladores.diagramas.modelo.componentes;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import unet.compiladores.diagramas.modelo.Modelo;

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
        g.drawString(nombre, posicion.x + 5, posicion.y + 25);
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
        if (f instanceof Compilador
                && f.unidos[1] == null
                && this.unidos[0] == null
                && ((Compilador)f).getImplementacion().equals(nombre)) {
            Point px = new Point(f.posicion.x, f.posicion.y);
            px.x += TAM;
            px.y += TAM * 2;
            this.posicionar(px, true);
            return true;
        }
        if (f instanceof Interprete
                && f.unidos[1] == null
                && this.unidos[0] == null
                && ((Interprete)f).getM().equals(nombre)) {
            Point px = new Point(f.posicion.x, f.posicion.y);
            px.y += TAM * 2;
            this.posicionar(px, true);
            return true;
        }
        return false;
    }

    @Override
    public Figura unir(Figura f) {
        if ((f instanceof Compilador)
                && f.unidos[1] == null
                && this.unidos[0] == null
                &&  ((Compilador)f).getImplementacion().equals(nombre)) {
            f.unidos[1] = this;
            this.unidos[0] = f;
        }
        if ((f instanceof Interprete)
                && f.unidos[1] == null
                && this.unidos[0] == null) {
            f.unidos[1] = this;
            this.unidos[0] = f;
        }
        return null;
    }
    
        @Override
    public void centrar(Point p) {
        int dx = p.x - posicion.x - (3 * TAM / 2);
        int dY = p.y - posicion.y - TAM;
        //mover(dx, dY, true);
    }
}
