package unet.compiladores.diagramas.modelo.componentes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;

public abstract class Figura {

    protected Polygon poligono;
    protected Point posicion;
    protected boolean seleccionada;

    public boolean dentroFigura(Point p) {
        return poligono.contains(p);
    }

    public void dibujar(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillPolygon(poligono);
        if (this.seleccionada) {
            g.setColor(Color.RED);
        }else{
            g.setColor(Color.YELLOW);
        }
        g.drawPolygon(poligono);
        g.setColor(Color.WHITE);
    }

    public void setSeleccionada(boolean seleccionada) {
        this.seleccionada = seleccionada;
    }

    public void setPosicion(Point posicionNueva) {
        poligono.translate(posicionNueva.x - posicion.x, posicionNueva.y - posicion.y);
        posicion = posicionNueva;
    }
}
