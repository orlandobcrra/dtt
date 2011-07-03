package unet.compiladores.diagramas;

import unet.compiladores.diagramas.controlador.AreaDeTrabajoController;
import unet.compiladores.diagramas.modelo.Modelo;

/**
 *
 * @author orlandobcrra
 */
public class Main {

    public static void main(String[] args) {
        Modelo modelo = new Modelo();
        new AreaDeTrabajoController(modelo);
    }
}
