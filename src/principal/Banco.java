package principal;

import modulo.Conta;

import java.util.Scanner;

public class Banco {
	public static void main(String[] args) {
		Conta c1 = new Conta();
		Conta c2 = new Conta();
		
		c1.le();
		c2.le();
		c1.imprime();
		c2.imprime();
		
		c1.sacar();
		c1.depositar();
		c1.transferir(c2);
		c1.consultaSaldo();
		
	}

}
