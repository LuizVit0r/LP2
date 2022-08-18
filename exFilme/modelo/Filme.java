package modelo;

public class Filme {
	private String titulo;
	private String descriçao;
	private int duraçao;
	private Diretor dr;
	
	public Filme(String titulo, String descriçao, int duraçao, Diretor dr) {
		this.titulo = titulo;
		this.descriçao = descriçao;
		this.duraçao = duraçao;
		this.dr = dr;
	}
	public Filme() {
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescriçao() {
		return descriçao;
	}
	public void setDescriçao(String descriçao) {
		this.descriçao = descriçao;
	}
	public int getDuraçao() {
		return duraçao;
	}
	public void setDuraçao(int duraçao) {
		this.duraçao = duraçao;
	}
	public Diretor getDr() {
		return dr;
	}
	public void setDr(Diretor dr) {
		this.dr = dr;
	}
	
	public void exibirEmHoras(int duraçao) {
		int h,m;
		h = duraçao/60;
		m = duraçao%60;
		System.out.println("O filme "+getTitulo()+" possui "+h+" horas e "+m+" minutos de duração");
	}
	
	public boolean comparaFilme(String titulo) {
		if(this.titulo==titulo) {
			return true;
		}
		return false;
	}
	
	public void imprime() {
		System.out.println("Informaçoes do Filme");
		System.out.println("Titulo: "+getTitulo());
		System.out.println("Descriçao: "+getDescriçao());
		exibirEmHoras(this.duraçao);
		System.out.println("Nome do Diretor: "+this.dr.getNome());
	}
		
		
}
