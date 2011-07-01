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
        //poligono.addPoint(20, 100);
        poligono.addPoint(0, 80);
    }

    @Override
    public void dibujar(Graphics g) {
        super.dibujar(g);
        // g.drawString(l, posicion.x+20,posicion.y+5);

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

    public void pegar(Compilador c) {
        Point px=new Point(c.posicion.x, c.posicion.y);
        px.x+=40;
        px.y+=80;
       this.setPosicion(px);
    }
    
    public void unir(Compilador c){
        c.x.add(this);
        System.out.println("unido");
    }
}
