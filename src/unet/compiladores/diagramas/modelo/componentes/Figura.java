package unet.compiladores.diagramas.modelo.componentes;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.geom.Point2D;
import java.util.Arrays;

public abstract class Figura {

    protected Color color;
    protected Color colorInvertido;
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
        color = Color.BLUE;
        colorInvertido = new Color(~color.getRGB());
    }

    public void setSeleccionada(boolean seleccionada) {
        this.seleccionada = seleccionada;
    }

    public boolean contienePunto(Point2D p) {
        return poligono.contains(p);
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
        int dx = posicionNueva.x - posicion.x;
        int dy = posicionNueva.y - posicion.y;
        mover(dx, dy, moverUnidos);
    }

    public void setYaSeMovio() {
        this.yaSeMovio = false;
        for (Figura f : unidos) {
            if (f != null && f.yaSeMovio) {
                f.setYaSeMovio();
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
    
    public abstract void centrar(Point p);

    public abstract Figura unir(Figura c);

    public abstract boolean pegar(Figura c);
    
    public abstract Figura duplicar() ;

    public void setColor(Color color) {
        this.color = color;
        setColorInvertido(new Color(~color.getRGB()));
    }

    public Color getColor() {
        return color;
    }

    public Color getColorInvertido() {
        return colorInvertido;
    }

    public void setColorInvertido(Color colorInvertido) {
        this.colorInvertido = colorInvertido;
    }

    public int getTAM() {
        return TAM;
    }

    public Figura[] getUnidos() {
        return unidos;
    }
    
    public Point getPosicion() {
        return posicion;
    }
    
    
    

    public void dibujar(Graphics2D g) {
        g.setColor(color);
        g.fillPolygon(poligono);
        if (this.seleccionada) {
            g.setColor(Color.RED);
        } else {
            g.setColor(colorInvertido);
        }
        g.drawPolygon(poligono);
        g.setColor(colorInvertido);
    }

    
}
