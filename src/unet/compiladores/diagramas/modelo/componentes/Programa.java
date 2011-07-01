package unet.compiladores.diagramas.modelo.componentes;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;

/**
 *
 * @author orlandobcrra
 */
public class Programa extends Figura {

    private String nombre;
    private String lenguaje;

    public Programa() {
        posicion = new Point(0, 0);
        poligono = new Polygon();
        poligono.addPoint(0, 0);
        poligono.addPoint(-10, -10);
        poligono.addPoint(-10, -20);
        poligono.addPoint(0, -30);
        poligono.addPoint(20, -35);
        poligono.addPoint(40, -30);
        poligono.addPoint(50, -20);
        poligono.addPoint(50, -10);
        poligono.addPoint(40, 0);
        poligono.addPoint(40, 40);
        poligono.addPoint(0, 40);
        setPosicion(new Point(100, 100));
    }

    @Override
    public void dibujar(Graphics g) {
        super.dibujar(g);
        g.drawString(nombre, posicion.x + 10, posicion.y + -10);
        g.drawString(lenguaje, posicion.x + 10, posicion.y + 30);
    }

    //@Override
    public void setDatos(String... datos) {
        this.nombre = datos[0];
        this.lenguaje = datos[1];
    }

    @Override
    public String toString() {
        return "Programa " + nombre + " " + lenguaje;
    }

    public String getLenguaje() {
        return lenguaje;
    }

    public String getNombre() {
        return nombre;
    }
    
}