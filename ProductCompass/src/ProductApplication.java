import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class ProductApplication {
	public static void main(String[] args) throws SQLException {
		
		int option; 
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.changeConnection();
		
		ProductDAO product = new ProductDAO(connection);
		
		Scanner read = new Scanner(System.in);
		
		System.out.println("---DATABASE PRODUCTS COMPASS---" + "\n");
		
		System.out.println("Bem vindo, selecione uma opção!" + "\n");
		System.out.println("1 - Cadastrar três produtos");
		System.out.println("2 - Atualizar primeiro produto ");
		System.out.println("3 - Excluir segundo produto ");
		System.out.println("0 - Sair" + "\n");
		option = Integer.parseInt(read.next());
		
		switch(option) {
			case 0:
				System.exit(0);
				
			case 1:
				product.remove(0);
				Product hilux = new Product("Hilux", "Hilux 3.0 Turbo Diesel", 1, 150000.00);
				Product palio = new Product("Palio", "Palio Fire 1.0", 2, 12000.00);
				Product astra = new Product("Astra", "Astra GM II 2.0", 3, 35000.00);
				product.add(palio);
				product.add(hilux);
				product.add(astra);
				break;
				
			case 2:
				System.out.println("Opção 2");
				break;
				
			case 3:
				System.out.println("Opção 3");
				break;
		}
	}
}
