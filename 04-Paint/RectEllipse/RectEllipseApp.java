import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;

class RectEllipseApp {
    public static void main (String[] args) {
        RectEllipseFrame frame = new RectEllipseFrame();
        frame.setVisible(true);
    }
}

class RectEllipseFrame extends JFrame {
    Rect r1;
    Ellipse e1,e2,e3,e4,e5,e6;

    RectEllipseFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Rect + Ellipse");
        this.setSize(350, 350);
        //this.r1 = new Rect(50,50, 100,30);
        this.e1 = new Ellipse(50,50, 100,30);
        this.e2 = new Ellipse(50,120, 100,30);
        this.e3 = new Ellipse(50,190, 100,30);
        this.e4 = new Ellipse(51,51, 98,28);
        this.e5 = new Ellipse(51,121, 98,28);
        this.e6 = new Ellipse(51,191, 98,28);
    }

    public void paint (Graphics g) {
        super.paint(g);
        //this.r1.paint(g);
        g.setColor(new Color(0,0,0));
        this.e1.paint(g);
        g.setColor(new Color(0,255,0));
        this.e2.paint(g);
        g.setColor(new Color(255,0,0));
        this.e3.paint(g);
        g.setColor(new Color(255,255,0));
        this.e4.paint(g);
        g.setColor(new Color(255,125,0));
        this.e5.paint(g);
        g.setColor(new Color(0,0,255));
        this.e6.paint(g);
    }
}

class Rect {
    int x, y;
    int w, h;

    Rect (int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    void print () {
        System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

    void paint (Graphics g) {
        g.drawRect(this.x,this.y, this.w,this.h);
    }
}

class Ellipse {
    int x, y;
    int w, h;

    Ellipse (int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.fill(new Ellipse2D.Double(this.x,this.y, this.w,this.h));
    }
}