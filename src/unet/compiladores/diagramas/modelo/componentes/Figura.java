package unet.compiladores.diagramas.modelo.componentes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.util.Arrays;

public abstract class Figura {

    protected Polygon poligono;
    protected Point posicion;
    protected boolean seleccionada;
    // 0 = arriba . 1 = abajo . 2 = derecha . 3 = izquierda
    protected Figura[] unidos = new Figura[4];
    //
    protected boolean yaSeMovio;
    public static int TAM = 40;

    public Polygon getPoligono() {
        return poligono;
    }

    public void setSeleccionada(boolean seleccionada) {
        this.seleccionada = seleccionada;
    }

    public boolean contienePunto(Point p) {
        return poligono.contains(p);
    }

    public boolean intersectaFigura(Figura f) {
        return poligono.getBounds2D().intersects(f.getPoligono().getBounds2D());
    }

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
        posicion = posicionNueva;
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

    public void dibujar(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillPolygon(poligono);
        if (this.seleccionada) {
            g.setColor(Color.RED);
        } else {
            g.setColor(Color.YELLOW);
        }
        g.drawPolygon(poligono);
        g.setColor(Color.WHITE);
    }
}
