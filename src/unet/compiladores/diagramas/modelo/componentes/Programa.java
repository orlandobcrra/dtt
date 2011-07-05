package unet.compiladores.diagramas.modelo.componentes;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;

/**
 *
 * @author orlandobcrra
 */
public class Programa extends Figura {

    private String nombre = "";
    private String lenguaje = "";

    public Programa(int TAM) {
        this(new Point(0, 0), TAM);
    }

    public Programa(Point posicion, int TAM) {
        super(TAM);
        poligono = new Polygon();
        poligono.addPoint(0, 0);
        poligono.addPoint(-TAM / 4, -TAM / 4);
        poligono.addPoint(-TAM / 4, -TAM / 2);
        poligono.addPoint(0, (int) (-TAM * 0.75));
        poligono.addPoint(TAM / 2, (int) (-TAM * 0.875));
        poligono.addPoint(TAM, -(int) (-TAM * 0.75));
        poligono.addPoint((int) (TAM * 1.25), -TAM / 2);
        poligono.addPoint((int) (TAM * 1.25), -TAM / 4);
        poligono.addPoint(TAM, 0);
        poligono.addPoint(TAM, TAM);
        poligono.addPoint(0, TAM);
        posicionar(posicion, false);
    }

    @Override
    public void dibujar(Graphics2D g) {
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

    @Override
    public void unir(Figura f) {
    }
}