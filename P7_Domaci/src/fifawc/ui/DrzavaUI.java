package fifawc.ui;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fifawc.DAO.DrzavaDAO;
import fifawc.model.Drzava;
import fifawc.utils.PomocnaKlasa;

public class DrzavaUI {

	public static ArrayList<Drzava> sveDrzave = new ArrayList<>();

	public static void prikaziSveDrzave() {
		sveDrzave = DrzavaDAO.getAll(TestUI.conn);

		for (Drzava d : sveDrzave) {
			System.out.println(d.toString());
		}
		System.out.println();
	}

	public static void unosIzmenaDrzava() {

		prikaziSveDrzave();
		System.out.println("\nUnesite id drzave koju zelite da izmenite : ");
		int choice = PomocnaKlasa.ucitajBroj();

		for (Drzava d : sveDrzave) {
			if (d.getId() != choice) {
				continue;
			} else {
				DrzavaDAO.updateOne(TestUI.conn, choice);
			}
		}
	}

	public static Drzava getDrzavaPoID(int id) {
		Drzava retVal = null;
		sveDrzave = DrzavaDAO.getAll(TestUI.conn);
		for (Drzava d : sveDrzave) {
			if (d.getId() == id) {
				retVal = d;
				break;
			}
		}
		return retVal;
	}
}
