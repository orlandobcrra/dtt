package unet.compiladores.diagramas.modelo.componentes;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;

/**
 *
 * @author orlandobcrra
 */
public class Maquina extends Figura {

    private String nombre;

    public Maquina() {
        posicion = new Point(0, 0);
        poligono = new Polygon();
        poligono.addPoint(0, 0);
        poligono.addPoint(TAM, 0);
        poligono.addPoint(TAM, TAM);
        poligono.addPoint(TAM/2, TAM);
        poligono.addPoint(0, TAM);
        posicionar(new Point(100, 100), false);
    }
    
    @Override
    public void dibujar(Graphics g) {
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
