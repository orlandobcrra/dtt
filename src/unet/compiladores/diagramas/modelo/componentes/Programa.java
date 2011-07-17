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
    private boolean aLaDerechaDelPrograma;

    public Programa(int TAM) {
        this(new Point(0, 0), TAM);
    }

    public Programa(Point posicion, int TAM) {
        super(TAM);
        poligono = new Polygon();
        poligono.addPoint(0, 0);
        poligono.addPoint(-TAM / 4, -TAM / 4);
        poligono.addPoint(-TAM / 4, -TAM / 2);
        poligono.addPoint(0, (-TAM * 3) / 4);
        poligono.addPoint(TAM / 2, (-TAM * 7) / 8);
        poligono.addPoint(TAM, (-TAM * 3) / 4);
        poligono.addPoint((TAM * 5) / 4, -TAM / 2);
        poligono.addPoint((TAM * 5) / 4, -TAM / 4);
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
    public boolean pegar(Figura f) {
        if (f instanceof Compilador) {
            if (posicion.x <= f.posicion.x + (3 * TAM / 2)) {
                if (f.unidos[3] == null && this.unidos[2] == null) {
                    Point px = new Point(f.posicion.x, f.posicion.y);
                    px.x -= TAM;
                    this.posicionar(px, true);
                    this.aLaDerechaDelPrograma = true;
                    return true;
                }
            }
            if (posicion.x > f.posicion.x + (3 * TAM / 2)) {
                if (f.unidos[2] == null && this.unidos[3] == null) {
                    Point px = new Point(f.posicion.x, f.posicion.y);
                    px.x += 3 * TAM;
                    this.posicionar(px, true);
                    this.aLaDerechaDelPrograma = false;
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Figura unir(Figura f) {
        if (f instanceof Compilador
                && aLaDerechaDelPrograma
                && f.unidos[3] == null
                && this.unidos[2] == null) {
            f.unidos[3] = this;
            this.unidos[2] = f;
        }
        if (f instanceof Compilador
                && !aLaDerechaDelPrograma
                && f.unidos[2] == null
                && this.unidos[3] == null) {
            f.unidos[2] = this;
            this.unidos[3] = f;
        }
        return null;
    }

    @Override
    public void centrar(Point p) {
        int dx = p.x - posicion.x - (3 * TAM / 2);
        int dY = p.y - posicion.y - TAM;
        //mover(dx, dY, true);
    }
}