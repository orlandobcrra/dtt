package unet.compiladores.diagramas.vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import unet.compiladores.diagramas.controlador.LienzoController;
import unet.compiladores.diagramas.modelo.componentes.Figura;
import unet.compiladores.diagramas.modelo.Modelo;

public class Lienzo extends JPanel {

    private Modelo modelo;
    private BufferedImage bufferedImage;
    private Graphics2D g2d;
    private Dimension screen;

    public Lienzo(Modelo modelo, LienzoController controlador) {
        super();
        this.modelo = modelo;
        
        this.screen = Toolkit.getDefaultToolkit().getScreenSize();
        bufferedImage = new BufferedImage(screen.width * 2, screen.height * 2, BufferedImage.TYPE_INT_RGB);
        g2d = bufferedImage.createGraphics();

        this.setBackground(Color.CYAN);
        this.setFocusable(true);

        this.addMouseListener(controlador);
        this.addMouseMotionListener(controlador);
    }

    public BufferedImage getBufferedImage() {
        return bufferedImage.getSubimage(0, 0, this.getWidth(), this.getHeight());
    }

    public Graphics2D getG2d() {
        return g2d;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g2d);
        pintarTodo(g2d);
        g.drawImage(bufferedImage, 0, 0, this);
    }

    private void pintarTodo(Graphics2D g) {
        g.setBackground(Color.CYAN);
        //g.setColor(Color.CYAN);
        //g.fillRect(0, 0, screen.width, screen.height);
        for (Figura elemento : modelo.getListaFiguras()) {
            elemento.dibujar(g);
        }
    }
}