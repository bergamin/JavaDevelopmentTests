package products;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		Product product = new Product("candy", 0.15);
		System.out.println("The name of the product is " + product.getName() + " and it costs " + product.getPrice());
	}
}
