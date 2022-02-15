#include <stdio.h>

typedef struct {
  int c;		//comprimento da espiral
  int r;		//raio interno da espiral
  int nvol;		//numero de voltas da espiral
} Espiral;

void print (Espiral* e) {
  printf("Espiral de comprimento %d com raio interno %d e %d voltas.\n", e->c,e->r,e->nvol);
}

void main (void) {
    Espiral e1 = { 10,3,5 };
    print(&e1);
}


