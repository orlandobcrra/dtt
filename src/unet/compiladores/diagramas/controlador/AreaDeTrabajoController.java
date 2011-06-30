package unet.compiladores.diagramas.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import unet.compiladores.diagramas.modelo.Modelo;
import unet.compiladores.diagramas.vista.AreaDeTrabajo;

public class AreaDeTrabajoController implements ActionListener {

    private Modelo modelo;
    private AreaDeTrabajo vista;
    private LienzoController lienzoController;

    public AreaDeTrabajoController(Modelo modelo) {
        this.modelo = modelo;
        lienzoController = new LienzoController(modelo);
        this.vista = new AreaDeTrabajo(modelo, this, lienzoController);
    }

    public AreaDeTrabajo getVista() {
        return vista;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}