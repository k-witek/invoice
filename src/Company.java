/**
 * Klasa dziedzicaca po klasie Contractor, dodaje do niego NIP
 * <p>
 * Kompilacja: javac InvoiceManagement.java
 * <p>
 * Uruchomienie: java InvoiceManagement
 * <p>
 * @author Krzysztof Witek, KrZZis2015
 * <p>
 * @version 6
 */
public class Company extends Contractor {

	private String NIP;
    /**
     * konstruktor tworzacy obiekt wg nazwy, adresu i NIP
     * @param name nazwa
     * @param address adres
     * @param NIP NIP
     */
	public Company(String name, Address address, String NIP) {
		super(name, address);
		this.NIP = NIP;
	}
	/**
	 * wydobycie NIP
	 * @return NIP
	 */
	public String getNIP() {
		return NIP;
	}
	/**
	 * ustawienie NIP
	 * @param NIP NIP
	 */
	public void setNIP(String NIP) {
		this.NIP = NIP;
	}

	@Override
	public String toString() {
		return "Company [NIP=" + NIP + ", toString()=" + super.toString() + "]";
	}

}