import java.util.Scanner;

public class ProductApplication {
	public static void main(String[] args) {
		
		int option; 
		
		Scanner read = new Scanner(System.in);
		
		System.out.println("---DATABASE PRODUCTS COMPASS---" + "\n");
		
		System.out.println("Bem vindo, selecione uma op��o!" + "\n");
		System.out.println("1 - Cadastrar tr�s produtos");
		System.out.println("2 - Atualizar primeiro produto ");
		System.out.println("3 - Excluir segundo produto ");
		System.out.println("0 - Sair" + "\n");
		option = Integer.parseInt(read.next());
		
		switch(option) {
			case 0:
				System.exit(0);
			case 1:
				System.out.println("Op��o 1");
				break;
			case 2:
				System.out.println("Op��o 2");
				break;
			case 3:
				System.out.println("Op��o 3");
				break;
		}
	}
}
