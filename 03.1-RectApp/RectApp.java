public class RectApp {
    public static void main (String[] args) {
        Rect r1 = new Rect(1,1, 8,10); 
        r1.print();
        r1.drag(7,5);
        r1.print();
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

     int area(){
         int a;
         a = w*h;
         return a;
     }

     void drag(int dx, int dy){
         x=x+dx;
         y=y+dy;
     }


     void print () {
       System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d).Area = %d\n",
           this.w, this.h, this.x, this.y, area());
       }
}
