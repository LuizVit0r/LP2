package principal;

import modelo.Funcionario;

import java.util.Scanner;

public class Empresa {
	public static void main(String[] args) {
		Funcionario[] f1 = new Funcionario[50];
		Scanner sc = new Scanner(System.in);
		int qtd=0,x=0;
		while(x!=4){
			System.out.println("== Menu - Escolha um para avançar ==");
			System.out.println("1 - Cadastrar cliente");
			System.out.println("2 - Buscar cliente pelo nome");
			System.out.println("3 - Exibir dados dos clientes");
			System.out.println("4 - Sair");
			x=sc.nextInt();
			
			switch(x) {
				case 1:
					System.out.println("Digite a quantidade de funcionarios:");
					qtd=sc.nextInt();
					for(int i=0;i<qtd;i++){
						f1[i]=new Funcionario();
						f1[i].le();
					}
					break;
				case 2:
					String nome;
					int c=0;
					System.out.println("Digite o nome a ser procurado:");
					nome=sc.next();
					for(int i=0;i<qtd;i++){
						if(f1[i].nome.equals(nome)) {
							c++;
						}else{
						}
					}
					
					if(c>0)
						System.out.println("Nome encontrado "+c+" vezes");
					else
						System.out.println("Nome não encontrado");
					
					break;
				case 3:
					for(int i=0;i<qtd;i++) {
						f1[i].imprime();
					}
					break;
				case 4:
					System.out.println("fim do programa");
					break;
			}
		}
		sc.close();
		
		
	}

}