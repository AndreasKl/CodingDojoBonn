package hogwarts.potter.kata;

import org.junit.*;

public class PotterCartTest {

	private static final double ROUNDING_DELTA = 0.001;

	@Test
	public void oneBookCostEightEuros() {
		PotterCart cart = createShoppingCart();
		cart.addBook(1);
		Assert.assertEquals(8.0, cart.getOverall(), ROUNDING_DELTA);
	}

	@Test
	public void fourEqualBookCostEachEightEuros() {
		PotterCart cart = createShoppingCart();
		cart.addBook(1);
		cart.addBook(1);
		cart.addBook(1);
		cart.addBook(1);
		Assert.assertEquals(32.0, cart.getOverall(), ROUNDING_DELTA);
	}

	@Test
	public void twoDifferentBooksCostsFifePercentLess() {
		PotterCart cart = createShoppingCart();
		cart.addBook(1);
		cart.addBook(2);
		Assert.assertEquals(15.2, cart.getOverall(), ROUNDING_DELTA);
	}

	@Test
	public void twoEqualBooksAndOneDifferentCostsFivePercentLess() {
		PotterCart cart = createShoppingCart();
		cart.addBook(1);
		cart.addBook(1);
		cart.addBook(2);
		Assert.assertEquals(23.2, cart.getOverall(), ROUNDING_DELTA);
	}

	@Test
	public void threeDifferentBooksCostsTenPercentLess() {
		PotterCart cart = createShoppingCart();
		cart.addBook(1);
		cart.addBook(2);
		cart.addBook(3);
		Assert.assertEquals(21.6, cart.getOverall(), ROUNDING_DELTA);
	}

	@Test
	public void eightBooksFiveDifferentCostTwentyPercentLess() {
		PotterCart cart = createShoppingCart();
		cart.addBook(1);
		cart.addBook(2);
		cart.addBook(3);
		cart.addBook(4);
		cart.addBook(5);
		cart.addBook(1);
		cart.addBook(2);
		cart.addBook(3);
		Assert.assertEquals(51.20, cart.getOverall(), ROUNDING_DELTA);
	}

	private PotterCart createShoppingCart() {
		return new PotterCart();
	}

}
