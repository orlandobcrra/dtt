package unet.compiladores.diagramas.modelo.componentes;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import javax.swing.SwingUtilities;
import unet.compiladores.diagramas.modelo.util.UnirFiguras;

/**
 *
 * @author orlandobcrra
 */
public class Compilador extends Figura {

    private String fuente = "";
    private String objeto = "";
    private String implementacion = "";
    private boolean yoEncimaYaMiDerecha;

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
    public void dibujar(Graphics2D g){
        super.dibujar(g);
        int ancho=0;
        ancho = SwingUtilities.computeStringWidth(g.getFontMetrics(), fuente);
        g.drawString(fuente, posicion.x + (TAM - ancho)/2, posicion.y + 20);
        g.drawString(objeto, posicion.x + (TAM *2), posicion.y + 20);
        ancho = SwingUtilities.computeStringWidth(g.getFontMetrics(), implementacion);
        g.drawString(implementacion,posicion.x + ((TAM/2 + TAM) - ancho/2), posicion.y + 70);
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

    public boolean isYoEncimaYaMiDerecha() {
        return yoEncimaYaMiDerecha;
    }

    public void setYoEncimaYaMiDerecha(boolean yoEncimaYaMiDerecha) {
        this.yoEncimaYaMiDerecha = yoEncimaYaMiDerecha;
    }
    
    

    @Override
    public boolean pegar(Figura p) {
        if ((p instanceof Maquina)){
            UnirFiguras.pegarMaquinaCompilador((Maquina)p, this);
        }
        
        if ((p instanceof Interprete)){
            UnirFiguras.pegarCompiladorInterprete((Interprete)p, this);
        }
        
        if (p instanceof Programa) {

            UnirFiguras.pegarProgramaCompilador((Programa)p, this);
        }
        if (p instanceof Compilador) {
            
            UnirFiguras.pegarCompiladorCompilador((Compilador)p, this);
        }
        return false;
    }

    @Override
    public Figura unir(Figura f) {
        if ((f instanceof Interprete)){
            UnirFiguras.unirInterpreteCompilador((Interprete)f, this);
        }
        
        if ((f instanceof Maquina)){
            UnirFiguras.unirCompiladorMaquina(this,(Maquina)f);
        }
        
        if ((f instanceof Compilador)){
            UnirFiguras.unirCompiladorCompilador((Compilador)f, this);
        }
        if ((f instanceof Programa)){
            UnirFiguras.unirProgramaCompilador((Programa)f, this,yoEncimaYaMiDerecha);
        }

        return null;
    }

    

    @Override
    public void centrar(Point p) {
        int dx = p.x - posicion.x - (3 * TAM / 2);
        int dY = p.y - posicion.y - TAM;
        //mover(dx, dY, true);
    }
    
    @Override
    public Figura duplicar(){
        Point p= new Point(posicion.x+80, posicion.y+80);
        Compilador c = new Compilador(p, TAM);
        c.setDatos(this.fuente, this.objeto, this.implementacion);
        return c;
        }
}
