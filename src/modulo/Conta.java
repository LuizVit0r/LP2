package modulo;

import java.util.Scanner;

public class Conta {
	public int num;
	public String nome;
	public int tipo;
	public double sal;
	public double lim;

	public Conta(int num, String nome, int tipo, double sal, double lim){
		this.num=num;
		this.nome=nome;
		this.tipo=tipo;
		this.sal=sal;
		this.lim=lim;	
	}public Conta(){
	}
	
	public void sacar(){
		Scanner sc = new Scanner(System.in);
		double x;
		do{
			System.out.println("Digite o valor a ser sacado:");
			x = sc.nextDouble();
			if(x>this.sal)
				System.out.println("Valor Inválido");
		}while(x>this.sal);
		this.sal-=x;
		System.out.println("Valor sacado: "+x);
		System.out.println("Saldo atual: "+this.sal);
		
	}
	
	public void depositar(){
		Scanner sc = new Scanner(System.in);
		double x;
		do{
			System.out.println("Digite o valor a ser depositado:");
			x = sc.nextDouble();
			if(this.sal+x > this.lim)
				System.out.println("Valor Inválido");
		}while(this.sal+x > this.lim);
		this.sal+=x;
		System.out.println("Valor depositado: "+x);
		System.out.println("Saldo atual: "+this.sal);
		
	}
	
	public void consultaSaldo() {
		System.out.println("Consulta de Saldo: "+this.sal);
	}
	
	public void transferir(Conta c2){
		Scanner sc = new Scanner(System.in);
		double x;
		do{
			System.out.println("Digite o valor a ser transferido:");
			x = sc.nextDouble();
			if(c2.sal+x > c2.lim || x>this.sal)
				System.out.println("Valor Inválido");
		}while(c2.sal+x > c2.lim || x>this.sal);
		this.sal-=x;
		c2.sal+=x;
		System.out.println("Valor transferido de c1 para c2: "+x);
		System.out.println("Saldo da Conta c1: "+this.sal);
		System.out.println("Saldo da Conta c2: "+c2.sal);
		
	}

	public void le(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite o numero da conta:");
		this.num = sc.nextInt();
		System.out.println("Digite o nome da conta:");
		this.nome = sc.next();
		do{
			System.out.println("Digite o tipo da conta:");
			this.tipo = sc.nextInt();
		}while(this.tipo>2);
		System.out.println("Digite o saldo da conta:");
		this.sal = sc.nextDouble();
		System.out.println("Digite o limite da conta:");
		this.lim = sc.nextDouble();
		
	}
	
	public void imprime(){
		System.out.println("Dados da conta");
		System.out.println("Numero da conta: "+this.num);
		System.out.println("Nome da conta: "+this.nome);
		if(this.tipo == 1)
			System.out.println("Tipo da conta: Conta Corrente");
		else
			System.out.println("Tipo da conta: Poupança");
		System.out.println("Saldo da conta: "+this.sal);
		System.out.println("Limite da conta: "+this.lim);
	}
}







