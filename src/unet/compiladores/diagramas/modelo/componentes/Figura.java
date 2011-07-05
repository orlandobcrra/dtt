package unet.compiladores.diagramas.modelo.componentes;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.geom.Point2D;
import java.util.Arrays;

public abstract class Figura {

    protected Polygon poligono;
    protected Point posicion;
    protected boolean seleccionada;
    // 0 = arriba . 1 = abajo . 2 = derecha . 3 = izquierda
    protected Figura[] unidos = new Figura[4];
    //
    protected boolean yaSeMovio;
    protected int TAM = 0;

    public Figura(int TAM) {
        this.TAM = TAM;
        posicion = new Point(0, 0);
    }

    public void setSeleccionada(boolean seleccionada) {
        this.seleccionada = seleccionada;
    }

    public boolean contienePunto(Point2D p) {
        return poligono.contains(p);
    }

//    public boolean intersectaFigurax(Figura f) {
//        return poligonox.getBounds2D().intersects(f.getPoligonox().getBounds2D());
//    }
//    
    public void mover(int x, int y, boolean moverUnidos) {
        poligono.translate(x, y);
        posicion.translate(x, y);
        this.yaSeMovio = true;
        if (moverUnidos) {
            for (Figura f : unidos) {
                if (f != null && !f.yaSeMovio) {
                    f.mover(x, y, moverUnidos);
                }
            }
        }
    }

    public void posicionar(Point posicionNueva, boolean moverUnidos) {
        poligono.translate(posicionNueva.x - posicion.x, posicionNueva.y - posicion.y);
        posicion.x = posicionNueva.x;
        posicion.y = posicionNueva.y;
        this.yaSeMovio = true;
//        if (moverUnidos) {
//            for (Figura f : unidos) {
//                f.mover(x, y, moverUnidos);
//            }
//        }
    }

    public void setYaSeMovio() {
        this.yaSeMovio = false;
        for (Figura f : unidos) {
            if (f != null && f.yaSeMovio) {
                f.yaSeMovio = false;
            }
        }
    }

    private void quitar(Figura quitar) {
        for (int i = 0; i < unidos.length; i++) {
            Figura figura = unidos[i];
            if (quitar.equals(figura)) {
                unidos[i] = null;
            }
        }
    }

    public final void separar() {
        for (Figura figura : unidos) {
            if (figura != null) {
                figura.quitar(this);
            }
        }
        Arrays.fill(unidos, null);
    }

    public abstract void unir(Figura c);

    public void dibujar(Graphics2D g) {
        g.setColor(Color.BLUE);
        g.fillPolygon(poligono);
        //g.fill(outline);
        if (this.seleccionada) {
            g.setColor(Color.RED);
        } else {
            g.setColor(Color.YELLOW);
        }
        g.drawPolygon(poligono);
        //g.draw(outline);
        g.setColor(Color.WHITE);
    }
}
