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
        poligono.addPoint(TAM * 3, 0);
        poligono.addPoint(TAM * 3, TAM);
        poligono.addPoint(TAM * 2, TAM);
        poligono.addPoint(TAM * 2, TAM * 2);
        poligono.addPoint(TAM, TAM * 2);
        poligono.addPoint(TAM, TAM);
        poligono.addPoint(0, TAM);
        posicionar(new Point(100, 100), false);
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

    @Override
    public void unir(Figura f) {
    }
}
