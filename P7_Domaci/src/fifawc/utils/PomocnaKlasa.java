package fifawc.utils;

import java.util.Scanner;

public class PomocnaKlasa {

	static Scanner input = new Scanner(System.in);

	public static int ucitajBroj() {
		while (input.hasNextInt() == false) {
			System.out.println("Greska unesite ispravnu vrednost");
			input.nextLine();
		}
		int broj = input.nextInt();
		input.nextLine();
		return broj;
	}

	public static String ucitajTekst() {
		String unos = "";
		while (unos == null || unos.equals("")) {
			unos = input.nextLine();
		}
		return unos;

	}
}
