package fifawc.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fifawc.model.Prvenstvo;
import fifawc.ui.DrzavaUI;

public class PrvenstvoDAO {

	public static ArrayList<Prvenstvo> getAll(Connection conn) {
		ArrayList<Prvenstvo> retVal = new ArrayList<>(); 
		
		try {
			String query = "select * from prvenstvo";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			while(rs.next()) {
				
				int godinaOdr = rs.getInt(1);
				String naziv = rs.getString(2);
				int dID = rs.getInt(3);
				int oID = rs.getInt(4);
				
				Prvenstvo prvenstvo = new Prvenstvo(godinaOdr, naziv, DrzavaUI.getDrzavaPoID(dID), DrzavaUI.getDrzavaPoID(oID));
				retVal.add(prvenstvo); 
			}
			
			st.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 

		return retVal;
	}

	public static Prvenstvo nadjiPrvenstvoPoGodini(Connection conn, int godina) {
		
		Prvenstvo retVal = null; 
		
		try {
			String query = "select * from prvenstvo where godina =" + godina;
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			while(rs.next()) {
				
			int prGod = rs.getInt(1);
			String prNaziv = rs.getString(2);
			int prDom = rs.getInt(3);
			int prOsv = rs.getInt(4);
			
			retVal = new Prvenstvo(prGod, prNaziv, DrzavaUI.getDrzavaPoID(prDom), DrzavaUI.getDrzavaPoID(prOsv));
				
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return retVal;
	}

}
