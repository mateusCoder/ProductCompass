
public class Product {
	private int id;
	private String name;
	private String description;
	private int amount;
	private double price;

	public Product(int id, String name, String description, int amount, double price) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.amount = amount;
		this.price = price;
	}
	public Product(String name, String description, int amount, double price) {
		this.name = name;
		this.description = description;
		this.amount = amount;
		this.price = price;
	}
	

	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public int getAmount() {
		return amount;
	}

	public double getPrice() {
		return price;
	}

	public void setId(int id) {
		this.id = id;
	}	
	
	@Override
	public String toString() {
		return String.format("ID %d \n"
				+ "Nome %s \n"
				+ "Descrição %s \n"
				+ "Quantidade %d \n"
				+ "Preço R$ %.2f \n", this.id, this.name, this.description, this.amount, this.price);
	}
}
