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
public class Interprete extends Figura {

    private String l = "";
    private String m = "";

    public Interprete(int TAM) {
        this(new Point(0, 0), TAM);
    }

    public Interprete(Point posicion, int TAM) {
        super(TAM);
        poligono = new Polygon();
        poligono.addPoint(0, 0);
        poligono.addPoint(TAM, 0);
        poligono.addPoint(TAM, TAM * 2);
        poligono.addPoint(0, TAM * 2);
        posicionar(posicion, false);
    }

    @Override
    public void dibujar(Graphics2D g) {
        super.dibujar(g);
        int ancho = 0;
        ancho = SwingUtilities.computeStringWidth(g.getFontMetrics(), l);
        g.drawString(l, posicion.x + (TAM - ancho) / 2, posicion.y + 25);
        ancho = SwingUtilities.computeStringWidth(g.getFontMetrics(), m);
        g.drawString(m, posicion.x + (TAM - ancho) / 2, posicion.y + 65);
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

    @Override
    public boolean pegar(Figura f) {
        if ((f instanceof Compilador)){
            UnirFiguras.pegarCompiladorInterprete((Compilador)f, this);
//                && f.unidos[1] == null
//                && this.unidos[0] == null)
//                && ((Compilador)f).getImplementacion().equals(l)) {
//            Point px = new Point(f.posicion.x, f.posicion.y);
//            px.x += TAM;
//            px.y += TAM * 2;
//            this.posicionar(px, true);
            //return true;
        }
        if ((f instanceof Programa)){
            UnirFiguras.pegarProgramaInterprete((Programa)f, this);
//                && f.unidos[1] == null
//                && this.unidos[0] == null
//                && f.unidos[2] == null
//                && f.unidos[3] == null)
//                && ((Programa)f).getLenguaje().equals(l)) {
//            Point px = new Point(f.posicion.x, f.posicion.y);
//            px.x += 0;
//            px.y += TAM;
//            this.posicionar(px, true);
//            return true;
        }
        if ((f instanceof Maquina)){
             UnirFiguras.pegarMaquinaInterprete((Maquina)f, this);
//                && f.unidos[0] == null
//                && this.unidos[1] == null)
//                &&((Maquina)f).getNombre().equals(m)) {
//            Point px = new Point(f.posicion.x, f.posicion.y);
//            px.y -= TAM * 2;
//            this.posicionar(px, true);
//            return true;
        }
        return false;
    }

    @Override
    public Figura unir(Figura f) {
        if ((f instanceof Compilador)){
            UnirFiguras.unirInterpreteCompilador(this, (Compilador)f);
        }
         if ((f instanceof Programa)){
             UnirFiguras.unirProgramaInterprete((Programa)f, this);
        }
        if ((f instanceof Maquina)){
            UnirFiguras.unirInterpreteMaquina(this, (Maquina)f);
        }
        return null;
    }

    public String getL() {
        return l;
    }

    public String getM() {
        return m;
    }

    @Override
    public void centrar(Point p) {
        int dx = p.x - posicion.x - (3 * TAM / 2);
        int dY = p.y - posicion.y - TAM;
        //mover(dx, dY, true);
    }
    
    @Override
    public Figura duplicar(){
        Point p= new Point(posicion.x+40, posicion.y+40);
        Interprete i = new Interprete(p, TAM);
        i.setDatos(this.l, this.m);
        return i;
    }
}