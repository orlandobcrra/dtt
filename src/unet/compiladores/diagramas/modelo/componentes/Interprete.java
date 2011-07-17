package unet.compiladores.diagramas.modelo.componentes;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import javax.swing.SwingUtilities;

/**
 *
 * @author orlandobcrra
 */
public class Interprete extends Figura {

    private String l = "";
    private String m = "";

    public Interprete(int TAM) {
        this(new Point(0, 0), TAM);
    }

    public Interprete(Point posicion, int TAM) {
        super(TAM);
        poligono = new Polygon();
        poligono.addPoint(0, 0);
        poligono.addPoint(TAM, 0);
        poligono.addPoint(TAM, TAM * 2);
        poligono.addPoint(0, TAM * 2);
        posicionar(posicion, false);
    }

    @Override
    public void dibujar(Graphics2D g) {
        super.dibujar(g);
        int ancho = 0;
        ancho = SwingUtilities.computeStringWidth(g.getFontMetrics(), l);
        g.drawString(l, posicion.x + (TAM - ancho) / 2, posicion.y + 25);
        ancho = SwingUtilities.computeStringWidth(g.getFontMetrics(), m);
        g.drawString(m, posicion.x + (TAM - ancho) / 2, posicion.y + 65);
    }

    //@Override
    public void setDatos(String... datos) {
        this.l = datos[0];
        this.m = datos[1];
    }

    @Override
    public String toString() {
        return "Interprete " + l + " " + m;
    }

    @Override
    public boolean pegar(Figura f) {
        if (f instanceof Compilador
                && f.unidos[1] == null
                && this.unidos[0] == null) {
            Point px = new Point(f.posicion.x, f.posicion.y);
            px.x += TAM;
            px.y += TAM * 2;
            this.posicionar(px, true);
            return true;
        }
        if (f instanceof Maquina
                && f.unidos[0] == null
                && this.unidos[1] == null) {
            Point px = new Point(f.posicion.x, f.posicion.y);
            px.y -= TAM * 2;
            this.posicionar(px, true);
            return true;
        }
        return false;
    }

    @Override
    public Figura unir(Figura f) {
        if (f instanceof Compilador
                && f.unidos[1] == null
                && this.unidos[0] == null) {
            f.unidos[1] = this;
            this.unidos[0] = f;
        }
        if (f instanceof Maquina
                && f.unidos[0] == null
                && this.unidos[1] == null) {
            f.unidos[0] = this;
            this.unidos[1] = f;
        }
        return null;
    }

    public String getL() {
        return l;
    }

    public String getM() {
        return m;
    }

    @Override
    public void centrar(Point p) {
        int dx = p.x - posicion.x - (3 * TAM / 2);
        int dY = p.y - posicion.y - TAM;
        //mover(dx, dY, true);
    }
}