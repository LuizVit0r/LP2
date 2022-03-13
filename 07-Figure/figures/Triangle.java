package figures;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;

public class Triangle extends Figure{
    int x[], y[], n;

    public Triangle (int x[], int y[], int n) {
        this.x = x;
        this.y = y;
        this.n = n;
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawPolygon(this.x,this.y,this.n);
    }
}
