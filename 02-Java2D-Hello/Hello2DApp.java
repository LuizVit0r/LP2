import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Hello2DApp {
    public static void main (String[] args) {
        Hello2DFrame frame = new Hello2DFrame();
    }
}

class Hello2DFrame extends JFrame {
    public Hello2DFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Bandeira da França");
        this.setSize(350, 350);
        this.setVisible(true);
    }

    public void paint (Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        int w = getWidth();
        int h = getHeight();
        g2d.setPaint(Color.black);
        g2d.fillRect(0,0,w,h);        //colocando o background de preto
        g2d.setPaint(Color.yellow);
        //g2d.drawLine(0,0, w,h);
        //g2d.drawLine(0,h, w,0);
        g2d.drawRect(35,35,301,280);  //moldura da bandeira
        g2d.setPaint(Color.red);
        g2d.fillRect(36,36,300,279);  //colocando a primeira cor na bandeira
        g2d.setPaint(Color.blue);
        g2d.fillRect(36,36,100,279);  //colocando a cor azul
        g2d.setPaint(Color.white);
        g2d.fillRect(136,36,100,279);  //colocando a cor branca
    }
}
