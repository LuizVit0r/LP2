public class RectApp {
    public static void main (String[] args) {
        Rect r1 = new Rect(1,1,10,10,10,20,20); 
        r1.print();
     }
} 

class Rect {
     int x, y;              // posiçao do retangulo
     int w, h, l;           // largura, altura e comprimento
     int xf, yf;            // o ponto de fuga do retangulo 3D
     Rect (int x, int y, int w, int h, int l, int xf, int yf) {
         this.x = x;
         this.y = y;
         this.w = w;
         this.h = h;
         this.l = l;
         this.xf = xf;
         this.yf = yf;
     }

     void print () {
       System.out.format("Retangulo 3D de tamanho (%d,%d,%d) na posicao (%d,%d) com ponto de fuga em (%d,%d).\n",
           this.w, this.h, this.l, this.x, this.y, this.xf, this.yf);
       }
}