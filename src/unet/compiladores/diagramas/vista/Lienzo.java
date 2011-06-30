package unet.compiladores.diagramas.vista;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import unet.compiladores.diagramas.controlador.LienzoController;
import unet.compiladores.diagramas.modelo.componentes.Figura;
import unet.compiladores.diagramas.modelo.Modelo;

public class Lienzo extends JPanel {

    private Modelo modelo;
    public LienzoController controlador;

    public Lienzo(Modelo modelo, LienzoController controlador) {
        super();
        this.modelo = modelo;
        this.controlador = controlador;        
        
        this.setBackground(Color.CYAN);
        this.setFocusable(true);

        this.addMouseListener(controlador);
        this.addMouseMotionListener(controlador);
        
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        //g2.rotate(Math.PI/5);
        pintarTodo(g2);
    }

    private void pintarTodo(Graphics2D g) {
        for (Figura elemento : modelo.getListaFiguras()) {
            elemento.dibujar(g);
        }
    }
}