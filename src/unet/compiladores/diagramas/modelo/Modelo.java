package unet.compiladores.diagramas.modelo;

import unet.compiladores.diagramas.modelo.componentes.Figura;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Modelo {

    private int TAM;
    private String nombre;
    private String enunciado;
    private List<Figura> listaFiguras;

    public Modelo() {
        this(40, "");
    }

    public Modelo(int TAM, String nombre) {
        this.TAM = TAM;
        this.nombre = nombre;
        this.enunciado = "";
        listaFiguras = new ArrayList<Figura>(0);
    }

    public void limpiar(int TAM, String nombre) {
        this.TAM = TAM;
        this.nombre = nombre;
        this.enunciado = "";
        listaFiguras = new ArrayList<Figura>(0);
    }

    public void agregarFigura(Figura f) {
        listaFiguras.add(f);
    }

    public boolean eliminarFigura(Figura f) {
        return listaFiguras.remove(f);
    }

    public Figura getFiguraEnPunto(Point p, Figura omitir) {
        for (Figura figura : getListaFiguras()) {
            if (figura.contienePunto(p) && !figura.equals(omitir)) {
                return figura;
            }
        }
        return null;
    }

    public void restaurar(Modelo m) {
        this.nombre = m.getNombre();
        this.enunciado = m.getEnunciado();
        this.TAM = m.getTAM();
        this.listaFiguras = m.getListaFiguras();
    }

    public List<Figura> getListaFiguras() {
        return listaFiguras;
    }

    public void setListaFiguras(List<Figura> listaFiguras) {
        this.listaFiguras = listaFiguras;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public int getTAM() {
        return TAM;
    }

    public void setTAM(int TAM) {
        this.TAM = TAM;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
