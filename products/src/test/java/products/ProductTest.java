package products;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ProductTest {
	
	@Test
	public void verifyPriceWithTax(){
		Product candy = new Product("Altoids",1.00);
		assertEquals(1.10,candy.getPriceWithTax(),0.0001);
	}

}
