package figures;

import java.awt.Graphics;

public abstract class Figure {
    int r,g,b;
    int x,y;
    public abstract void paint (Graphics g);
}