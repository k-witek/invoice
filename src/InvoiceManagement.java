import java.util.Scanner;
import java.util.Date;

/**
 * Invoice
 * <p>
 * Program Wyswietlajacy dane dotyczace faktury.
 * <p> 
 * Funkcjonalnosc programu: zapytanie uzytkownika o dane kontrahenta i ilosc produktow do wprowadzenia,
 * nastepnie zapytanie o nazwe, liczbe, cene jednostkowa i stawke VAT okreslonego produktu.
 * Po zebraniu odpowiednich danych, program przechodzi do wypisywania faktury. Program zawsze
 * Wypisze tyle linikek ile produktow zostalo wprowadzonych, obliczy brakujace wartosci,
 * i w zaleznosci od tego czy konkretna stawka VAT wystapila wypisze podsumowanie wg VAT.
 * Szerokosc tabelki ustawiona printf, dostosowana do przykladowych poanych danych w zadaniu.
 * <p>
 * Kompilacja: javac InvoiceManagement.java
 * <p>
 * Uruchomienie: java InvoiceManagement
 * <p>
 */

public class InvoiceManagement {
	
	/**
	 * wydobycie informacji o sprzedawcy
	 * @return dane sprzedawcy
	 */
	public static Company readSellerData() {
		Address adres = new Address("Kochanowskiego 17", "31-782", "Krakow", "Poland", "+48123454943", "office@maxdom.pl");
		Company seller = new Company("MaxDom Ltd", adres, "677-000-21-39");
		return seller;
	}
	/**
	 * wydobycie od uzytkownika informacji o kupujacym
	 * @return dane kupujacego
	 */
	public static Person readBuyerData() {
		Address address = new Address("", "", "", "", "", "");
		Person buyer = new Person("", address, "");
		Scanner sc = new Scanner(System.in);
		System.out.print("Podaj nazwe kupujacego: ");
		buyer.setName(sc.nextLine());
		System.out.print("Podaj ulice zamieszkania kupujacego: ");
		address.setAddress(sc.nextLine());
		System.out.print("Podaj kod pocztowy kupujacego: ");
		address.setZipCode(sc.nextLine());
		System.out.print("Podaj miasto zamieszkania kupujacego: ");
		address.setCity(sc.nextLine());
		System.out.print("Podaj kraj zamieszkania kupujacego: ");
		address.setCountry(sc.nextLine());
		System.out.print("Podaj nr telefonu kupujacego: ");
		address.setPhone(sc.nextLine());
		System.out.print("Podaj email kupujacego: ");
		address.setEmail(sc.nextLine());
		System.out.print("Podaj pesel kupujacego: ");
		buyer.setPesel(sc.nextLine());
		return buyer;
	}
	/**
	 * wydobycie od uzytkownika informacji o produktach
	 * @return tablica produktow
	 */
	public static Product[] readProductsData() {
		
		Scanner strScanner = new Scanner(System.in);
		Scanner intdblScanner = new Scanner(System.in);
		System.out.print("Podaj ilosc produktow, ktora chcesz wprowadzic: ");
		int no = intdblScanner.nextInt();
		Product[] arrayProducts = new Product[no];
		
		for (int i = 0; i < no; i++) {
			System.out.print("Podaj nazwe " + (i+1) + " produktu: ");
			arrayProducts[i] = new Product(strScanner.nextLine());		
			System.out.print("Podaj ilosc produktu \"" + arrayProducts[i].getDescription() + "\": ");
			arrayProducts[i].setQuantity(intdblScanner.nextInt());
			System.out.print("Podaj cene jednostkowa produktu \"" + arrayProducts[i].getDescription() + "\" (x,xx): ");
			arrayProducts[i].setPrice(intdblScanner.nextDouble());
			System.out.print("Podaj stawke podatku VAT dla produktu \"" + arrayProducts[i].getDescription() + "\" (1. 23%, 2. 8%, 3. 5%): ");
			switch(intdblScanner.nextInt()) {
				case 1: arrayProducts[i].setVatRate(0.23);
						break;
				case 2: arrayProducts[i].setVatRate(0.08);
						break;
				case 3: arrayProducts[i].setVatRate(0.05);
						break;
				default: arrayProducts[i].setVatRate(0.23);
			}
		}
		
		intdblScanner.close();
		strScanner.close();
		return arrayProducts;
	}
	/**
	 * wypisanie na ekran informacji o przekazanej fakturze
	 * @param inv przekazywana faktura
	 */
	public static void printInvoice(Invoice inv) {
		
		Date date = new Date();
		System.out.printf("%n%n%-15s%s", "Date:", String.format("%td-%tm-%tY%n%n", date, date, date));	
		System.out.print(inv.toString());

		
		for(int i = 0; i < inv.products.length; i++) {
			System.out.printf("%1s%-3s%s", "|",(i+1), inv.products[i].toString());
			System.out.print("|---|-----------------------------------|--------|-----|------|----|-----|------|\n");
		}
		
		double sumTotal = 0, sumVat = 0, sumGross = 0;
		
		for(int i = 0; i < inv.products.length; i++) {
			sumTotal = sumTotal + (inv.products[i].getQuantity() * inv.products[i].getPrice());
			sumVat = sumVat + (inv.products[i].getQuantity() * inv.products[i].getPrice() * inv.products[i].getVatRate());
			sumGross = sumGross + (inv.products[i].getQuantity() * inv.products[i].getPrice() + (inv.products[i].getQuantity() * inv.products[i].getPrice() * inv.products[i].getVatRate()));
		}
		
		System.out.print("|                                  RAZEM|    X   |  X  |"); System.out.printf("%-6s", String.format("%.2f", sumTotal)); System.out.print("| X  |"); System.out.printf("%-5s%1s%-6s%1s%n", String.format("%.2f", sumVat), "|", String.format("%.2f", sumGross), "|");
		System.out.print("+---------------------------------------+--------+-----+------|----|-----|------|\n");
		
		double sumVatByVat = 0, sumGrossByVat = 0;
		
		for(int i = 0; i < inv.products.length; i++) {
			if (inv.products[i].getVatRate() == 0.23) {
				sumVatByVat += inv.products[i].getVatRate()*inv.products[i].getQuantity()*inv.products[i].getPrice();  
				sumGrossByVat += (inv.products[i].getQuantity() * inv.products[i].getPrice() + (inv.products[i].getQuantity() * inv.products[i].getPrice() * inv.products[i].getVatRate()));
			}
		}
		if (sumVatByVat != 0) {
			System.out.printf("%62s%1s%-5s%-5s%1s%-6s%1s%n", "", "|", "23% |", String.format("%.2f", sumVatByVat), "|", String.format("%.2f", sumGrossByVat), "|");
			System.out.printf("%62s%1s%n", "", "+-----------------+");
			sumVatByVat = 0;
			sumGrossByVat = 0;
		}
		
		for(int i = 0; i < inv.products.length; i++) {
			if (inv.products[i].getVatRate() == 0.08) {
				sumVatByVat += inv.products[i].getVatRate()*inv.products[i].getQuantity()*inv.products[i].getPrice();  
				sumGrossByVat += (inv.products[i].getQuantity() * inv.products[i].getPrice() + (inv.products[i].getQuantity() * inv.products[i].getPrice() * inv.products[i].getVatRate()));
			}
		}
		if (sumVatByVat != 0) {
			System.out.printf("%62s%1s%-5s%-5s%1s%-6s%1s%n", "", "|", "8%  |", String.format("%.2f", sumVatByVat), "|", String.format("%.2f", sumGrossByVat), "|");
			System.out.printf("%62s%1s%n", "", "+-----------------+");
			sumVatByVat = 0;
			sumGrossByVat = 0;
		}
		
		for(int i = 0; i < inv.products.length; i++) {
			if (inv.products[i].getVatRate() == 0.05) {
				sumVatByVat += inv.products[i].getVatRate()*inv.products[i].getQuantity()*inv.products[i].getPrice();  
				sumGrossByVat += (inv.products[i].getQuantity() * inv.products[i].getPrice() + (inv.products[i].getQuantity() * inv.products[i].getPrice() * inv.products[i].getVatRate()));
			}
		}
		if (sumVatByVat != 0) {
			
			System.out.printf("%62s%1s%-5s%-5s%1s%-6s%1s%n", "", "|", "5%  |", String.format("%.2f", sumVatByVat), "|", String.format("%.2f", sumGrossByVat), "|");
			System.out.printf("%62s%1s%n", "", "+-----------------+");
			sumVatByVat = 0;
			sumGrossByVat = 0;
		}
	}
	
	public static void main(String[] args) {
		
		Invoice inv1 = new Invoice(readSellerData(), readBuyerData(), readProductsData());
		printInvoice(inv1);
		
	}
}