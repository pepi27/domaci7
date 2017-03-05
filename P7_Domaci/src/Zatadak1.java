import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Zatadak1 {

	public static void main(String[] args) {
		try {

			// ucitavanje MySQL drajvera
			Class.forName("com.mysql.jdbc.Driver");

			// konekcija
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentskasluzba", "root",
					"eEflakjv39fE!fjd");

			// Slanje upita
			String query = "SELECT naziv, ptt FROM grad";
			
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery(query);

			// Citanje rezultata upita
			while (rset.next()) {
				System.out.println(rset.getString(1) + " " + rset.getInt(2));
			}
			
			System.out.println();
			
			//String query2 = "INSERT INTO grad (ptt, naziv) values(24000, 'Subotica'), (34000, 'Kragujevac')";
			
			//stmt.executeUpdate(query2);
			
			
			//rset = stmt.executeQuery(query);
			
//			while (rset.next()) {
//				System.out.println(rset.getString(2) + " " + rset.getInt(1));
//			}
//			
			query = "SELECT * FROM grad WHERE naziv like \'%s%\' AND ptt < 20000";
			
			rset = stmt.executeQuery(query);
			
			while (rset.next()) {
				System.out.println(rset.getString(2) + " " + rset.getInt(1));
			}
			
			System.out.println();
			
			query = "DELETE FROM grad WHERE ptt = 26300";
			stmt.executeUpdate(query);
			
			query = "SELECT naziv, ptt FROM grad";
			
			rset = stmt.executeQuery(query);
			
			while (rset.next()) {
				System.out.println(rset.getString(1) + " " + rset.getInt(2));
			}
			

			// zatvaranje veze
			rset.close();
			stmt.close();
			conn.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
// a. Ubaciti u tabelu gradova gradove 24000, Subotica i 34000,Kragujevac
// b. Prikazati gradove koji sadrže slovo ‘s’ u imenu i imaju ptt broj manji od
// 30000
// c. Obrisati grad Subotica iz tabele Grad (na osnovu primarnog ključa
// odgovarajućeg sloga)
