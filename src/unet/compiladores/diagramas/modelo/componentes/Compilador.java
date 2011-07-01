package unet.compiladores.diagramas.modelo.componentes;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;

/**
 *
 * @author orlandobcrra
 */
public class Compilador extends Figura {

    private String fuente;
    private String objeto;
    private String implementacion;

    public Compilador() {
        posicion = new Point(0, 0);
        poligono = new Polygon();
        poligono.addPoint(0, 0);
        poligono.addPoint(120, 0);
        poligono.addPoint(120, 40);
        poligono.addPoint(80, 40);
        poligono.addPoint(80, 80);
        poligono.addPoint(40, 80);
        poligono.addPoint(40, 40);
        poligono.addPoint(0, 40);
        setPosicion(new Point(100, 100));
    }

    @Override
    public void dibujar(Graphics g) {
        super.dibujar(g);
        g.drawString(fuente, posicion.x + 5, posicion.y + 20);
        g.drawString(objeto, posicion.x + 80, posicion.y + 20);
        g.drawString(implementacion, posicion.x + 45, posicion.y + 70);
    }

    //@Override
    public void setDatos(String... datos) {
        this.fuente = datos[0];
        this.objeto = datos[1];
        this.implementacion = datos[2];
    }

    @Override
    public String toString() {
        return "compilador: " + fuente + " " + objeto + " " + implementacion;
    }

    public String getFuente() {
        return fuente;
    }

    public String getImplementacion() {
        return implementacion;
    }
    
}
