package modelo;

import java.util.Scanner;

public class Funcionario {
	public String nome;
	private double codigo;
	private String cpf;
	private int tel;
	
	public Funcionario(String nome, double codigo, String cpf, int tel) {
		this.nome=nome;
		this.codigo=codigo;
		this.cpf=cpf;
		this.tel=tel;
	}
	public Funcionario() {
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getCodigo() {
		return codigo;
	}
	public void setCodigo(double codigo) {
		this.codigo = codigo;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public int getTel() {
		return tel;
	}
	public void setTel(int tel) {
		this.tel = tel;
	}
	
	public void le() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite o nome:");
		setNome(sc.next());
		System.out.println("Digite o codigo:");
		setCodigo(sc.nextDouble());
		System.out.println("Digite o CPF:");
		setCpf(sc.next());
		System.out.println("Digite o telefone:");
		setTel(sc.nextInt());
	}
	
	public void imprime() {
		System.out.println("Dados do Funcionario");
		System.out.println("Nome: ");
		System.out.println(getNome());
		System.out.println("Codigo: ");
		System.out.println(getCodigo());
		System.out.println("CPF: ");
		System.out.println(getCpf());
		System.out.println("Telefone: ");
		System.out.println(getTel());
	}
	
	//public void buscaNome(String nome , int qtd )
}