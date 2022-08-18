package modelo;

public class Diretor {
	private String nome;
	private int exp;
	private String local;
	
	public Diretor(String nome, int exp, String local) {
		this.nome = nome;
		this.exp = exp;
		this.local = local;
	}
	public Diretor() {
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	
	public void imprime() {
		System.out.println("Informaçoes do Diretor");
		System.out.println("Nome:"+getNome());
		System.out.println("Anos de Experiencia:"+getExp());
		System.out.println("Local de Origem:"+getLocal());
	}
	
}


