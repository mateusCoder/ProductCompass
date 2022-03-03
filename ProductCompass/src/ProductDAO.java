import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
	
	public void reset() throws SQLException {
		PreparedStatement pstm = connection.prepareStatement("TRUNCATE TABLE PRODUTO");
		pstm.execute();
	}
	
	public void removeProduct(int productNumberRemoved) throws SQLException {
		PreparedStatement pstm = connection.prepareStatement("DELETE FROM PRODUTO WHERE ID = ?");
		pstm.setInt(1, productNumberRemoved);
		pstm.execute();
	}
	
	public void updateProduct() throws SQLException {
		PreparedStatement pstm = connection.prepareStatement("UPDATE Produto SET nome = 'Palio 1.8 R '  WHERE ID = ?");
		pstm.setInt(1, 1);
		pstm.execute();
	}
	
	public List<Product> list() throws SQLException{
		List<Product> products = new ArrayList<Product>();
		
		String sql = "SELECT ID, NOME, DESCRICAO, QUANTIDADE, PRECO FROM PRODUTO";
		
		try(PreparedStatement pstm = connection.prepareStatement(sql)){
			pstm.execute();
			try(ResultSet rst = pstm.getResultSet()){
				while(rst.next()) {
					Product product =
							new Product(rst.getInt(1), 
									rst.getString(2), 
									rst.getString(3), 
									rst.getInt(4), 
									rst.getDouble(5));
					products.add(product);
				}
			}
		}
		return products;
	}
}
