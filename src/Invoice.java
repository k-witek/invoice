public class Invoice {
	
private static int invoiceCounter = 0;
private int invoiceNumber = 1000;
private Contractor seller;
private Contractor buyer;
private Product[] products;

	public Invoice(Contractor seller, Contractor buyer, Product[] products) {
		this.seller = seller;
		this.buyer = buyer;
		this.products = products;
	}

	@Override
	public String toString() {
		return 	String.format("%s", buyer.getName())
			  + String.format("%s", buyer.getPesel());

	}
}