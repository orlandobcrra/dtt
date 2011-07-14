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
        int ancho=0;
        ancho= SwingUtilities.computeStringWidth(g.getFontMetrics(), nombre);
        g.drawString(nombre, posicion.x + (TAM - ancho)/2, posicion.y + -10);
        ancho= SwingUtilities.computeStringWidth(g.getFontMetrics(), lenguaje);
        g.drawString(lenguaje, posicion.x + (TAM - ancho)/2, posicion.y + 30);
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

    public void setaLaDerechaDelPrograma(boolean aLaDerechaDelPrograma) {
        this.aLaDerechaDelPrograma = aLaDerechaDelPrograma;
    }

    
    

    @Override
    public boolean pegar(Figura f) {
        if (f instanceof Compilador) {
            UnirFiguras.pegarProgramaCompilador((Compilador)f, this);
            
//            if (posicion.x <= f.posicion.x + (3 * TAM / 2)) {
//                if ((f.unidos[3] == null && this.unidos[2] == null)
//                    && (((Compilador)f).getFuente().equals(lenguaje))){
//                    Point px = new Point(f.posicion.x, f.posicion.y);
//                    px.x -= TAM;
//                    this.posicionar(px, true);
//                    this.aLaDerechaDelPrograma = true;
//                    return true;
//                }
//            }
//            if (posicion.x > f.posicion.x + (3 * TAM / 2)) {
//                if ((f.unidos[2] == null && this.unidos[3] == null)
//                   && (((Compilador)f).getObjeto().equals(lenguaje))){
//                    Point px = new Point(f.posicion.x, f.posicion.y);
//                    px.x += 3 * TAM;
//                    this.posicionar(px, true);
//                    this.aLaDerechaDelPrograma = false;
//                    return true;
//                }
//            }
            
           
        }
            if ((f instanceof Interprete)){
                UnirFiguras.pegarProgramaInterprete((Interprete)f, this);
//                && f.unidos[0] == null
//                && this.unidos[1] == null)
//                && ((Interprete)f).getL().equals(lenguaje)) {
//            Point px = new Point(f.posicion.x, f.posicion.y);
//            px.y -= TAM;
//            this.posicionar(px, true);
//            return true;
        }
            
          if ((f instanceof Maquina)){
              UnirFiguras.pegarProgramaMaquina((Maquina)f, this);
//             && f.unidos[0] == null
//             && this.unidos[1] == null)
//             && ((Maquina)f).getNombre().equals(lenguaje)) {
//          Point px = new Point(f.posicion.x, f.posicion.y);
//          px.y -= TAM;
//          this.posicionar(px, true);
//          return true;
        }
        return false;
    }

    @Override
    public Figura unir(Figura f) {
        if ((f instanceof Compilador)){
            UnirFiguras.unirProgramaCompilador(this, (Compilador)f,aLaDerechaDelPrograma);
        }

        if ((f instanceof Interprete)){
            UnirFiguras.unirProgramaInterprete(this, (Interprete)f);
        }
        
        if ((f instanceof Maquina)){
            UnirFiguras.unirProgramaMaquina(this, (Maquina)f);
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
        Point p= new Point(posicion.x+40, posicion.y+40);            
        Programa pr = new Programa(p, TAM);
        pr.setDatos(this.nombre, this.lenguaje);
        return pr;
        }
}