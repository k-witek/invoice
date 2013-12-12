/**
 * Klasa tworzaca obiekt o danym adresie, kodzie pocztowym, miescie, panstwie, telefonie i adresie email
 * <p>
 * Kompilacja: javac InvoiceManagement.java
 * <p>
 * Uruchomienie: java InvoiceManagement
 * <p>
 * @author Krzysztof Witek, KrZZis2015
 * <p>
 * @version 6
 */
public class Address {

	private String address;
	private String zipCode;
	private String city;
	private String country;
	private String phone;
	private String email;
	/**
	 * 
	 * @param address adres
	 * @param zipCode kod pocztowy
	 * @param city miasto
	 */
	public Address(String address, String zipCode, String city) {
		super();
		this.address = address;
		this.zipCode = zipCode;
		this.city = city;
	}
	/**
	 * 
	 * @param address adres
	 * @param zipCode kod pocztowy
	 * @param city miasto
	 * @param country panstwo
	 * @param phone telefon
	 * @param email adres email
	 */
	public Address(String address, String zipCode, String city, String country,
			String phone, String email) {
		super();
		this.address = address;
		this.zipCode = zipCode;
		this.city = city;
		this.country = country;
		this.phone = phone;
		this.email = email;
	}
	/**
	 * wydobycie adresu
	 * @return adres
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * ustawienie adresu
	 * @param address adres
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * wydobycie kodu pocztowego
	 * @return kod pocztowy
	 */
	public String getZipCode() {
		return zipCode;
	}
	/**
	 * ustawienie kodu pocztowego
	 * @param zipCode kod pocztowy
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	/**
	 * wydobycie miasta
	 * @return miasto
	 */
	public String getCity() {
		return city;
	}
	/**
	 * ustawienie miasta
	 * @param city miasto
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * wydobycie panstwa
	 * @return panstwo
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * ustawienie panstwa
	 * @param country panstwo
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	/**
	 * wydobycie nr telefonu
	 * @return nr telefonu
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * ustawienie nr telefonu
	 * @param phone nr telefonu
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * wydobycie adresu email
	 * @return adres email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * ustawienie adresu email
	 * @param email adres email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return String.format("%s", getAddress() + ", " + getZipCode() + ", " + getCity() + ", " + getCountry())
				+ String.format("%n%-15s%s", "Phone:", getPhone())
				+ String.format("%n%-15s%s", "Email:", getEmail());
	}
	
	
	
	
}
