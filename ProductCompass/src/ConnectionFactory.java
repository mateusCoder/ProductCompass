
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public Connection changeConnection() throws SQLException {
		return DriverManager
				.getConnection
				("jdbc:mysql://localhost/produtoDatabase?useTimezone=true&serverTimezone=UTC", 
						"root", 
						"root");
	}	
}
