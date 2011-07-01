package unet.compiladores.diagramas.modelo;

import unet.compiladores.diagramas.modelo.componentes.Figura;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Modelo {

    private String nombre;
    private List<Figura> listaFiguras;

    public Modelo() {
        listaFiguras = new ArrayList<Figura>(0);
    }

    public void agregarFigura(Figura f) {
        listaFiguras.add(f);
    }

    public void eliminarFigura(Figura f) {
        listaFiguras.remove(f);
    }

    public Figura getFiguraEn(Point p) {
        for (Figura elemento : getListaFiguras()) {
            if (elemento.dentroFigura(p)) {
                //elemento.setPosicion(p); //TODO mejorar esto
                return elemento;
  }
        }
        return null;
    }

    public void restaurar(Modelo m) {
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

    @Override
    public String toString() {
        return nombre;
    }
}
