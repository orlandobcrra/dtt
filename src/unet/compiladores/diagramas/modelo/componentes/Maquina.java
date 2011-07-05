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
        poligono.addPoint(TAM / 2, TAM);
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
    public void unir(Figura f) {
    }
}
