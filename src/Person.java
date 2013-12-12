/**
 * Klasa dziedzicaca po klasie Contractor, dodaje do niego pesel
 * <p>
 * Kompilacja: javac InvoiceManagement.java
 * <p>
 * Uruchomienie: java InvoiceManagement
 * <p>
 * @author Krzysztof Witek, KrZZis2015
 * <p>
 * @version 6
 */
public class Person extends Contractor {

	private String pesel;
	/**
	 * konstruktor tworzacy obiekt wg nazwy, adresu i peselu
	 * @param name nazwa
	 * @param address adres
	 * @param pesel pesel
	 */
	public Person(String name, Address address, String pesel) {
		super(name, address);
		this.pesel = pesel;
	}
	/**
	 * wydobycie peselu
	 * @return pesel
	 */
	public String getPesel() {
		return pesel;
	}
	/**
	 * ustawienie peselu
	 * @param pesel pesel
	 */
	public void setPesel(String pesel) {
		this.pesel = pesel;
	}

	@Override
	public String toString() {
		return "Person [pesel=" + pesel + ", toString()=" + super.toString()
				+ "]";
	}
	
}