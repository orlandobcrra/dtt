package unet.compiladores.diagramas.modelo.componentes;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import javax.swing.SwingUtilities;

/**
 *
 * @author orlandobcrra
 */
public class Interprete extends Figura {

    private String l;
    private String m;

    public Interprete() {
        posicion = new Point(0, 0);
        poligono = new Polygon();
        poligono.addPoint(0, 0);
        poligono.addPoint(TAM, 0);
        poligono.addPoint(TAM, TAM * 2);
        poligono.addPoint(0, TAM * 2);
    }
    
    @Override
    public void dibujar(Graphics g) {
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

    public boolean pegar(Compilador c) {
        if (c.unidos[1] == null) {
            Point px = new Point(c.posicion.x, c.posicion.y);
            px.x += TAM;
            px.y += TAM*2;
            this.posicionar(px, false);
            return true;
        }
        return false;
    }

    @Override
    public void unir(Figura f) {
        if (f instanceof Compilador && f.unidos[1] == null) {
            unidos[0] = f;
            f.unidos[1] = this;
        }
    }

    public String getL() {
        return l;
    }

    public String getM() {
        return m;
    }
}