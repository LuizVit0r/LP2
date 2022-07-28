package modelo;

import java.util.Scanner;

public class Funcionario {
	private String nome;
	private double sal;
	private String cpf;
	private int ano;
	
	public Funcionario(String nome, double sal, String cpf, int ano) {
		this.nome=nome;
		this.sal=sal;
		this.cpf=cpf;
		this.ano=ano;
	}
	public Funcionario() {
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	
	public void le() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite o nome:");
		setNome(sc.next());
		System.out.println("Digite o salario:");
		setSal(sc.nextDouble());
		System.out.println("Digite o CPF:");
		setCpf(sc.next());
		System.out.println("Digite o ano da contratação:");
		setAno(sc.nextInt());
	}
	
	public void imprime() {
		System.out.println("Dados do Funcionario");
		System.out.println("Nome: ");
		System.out.println(getNome());
		System.out.println("Salario: ");
		System.out.println(getSal());
		System.out.println("CPF: ");
		System.out.println(getCpf());
		System.out.println("Ano da contratação: ");
		System.out.println(getAno());
	}
	
	public void aumentaSalario() {
		double x;
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite quantos % o salario vai aumentar:");
		x = sc.nextDouble();
		x = x/100;
		this.sal += x*this.sal;
		System.out.println("Novo salario: "+this.sal);
	}
}
