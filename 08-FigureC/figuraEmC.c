#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int r,g,b;
} Color;

struct Figure;
typedef void (* Figure_Print) (struct Figure*);

typedef struct Figure {
    int x, y;
    Color fg, bg;
    void (* print) (struct Figure*);
} Figure;

///////////////////////////////////////////////////////////////////////////////

typedef struct {
    Figure super;
    int w, h;
} Rect;

void rect_print (Rect* this) {
    Figure* sup = (Figure*) this;
    printf("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
           this->w, this->h, sup->x, sup->y);
}

Rect* rect_new (int x, int y, int w, int h) {
    Rect*   this  = malloc(sizeof(Rect));
    Figure* sup = (Figure*) this;
    sup->print = (Figure_Print) rect_print;
    sup->x = x;
    sup->y = y;
    this->w = w;
    this->h = h;
}

///////////////////////////////////////////////////////////////////////////////

typedef struct {
    Figure super;
    int w, h;
} Ellipse;

void Ellipse_print (Ellipse* this) {
    Figure* sup = (Figure*) this;
    printf("Elipse de tamanho (%d,%d) na posicao (%d,%d).\n",
           this->w, this->h, sup->x, sup->y);
}

Ellipse* ellipse_new (int x, int y, int w, int h) {
    Ellipse* this = malloc(sizeof(Ellipse));
    Figure* sup = (Figure*) this;
    sup->print = (Figure_Print) Ellipse_print;
    sup->x = x;
    sup->y = y;
    this->w = w;
    this->h = h;
}

///////////////////////////////////////////////////////////////////////////////

typedef struct {
    Figure super;
    int x1[3], y1[3];
    int n;
} Triangle;

void Triangle_print (Triangle* this) {
    Figure* sup = (Figure*) this;
    printf("Triangulo com vertices nas posicoes (%d,%d),(%d,%d) e (%d,%d).\n",
           this->x1[0], this->y1[0], this->x1[1], this->y1[1], this->x1[2],this->y1[2]);
}

Triangle* triangle_new (int x1[], int y1[], int n) {
    Triangle* this = malloc(sizeof(Triangle));
    Figure* sup = (Figure*) this;
    sup->print = (Figure_Print) Triangle_print;
    for(int i=0;i<3;i++){
        this->x1[i] = x1[i];
        this->y1[i] = y1[i];
    }
}

///////////////////////////////////////////////////////////////////////////////

void main (void) {
    int a[3]={10,10,20},b[3]={10,20,20},c[3]={40,40,50},d[3]={40,50,50};
    Figure* figs[6] = {
        (Figure*) rect_new(10,10,100,100),
        (Figure*) ellipse_new(40,10,140,300),
        (Figure*) triangle_new(a,b,3),
        (Figure*) rect_new(10,10,100,100),
        (Figure*) ellipse_new(210,110,305,130),
        (Figure*) triangle_new(c,d,3)
    };

    ///

    for (int i=0; i<6; i++) {
        figs[i]->print(figs[i]);
    }

    ///

    for (int i=0; i<6; i++) {
        free(figs[i]);
    }
}
