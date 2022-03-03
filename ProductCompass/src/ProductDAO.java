import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductDAO {
	private Connection connection;
	
	public ProductDAO(Connection connection) {
		this.connection = connection;
	}
	
	public void add(Product product) throws SQLException {
		String sql = "INSERT INTO PRODUTO (NOME, DESCRICAO, QUANTIDADE, PRECO) VALUES (?, ?, ?, ?)";
		
		try(PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
			pstm.setString(1, product.getName());
			pstm.setString(2, product.getDescription());
			pstm.setInt(3, product.getAmount());
			pstm.setDouble(4, product.getPrice());
			
			pstm.execute();
			
			try(ResultSet rst = pstm.getGeneratedKeys()){
				while(rst.next()) {
					product.setId(rst.getInt(1));
				}
			}
		}
	}
	
	public void remove(int itemNumberRemoved) throws SQLException {
		PreparedStatement pstm = connection.prepareStatement("DELETE FROM PRODUTO WHERE ID >= ?");
		pstm.setInt(1, itemNumberRemoved);
		pstm.execute();
	}
}
