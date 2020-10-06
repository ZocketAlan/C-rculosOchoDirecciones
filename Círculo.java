package CírculosOchoDirecciones;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Círculo {

    private int coordenateX;
    private int coordenateY;
    private final int radio;
    private final Color color;
    private int sentido;
    private final int ARRIBA = 1;
    private final int DERECHA_ARRIBA = 2;
    private final int DERECHA = 3;
    private final int DERECHA_ABAJO = 4;
    private final int ABAJO = 5;
    private final int IZQUIERDA_ABAJO = 6;
    private final int IZQUIERDA = 7;
    private final int IZQUIERDA_ARRIBA = 8;
    private final int velocidad;
    private int mínimo_x, mínimo_y, máximo_x, máximo_y;
    private final Random random;

    public Círculo(int ancho, int alto, int radio, int velocidad) {
        random = new Random();
        color = new Color(
                random.nextInt(225),
                random.nextInt(225),
                random.nextInt(225));
        this.coordenateX = this.random.nextInt(ancho - radio);
        this.coordenateY = this.random.nextInt(alto - radio);
        this.radio = radio;
        this.sentido = 1 + random.nextInt(8);
        this.velocidad = velocidad;
        this.mínimo_x = 0;
        this.mínimo_y = 0;
        this.máximo_x = ancho;
        this.máximo_y = alto;

    }

    public void dibujar(Graphics g) {
        g.setColor(this.color);
        g.fillOval(this.coordenateX, this.coordenateY, this.radio, this.radio);
    }

    public void animar() {
        int x_positiva = this.coordenateX + this.velocidad;
        int y_positiva = this.coordenateY + this.velocidad;
        int x_negativa = this.coordenateX - this.velocidad;
        int y_negativa = this.coordenateY - this.velocidad;

        switch (this.sentido) {
            case ARRIBA:
                if (y_negativa > this.mínimo_y) {
                    this.coordenateY = y_negativa;
                } else {
                    int sentido_temp = 1 + random.nextInt(8);
                    switch(sentido_temp){
                        case 1:
                            this.sentido = IZQUIERDA_ABAJO;
                            break;
                        case 2:
                            this.sentido = ABAJO;
                            break;
                        case 3:
                            this.sentido = DERECHA_ABAJO;
                            break;
                    }
                }
                break;
                
            case DERECHA_ARRIBA:
                if ((x_positiva < this.máximo_x) && (y_negativa > this.mínimo_y)) {
                    this.coordenateX = x_positiva;
                    this.coordenateY = y_negativa;
                } else {
                    int sentido_temp = 1 + random.nextInt(8);
                    switch(sentido_temp){
                        case 1:
                            this.sentido = IZQUIERDA_ABAJO;
                            break;
                        case 2:
                            this.sentido = ABAJO;
                            break;
                        case 3:
                            this.sentido = IZQUIERDA;
                            break;
                    }
                }
                break;
                
            case DERECHA:
                if (x_positiva < this.máximo_x) {
                    this.coordenateX = x_positiva;
                } else {
                    int sentido_temp = 1 + random.nextInt(8);
                    switch(sentido_temp){
                        case 1:
                            this.sentido = IZQUIERDA_ABAJO;
                            break;
                        case 2:
                            this.sentido = IZQUIERDA;
                            break;
                        case 3:
                            this.sentido = IZQUIERDA_ARRIBA;
                            break;
                    }
                }
                break;
                
            case DERECHA_ABAJO:
                if ((x_positiva < this.máximo_x) && (y_positiva > this.máximo_y)) {
                    this.coordenateX = x_positiva;
                    this.coordenateY = y_positiva;
                } else {
                    int sentido_temp = 1 + random.nextInt(8);
                    switch(sentido_temp){
                        case 1:
                            this.sentido = IZQUIERDA_ARRIBA;
                            break;
                        case 2:
                            this.sentido = ARRIBA;
                            break;
                        case 3:
                            this.sentido = IZQUIERDA;
                            break;
                    }
                }
                break;
                
            case ABAJO:
                if ((y_positiva < this.máximo_y)) {
                    this.coordenateY = y_positiva;
                } else {
                    int sentido_temp = 1 + random.nextInt(8);
                    switch(sentido_temp){
                        case 1:
                            this.sentido = IZQUIERDA_ARRIBA;
                            break;
                        case 2:
                            this.sentido = ARRIBA;
                            break;
                        case 3:
                            this.sentido = DERECHA_ARRIBA;
                            break;
                    }
                }
                break;
                
            case IZQUIERDA_ABAJO:
                if ((y_positiva < this.máximo_y) && (x_negativa > this.mínimo_x)) {
                    this.coordenateX = x_negativa;
                    this.coordenateY = y_positiva;
                } else {
                    int sentido_temp = 1 + random.nextInt(8);
                    switch(sentido_temp){
                        case 1:
                            this.sentido = ARRIBA;
                            break;
                        case 2:
                            this.sentido = DERECHA;
                            break;
                        case 3:
                            this.sentido = DERECHA_ARRIBA;
                            break;
                    }
                }
                break;
                
            case IZQUIERDA:
                if ((x_negativa > this.mínimo_x)) {
                    this.coordenateX = x_negativa;
                } else {
                    int sentido_temp = 1 + random.nextInt(8);
                    switch(sentido_temp){
                        case 1:
                            this.sentido = DERECHA_ARRIBA;
                            break;
                        case 2:
                            this.sentido = DERECHA;
                            break;
                        case 3:
                            this.sentido = DERECHA_ABAJO;
                            break;
                    }
                }
                break;
                
            case IZQUIERDA_ARRIBA:
                if ((x_negativa > this.mínimo_x) && (y_negativa > this.mínimo_y)) {
                    this.coordenateX = x_negativa;
                    this.coordenateY = y_negativa;
                } else {
                    int sentido_temp = 1 + random.nextInt(8);
                    switch(sentido_temp){
                        case 1:
                            this.sentido = ABAJO;
                            break;
                        case 2:
                            this.sentido = DERECHA;
                            break;
                        case 3:
                            this.sentido = DERECHA_ABAJO;
                            break;
                    }
                }
                break;
        }
    }

}
