package unet.compiladores.diagramas.modelo.componentes;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;

/**
 *
 * @author orlandobcrra
 */
public class Compilador extends Figura {

    private String fuente = "";
    private String objeto = "";
    private String implementacion = "";
    private boolean aLaDerechaDelPrograma;

    public Compilador(int TAM) {
        this(new Point(0, 0), TAM);
    }

    public Compilador(Point posicion, int TAM) {
        super(TAM);
        poligono = new Polygon();
        poligono.addPoint(0, 0);
        poligono.addPoint(TAM * 3, 0);
        poligono.addPoint(TAM * 3, TAM);
        poligono.addPoint(TAM * 2, TAM);
        poligono.addPoint(TAM * 2, TAM * 2);
        poligono.addPoint(TAM, TAM * 2);
        poligono.addPoint(TAM, TAM);
        poligono.addPoint(0, TAM);
        posicionar(posicion, false);
    }

    public void regenerar(int TAM) {
        poligono = new Polygon();
        poligono.addPoint(0, 0);
        poligono.addPoint(TAM * 3, 0);
        poligono.addPoint(TAM * 3, TAM);
        poligono.addPoint(TAM * 2, TAM);
        poligono.addPoint(TAM * 2, TAM * 2);
        poligono.addPoint(TAM, TAM * 2);
        poligono.addPoint(TAM, TAM);
        poligono.addPoint(0, TAM);
        poligono.translate(posicion.x, posicion.y);
    }

    @Override
    public void dibujar(Graphics2D g) {
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

    public String getObjeto() {
        return objeto;
    }

    @Override
    public boolean pegar(Figura p) {
        if ((p instanceof Interprete || p instanceof Maquina)
                && p.unidos[0] == null
                && this.unidos[1] == null) {
            Point px = new Point(p.posicion.x, p.posicion.y);
            px.x -= TAM;
            px.y -= TAM * 2;
            this.posicionar(px, true);
            return true;
        }
        if (p instanceof Programa) {
            if (posicion.x <= p.posicion.x + (TAM / 2)) {
                if (p.unidos[3] == null && this.unidos[2] == null) {
                    Point px = new Point(p.posicion.x, p.posicion.y);
                    px.x -= 3 * TAM;
                    this.posicionar(px, true);
                    this.aLaDerechaDelPrograma = false;
                    return true;
                }
            }
            if (posicion.x > p.posicion.x + (TAM / 2)) {
                if (p.unidos[2] == null && this.unidos[3] == null) {
                    Point px = new Point(p.posicion.x, p.posicion.y);
                    px.x += TAM;
                    this.posicionar(px, true);
                    this.aLaDerechaDelPrograma = true;
                    return true;
                }
            }
        }
        if (p instanceof Compilador) {
            if (posicion.x <= p.posicion.x + (3 * TAM / 2)) {
                if (p.unidos[3] == null && this.unidos[2] == null) {
                    Point px = new Point(p.posicion.x, p.posicion.y);
                    px.y -= TAM;
                    px.x -= 2 * TAM;
                    this.posicionar(px, true);
                    this.aLaDerechaDelPrograma = false;
                    return true;
                }
            }
            if (posicion.x > p.posicion.x + (3 * TAM / 2)) {
                if (p.unidos[2] == null && this.unidos[1] == null) {
                    Point px = new Point(p.posicion.x, p.posicion.y);
                    px.y -= TAM;
                    px.x += 2 * TAM;
                    this.posicionar(px, true);
                    this.aLaDerechaDelPrograma = true;
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Figura unir(Figura f) {
        if ((f instanceof Interprete || f instanceof Maquina)
                && f.unidos[0] == null
                && this.unidos[1] == null) {
            f.unidos[0] = this;
            this.unidos[1] = f;
        }
        if ((f instanceof Programa || f instanceof Compilador)
                && aLaDerechaDelPrograma
                && f.unidos[2] == null
                && this.unidos[3] == null) {
            f.unidos[2] = this;
            this.unidos[3] = f;
        }
        if ((f instanceof Programa || f instanceof Compilador)
                && !aLaDerechaDelPrograma
                && f.unidos[3] == null
                && this.unidos[2] == null) {
            f.unidos[3] = this;
            this.unidos[2] = f;
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
