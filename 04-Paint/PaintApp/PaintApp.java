import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class PaintApp {
    public static void main (String[] args) {
        PaintFrame frame = new PaintFrame();
        frame.setVisible(true);
    }
}

class PaintFrame extends JFrame {
    Rect r1,r2,r3,r4,r5,r6;

    PaintFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Painting Figures");
        this.setSize(350, 350);
        this.r1 = new Rect(50,50, 100,30);
        this.r2 = new Rect(50,120, 100,30);
        this.r3 = new Rect(50,190, 100,30);
        this.r4 = new Rect(51,51, 98,28);
        this.r5 = new Rect(51,121, 98,28);
        this.r6 = new Rect(51,191, 98,28);
    }

    public void paint (Graphics g) {
        super.paint(g);
        g.setColor(new Color(0,0,0));
        this.r1.paint(g);
        g.setColor(new Color(0,255,0));
        this.r2.paint(g);
        g.setColor(new Color(255,0,0));
        this.r3.paint(g);
        g.setColor(new Color(255,255,0));
        this.r4.paint(g);
        g.setColor(new Color(255,125,0));
        this.r5.paint(g);
        g.setColor(new Color(0,0,255));
        this.r6.paint(g);
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

    void paint2 (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.fillRect(this.x,this.y, this.w,this.h);
    }

    void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.fillRect(this.x,this.y, this.w,this.h);
    }
}