package uebung01;

import static gdi.MakeItSimple.*;

// ein Kommentar 23

public class Conversion {
	
	static int parseInteger(String digits) {
		int number = 0;
		int i = 0;
		while (i < digits.length()) {
			number = number * 10 + digits.charAt(i) - '0';
			i++;
		}
		if (digits.equals(number + ""))
			return number;
		else
			throw new GDIException("Keine gültige Eingabe");
	}
	
	
	public static void main(String[] args) {
		print("Geben Sie eine Zahl ein (wird als String gelesen): ");
		String numberAsString = readLine();
		
		println("Gewandelte Zahl: " + parseInteger(numberAsString));
	}

}
