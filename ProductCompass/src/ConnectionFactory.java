
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public static void main(String[] args) throws SQLException {
		Connection connection = DriverManager
				.getConnection("jdbc:mysql://localhost/produtoDatabase?useTimezone=true&serverTimezone=UTC", "root", "root");
	
		System.out.println("Deu certo");
		connection.close();
	}
}
