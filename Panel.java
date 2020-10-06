package CírculosOchoDirecciones;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Panel extends JPanel {

    private final JFrame ventana;
    private final Container contenedor;
    private final Círculo círculos[];

    public Panel() {
        // inicializar la ventana
        ventana = new JFrame("Dibujando icono");
        // definir tamaño a ventana
        ventana.setSize(800, 600);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);

        contenedor = ventana.getContentPane();
        contenedor.setSize(800, 600);
        // agregar la ventana en el contenedor
        contenedor.add(this, BorderLayout.CENTER);
        int tamaño = 5;
        this.círculos = new Círculo[tamaño];

        for (int i = 0; i < tamaño; i++) {
            this.círculos[i] = new Círculo(800, 600, 25, 10);
        }
    }

    @Override
    protected void paintComponent(Graphics grap) {
        super.paintComponent(grap);
        for (Círculo círculo : círculos) {
            círculo.dibujar(grap);
        }
    }
    
    public void animar(){
        while (this.ventana.isVisible()){
            for (Círculo círculo : círculos) {
                círculo.animar();
            }
            try {
                Thread.sleep(50);
            } catch (Exception ex) {
                Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
            }
            repaint();
        }
    }
}
