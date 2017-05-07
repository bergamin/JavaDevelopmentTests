package products;

public class Product {

	private final String name;
	private final double price;

	public String getName() {
		return name;
	}
	public double getPrice() {
		return price;
	}

	public Product(String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}
	public double getPriceWithTax() {
		return price * 1.1;
	}

}
