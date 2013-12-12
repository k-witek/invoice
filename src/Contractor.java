/**
 * Klasa tworzaca obiekt kontrahenta o danej nazwie i jego adresie
 * Kompilacja: javac InvoiceManagement.java
 * <p>
 * Uruchomienie: java InvoiceManagement
 * <p>
 * @author Krzysztof Witek, KrZZis2015
 * <p>
 * @version 6
 */
public class Contractor {

	private String name;
	private Address address;
	/**
	 * konstruktor wg nazwy
	 * @param name nazwa
	 */
	public Contractor(String name) {
		super();
		this.name = name;
	}
	/**
	 * konstruktor wg nazwy i adresu
	 * @param name nazwa
	 * @param address adres
	 */
	public Contractor(String name, Address address) {
		super();
		this.name = name;
		this.address = address;
	}
	/**
	 * wydobycie nazwy
	 * @return nazwa
	 */
	public String getName() {
		return name;
	}
	/**
	 * ustawienie nazwy
	 * @param name nazwa
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * wydobycie adresu
	 * @return adres
	 */
	public Address getAddress() {
		return address;
	}
	/**
	 * ustawienie adresu
	 * @param address adres
	 */
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Contractor [name=" + name + ", address=" + address + "]";
	}
	
	
	
}
