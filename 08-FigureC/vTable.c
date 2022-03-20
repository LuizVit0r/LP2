#include <stdio.h>
#include <stdlib.h>
#include <math.h>                //biblioteca math para simplificar as contas

typedef struct {
    int r,g,b;
} Color;

struct Figure;

typedef void (* Figure_Print) (struct Figure*);
typedef int  (* Figure_Area)  (struct Figure*);
typedef void (* Figure_Drag)  (struct Figure*);       //novo metodo

typedef struct {
    void (* print) (struct Figure*);
    int  (* area)  (struct Figure*);
    void (* drag)  (struct Figure*);
} Figure_vtable;

typedef struct Figure {
    int x, y;
    Color fg, bg;
    Figure_vtable* vtable;
} Figure;

///////////////////////////////////////////////////////////////////////////////

typedef struct {
    Figure super;
    int w, h;
} Rect;

void rect_print (Rect* this) {
    Figure* sup = (Figure*) this;
    printf("Retangulo de tamanho (%d,%d) na posicao (%d,%d) e area %d.\n",
           this->w, this->h, sup->x, sup->y, sup->vtable->area(sup));
}

int rect_area (Rect* this) {
    Figure* sup = (Figure*) this;
    return this->w * this->h;
}

void rect_drag (Rect* this){             //drag para retangulos
    Figure* sup = (Figure*) this;
    printf("Retangulo de tamanho (%d,%d) na nova posicao (%d,%d) e area %d.\n",
           this->w, this->h, (sup->x)+10, (sup->y)+10, sup->vtable->area(sup));

}

Figure_vtable rect_vtable = {
    (Figure_Print) rect_print,
    (Figure_Area)  rect_area,
    (Figure_Drag)  rect_drag
};

Rect* rect_new (int x, int y, int w, int h) {
    Rect*   this  = malloc(sizeof(Rect));
    Figure* sup = (Figure*) this;
    sup->vtable = &rect_vtable;
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

void ellipse_print (Ellipse* this) {
    Figure* sup = (Figure*) this;
    printf("Elipse de tamanho (%d,%d) na posicao (%d,%d) e area %d.\n",
           this->w, this->h, sup->x, sup->y, sup->vtable->area(sup));
}

int ellipse_area (Ellipse* this) {
    Figure* sup = (Figure*) this;
    return this->w * this->h;
}

void ellipse_drag (Ellipse* this) {        // drag para elipses
    Figure *sup = (Figure*) this;
    printf("Elipse de tamanho (%d,%d) na nova posicao (%d,%d) e area %d.\n",
           this->w, this->h, (sup->x)+10, (sup->y)+10, sup->vtable->area(sup));
}

Figure_vtable ellipse_vtable = {
    (Figure_Print) ellipse_print,
    (Figure_Area)  ellipse_area,
    (Figure_Drag)  ellipse_drag
};

Ellipse* ellipse_new (int x, int y, int w, int h) {
    Ellipse* this = malloc(sizeof(Ellipse));
    Figure* sup = (Figure*) this;
    sup->vtable = &ellipse_vtable;
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

void triangle_print (Triangle* this) {
    Figure* sup = (Figure*) this;
    printf("Triangulo com vertices nas posicoes (%d,%d),(%d,%d) e (%d,%d) e area %d.\n",
           this->x1[0], this->y1[0], this->x1[1], this->y1[1], this->x1[2],this->y1[2],sup->vtable->area(sup));
}

int triangle_area (Triangle* this) {        //metodo que utiliza a formula de heron para calcular a area do triangulo
    Figure* sup = (Figure*) this;
    int d1,d2,d3;
    d1=sqrt(pow(abs((this->x1[1])-(this->x1[0])),2)+pow(abs((this->y1[1])-(this->y1[0])),2));
    d2=sqrt(pow(abs((this->x1[2])-(this->x1[1])),2)+pow(abs((this->y1[2])-(this->y1[1])),2));
    d3=sqrt(pow(abs((this->x1[2])-(this->x1[0])),2)+pow(abs((this->y1[2])-(this->y1[0])),2));
    int p=(d1+d2+d3)/2;
    int a=sqrt(p*(p-d1)*(p-d2)*(p-d3));
    return a;
}

void triangle_drag (Triangle* this) {     //drag para triangulos
    Figure *sup = (Figure*) this;
    printf("Triangulo com novos vertices nas posicoes (%d,%d),(%d,%d) e (%d,%d) e area %d.\n",
           (this->x1[0]+10), (this->y1[0]+10), (this->x1[1]+10), (this->y1[1]+10), (this->x1[2]+10), (this->y1[2]+10),sup->vtable->area(sup));
}

Figure_vtable triangle_vtable = {
    (Figure_Print) triangle_print,
    (Figure_Area)  triangle_area,
    (Figure_Drag)  triangle_drag
};

Triangle* triangle_new (int x1[], int y1[], int n) {
    Triangle* this = malloc(sizeof(Triangle));
    Figure* sup = (Figure*) this;
    sup->vtable = &triangle_vtable;
    this->n = n;
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
        (Figure*) rect_new(20,20,100,100),
        (Figure*) ellipse_new(210,110,305,130),
        (Figure*) triangle_new(c,d,3)
    };

    ///

    for (int i=0; i<6; i++) {
        figs[i]->vtable->print(figs[i]);
        figs[i]->vtable->drag(figs[i]);
        printf("\n");
    }

    ///

    for (int i=0; i<6; i++) {
        free(figs[i]);
    }
}
