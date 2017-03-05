package fifawc.ui;

import java.sql.Connection;
import java.sql.DriverManager;

import fifawc.utils.PomocnaKlasa;

public class TestUI {

	public static Connection conn; 
	
	static {
	    try {
			
	    	Class.forName("com.mysql.jdbc.Driver");
	    	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fifawc", "root", "eEflakjv39fE!fjd");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		int choice = -1; 
		
		while (choice != 0) {
			
			System.out.println("1.Prikazi sve drzave");
			System.out.println("2.Prikazi sva prvenstva");
			System.out.println("3.Izmeni Drzave");
			System.out.println("4.Izmeni prvenstvo");
			System.out.println("5.Pretraga i prikaz prvenstva po godini");
			System.out.println("0.EXIT");
			
			System.out.println("Unesi odluku : ");
			choice = PomocnaKlasa.ucitajBroj();
			
			switch (choice) {
			case 0:
				System.out.println("Dovidjenja");
				break;
			case 1:
				DrzavaUI.prikaziSveDrzave();	
				break;
			case 2:
				PrvenstvoUI.prikaziSvaPrvenstva();
				break;
			case 3:
				DrzavaUI.unosIzmenaDrzava();
				break;
			case 4:
				PrvenstvoUI.unosIzmenaPrvenstvo();
				break;
			case 5:	
				PrvenstvoUI.pretragaPrikazPrvenstvaGodina();
                break; 				
			default:
				break;
			}
		}
		
		
	}
	
}
