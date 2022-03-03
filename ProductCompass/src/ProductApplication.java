import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ProductApplication {
	public static void main(String[] args) throws SQLException {
		
		int option = -1; 
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.recoverConnection();
		
		ProductDAO product = new ProductDAO(connection);
		
		Scanner read = new Scanner(System.in);
		
		System.out.println("---DATABASE PRODUCTS COMPASS---" + "\n");
		
		System.out.println("Bem vindo, selecione uma opção!" + "\n");
		System.out.println("1 - Cadastrar três produtos");
		System.out.println("2 - Atualizar primeiro produto ");
		System.out.println("3 - Excluir segundo produto ");
		System.out.println("0 - Sair" + "\n");
		
		while(option != 0) {
			option = Integer.parseInt(read.next());
			
			List<Product> listProducts;
			
			switch(option) {
			case 0:
				System.exit(0);
				
			case 1:
				product.reset();
				Product hilux = new Product("Hilux", "Hilux 3.0 Turbo Diesel", 1, 150000.00);
				Product palio = new Product("Palio", "Palio Fire 1.0", 2, 12000.00);
				Product astra = new Product("Astra", "Astra GM II 2.0", 3, 35000.00);
				product.add(palio);
				product.add(hilux);
				product.add(astra);
				listProducts = product.list();
				listProducts.stream().forEach(lp -> System.out.println(lp));
				break;
				
			case 2:
				product.updateProduct();
				listProducts = product.list();
				listProducts.stream().forEach(lp -> System.out.println(lp));
				break;
				
			case 3:
				product.removeProduct(2);
				listProducts = product.list();
				listProducts.stream().forEach(lp -> System.out.println(lp));
				break;
				
			default:
				System.out.println("[Dado Inválido] Digite uma opção válida!");
			}
		}
	}
}
