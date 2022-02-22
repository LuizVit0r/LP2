package figures;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;

public class Triangle {
    int x[], y[], n;

    public Triangle (int x[], int y[], int n) {
        this.x = x;
        this.y = y;
        this.n = n;
    }

    private void print () {
        //System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
            //this.w, this.h, this.x, this.y);
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g.setColor(new Color(255,0,0));
        g2d.drawPolygon(this.x,this.y,this.n);
        g.setColor(new Color(0,255,0));
        g2d.fillPolygon(this.x,this.y,this.n);
    }
}
