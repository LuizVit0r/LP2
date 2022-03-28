import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

import figures.*;

class ProjectApp {
    public static void main (String[] args) {
        Frame frame = new Frame();
        frame.setVisible(true);
    }
}

class Frame extends JFrame {
    ArrayList<Figure> fs = new ArrayList<Figure>();
    Random rand = new Random();

    Frame () {
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
                    int x1[]=new int[3];
                    int y1[]=new int[3];
                    for(int i=0;i<3;i++){
                        x1[i] = rand.nextInt(300);
                        y1[i] = rand.nextInt(300);
                    }
                    if (evt.getKeyChar() == 'r') {
                        fs.add(new Rect(x,y, 20,20));
                    }else if (evt.getKeyChar() == 'e') {
                        fs.add(new Ellipse(x,y, 20,20));
                    }else if (evt.getKeyChar() == 't') {
                        fs.add(new Triangle(x1,y1,3));
                    }
                    repaint();
                }
            }
        );
        
        this.addMouseListener (
            new MouseAdapter() {
                public void mouseClicked (MouseEvent evt){
                    super.mouseClicked(evt);
                    for (Figure fig : fs) {
                        
                        if (!fs.contains(evt.getPoint())) {
                        
                            if (fig instanceof Rect) {
                                System.out.println("Clicked a rectangle");
                            } else if (fig instanceof Ellipse) {
                                System.out.println("Clicked a circle");
                            }
                            
                        }
                    }
                }
                public void mousePressed (MouseEvent evt){
                    System.out.println("pressionou");
                }
                public void mouseReleased (MouseEvent evt){
                    System.out.println("soltou");
                }
                public void mouseEntered (MouseEvent evt){
                    System.out.println("entrou");
                }
                public void mouseExited (MouseEvent evt){
                    System.out.println("saiu");
                }
            }
        );

        this.setTitle("Editor Grafico Vetorial");
        this.setSize(350, 350);
    }

    public void paint (Graphics g) {
        super.paint(g);
        for (Figure fig: this.fs) {
            fig.paint(g);
        }
    }
}
