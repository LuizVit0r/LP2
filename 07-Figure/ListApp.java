import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

import figures.*;

class ListApp {
    public static void main (String[] args) {
        ListFrame frame = new ListFrame();
        frame.setVisible(true);
    }
}

class ListFrame extends JFrame {
    ArrayList<Figure> fs = new ArrayList<Figure>();
    Random rand = new Random();

    ListFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );

        this.addKeyListener (
            new KeyAdapter() {
                public void keyPressed (KeyEvent evt) {
                    int x = rand.nextInt(350);
                    int y = rand.nextInt(350);
                    int w = rand.nextInt(50);
                    int h = rand.nextInt(50);
                    int x1[]=new int[3];
                    int y1[]=new int[3];
                    for(int i=0;i<3;i++){
                        x1[i] = rand.nextInt(250);
                        y1[i] = rand.nextInt(250);
                    }
                    if (evt.getKeyChar() == 'r') {
                        fs.add(new Rect(x,y, w,h));
                    }else if (evt.getKeyChar() == 'e') {
                        fs.add(new Ellipse(x,y, w,h));
                    }else if (evt.getKeyChar() == 't') {
                        fs.add(new Triangle(x1,y1,3));
                    }
                    repaint();
                }
            }
        );

        this.setTitle("Lista de Figuras");
        this.setSize(350, 350);
    }

    public void paint (Graphics g) {
        super.paint(g);
        for (Figure fig: this.fs) {
            fig.paint(g);
        }
    }
}
