package unet.compiladores.diagramas.modelo.componentes;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;

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
        poligono.addPoint(40, 0);
        poligono.addPoint(40, 80);
        poligono.addPoint(0, 80);
    }

    @Override
    public void dibujar(Graphics g) {
        super.dibujar(g);
        g.drawString(l, posicion.x + 5, posicion.y + 15);
        g.drawString(m, posicion.x + 5, posicion.y + 65);

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
            px.x += 40;
            px.y += 80;
            this.posicionar(px, false);
            return true;
        }
        return false;
    }

    public void unir(Compilador c) {
        if (c.unidos[1] == null) {
            unidos[0]=c;
            c.unidos[1] = this;
        }
    }

    public String getL() {
        return l;
    }

    public String getM() {
        return m;
    }
}