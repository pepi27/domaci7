package fifawc.ui;

import java.util.ArrayList;

import fifawc.DAO.PrvenstvoDAO;
import fifawc.model.Prvenstvo;
import fifawc.utils.PomocnaKlasa;

public class PrvenstvoUI {

	public static ArrayList<Prvenstvo> svaPrvenstva = new ArrayList<>();

	public static void prikaziSvaPrvenstva() {

		svaPrvenstva = PrvenstvoDAO.getAll(TestUI.conn);

		for (Prvenstvo p : svaPrvenstva) {
			System.out.println(p.toString());
		}

		System.out.println();

	}

	public static void unosIzmenaPrvenstvo() {

	}

	public static void pretragaPrikazPrvenstvaGodina() {
        System.out.println("Unesite godinu prvenstva : ");
        int broj = PomocnaKlasa.ucitajBroj();
        
        Prvenstvo prvenstvo = PrvenstvoDAO.nadjiPrvenstvoPoGodini(TestUI.conn, broj);
        if(prvenstvo != null) {
        	System.out.println(prvenstvo.toString());
        } else {
        	System.out.println("Ne postoji prvenstvo u bazi\n");
        }
	}
}
