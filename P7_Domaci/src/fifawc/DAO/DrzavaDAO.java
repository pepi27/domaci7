package fifawc.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fifawc.model.Drzava;
import fifawc.ui.TestUI;
import fifawc.utils.PomocnaKlasa;

public class DrzavaDAO {

	public static ArrayList<Drzava> getAll(Connection conn) {
		ArrayList<Drzava> retVal = new ArrayList<Drzava>();
		try {
			String query = "SELECT * FROM drzava";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			while(rs.next()) {
				int id = rs.getInt(1);
				String naziv = rs.getString(2);
				Drzava drzava = new Drzava(id, naziv);
				retVal.add(drzava);
			}
			
			st.close();
			rs.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return retVal;
	}
	
	public static void updateOne(Connection conn, int choice) {
		System.out.println("Unesi naziv drzave");
		String drNaziv = PomocnaKlasa.ucitajTekst();
		
		try {
			String updateQery = "UPDATE drzava"
					+ " SET naziv='" + drNaziv + "'" 
					+ " WHERE drzava.id=" + choice;
			Statement st = TestUI.conn.createStatement();
			st.executeUpdate(updateQery);
			
			System.out.println("Drzava uspesno promenjena.");

			st.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
