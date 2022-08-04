package principal;

import modelo.Funcionario;

import java.util.Scanner;

public class Empresa {
	public static void main(String[] args) {
		Funcionario[] f1 = new Funcionario[50];
		Scanner sc = new Scanner(System.in);
		int qtd,x=0;
		while(x!=4){
			System.out.println("== Menu - Escolha um para avançar ==");
			System.out.println("1 - Cadastrar cliente");
			System.out.println("2 - Buscar cliente pelo nome");
			System.out.println("3 - Exibir dados dos clientes");
			System.out.println("4 - Sair");
			x=sc.nextInt();
			
			switch(x) {
				case 1:
					for(int i=0;i<3;i++){
						f1[i]=new Funcionario();
						f1[i].le();
					}
					break;
				case 2:
					String nome;
					System.out.println("Digite o nome a ser procurado:");
					nome=sc.next();
					for(int i=0;i<3;i++){
						if(f1[i].buscaNome(nome)==1)
							System.out.println("Nome encontrado");
						else
							System.out.println("Nome nao encontrado");
					}
					
					break;
				case 3:
					for(int i=0;i<3;i++) {
						f1[i].imprime();
					}
					break;
				case 4:
					System.out.println("fim do programa");
					break;
			}
		}
		
		
	}

}