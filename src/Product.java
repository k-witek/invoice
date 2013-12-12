/**
 * Product
 * <p>
 * Klasa opisujaca dostepne produkty skladajace sie z pol nazwy, ilosci, ceny i stawki vat
 * <p>
 * Kompilacja: javac InvoiceManagement.java
 * <p>
 * Uruchomienie: java InvoiceManagement
 * <p>
 * @version 5
 * @author Krzysztof Witek, KrZZis2015
 */
public class Product {

	private String description;
	private int quantity;
	private double price;
	private double vatRate;
	/**
	 * utworzenie obiektu w zaleznosci od 1 parametru, jego nazwy
	 * @param description nazwa produktu
	 */
	public Product(String description) {
		super();
		this.description = description;
	}
	/**
	 * utworzenie obiektu w zaleznosci od wszystkich parametrow
	 * @param description nazwa produktu
	 * @param quantity ilosc produktu
	 * @param price cena jednostkowa produktu
	 * @param vatRate stawka vat
	 */
	public Product(String description, int quantity, double price, double vatRate) {
		super();
		this.description = description;
		this.quantity = quantity;
		this.price = price;
		this.vatRate = vatRate;
	}
	public String getDescription() {
		return description;
	}
	/**
	 * ustawienie nazwy produktu
	 * @param description nazwa produktu
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	public int getQuantity() {
		return quantity;
	}
	/**
	 * ustawienie ilosci produktu
	 * @param quantity ilosc produktu
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	/**
	 * ustawienie ceny produktu
	 * @param price cena produktu
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	public double getVatRate() {
		return vatRate;
	}
	/**
	 * ustawienie stawki vat dla produktu
	 * @param vatRate stawka vat
	 */
	public void setVatRate(double vatRate) {
		this.vatRate = vatRate;
	}
	/**
	 * obliczenie wartosci total
	 * @return total
	 */
	public double calculateTotal() {
		return quantity*price;
	}
	/**
	 * obliczenie wartosci vat
	 * @return vat
	 */
	public double calculateVat() {
		return quantity*price*vatRate;
	}
	/**
	 * obliczenie wartosci calkowitej
	 * @return wartosc calkowita
	 */
	public double calculateGross() {
		return quantity*price+quantity*price*vatRate;
	}
	@Override
	public String toString() {
		return String.format("%1s%-35s%1s%-8s%1s%-5s%1s%-6s%1s%-4s%1s%-5s%1s%-6s%1s%n", "|", getDescription(), "|", getQuantity(), "|", String.format("%.2f", getPrice()), "|", String.format("%.2f", calculateTotal()), "|", String.format("%.0f%%", getVatRate()*100), "|", String.format("%.2f", calculateVat()), "|", String.format("%.2f", calculateGross()) , "|");
	}
	
}
	
	