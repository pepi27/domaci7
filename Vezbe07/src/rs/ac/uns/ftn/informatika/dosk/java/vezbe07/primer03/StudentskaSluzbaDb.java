package rs.ac.uns.ftn.informatika.dosk.java.vezbe07.primer03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class StudentskaSluzbaDb {

	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		try {
			// ucitavanje MySQL drajvera
			Class.forName("com.mysql.jdbc.Driver");		
			// Konekcija na bazu
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/studentskasluzba", 
					"root", "eEflakjv39fE!fjd");

			
			//prikaz menija
			String odluka = "";
			while (!odluka.equals("x")) {
				ispisiMenu();
				System.out.print("opcija:");
				odluka = scanner.nextLine();
				switch (odluka) {				
					case "1":
						prikaziSveStudente(conn);
						break;
					case "2":
						unosStudenta(conn);
						break;
					case "3":
						pronadjiStudentaPoIndeksu(conn);
						break;	
					case "4":
						izmeniStudenta(conn);
						break;	
					case "x":
						System.out.println("Izlaz");
						break;
					default:
						System.out.println("Nepostojeca komanda");
						break;
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static void izmeniStudenta(Connection conn) {
		List<Student> studenti = new ArrayList<Student>();
		
		System.out.println();
		
		try {
			String query = "SELECT student_id, indeks, " +
					"ime, prezime, naziv FROM studenti LEFT JOIN grad on studenti.student_ptt = grad.ptt";
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery(query); //preuzimamo studente iz baze
			while (rset.next()) { 
				int id = rset.getInt(1);
				String indeks = rset.getString(2);
				String ime = rset.getString(3);
				String prezime = rset.getString(4);		
				String mesto = rset.getString(5);
				//kreiramo objekat u memoriji na osnovu preuzetog sloga iz baze
				Student student = new Student(id, indeks, ime, prezime, mesto);
				studenti.add(student); //dodamo objekat Student u listu svih studenata
			}
			rset.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// sada imamo napunjenu listu studenata u memoriji 
		// Prolazimo kroz listu i ispisujemo podatke o svakom studentu
		for (Student s: studenti) {
			System.out.println(s.id + ". " + s);
		}

		System.out.println("\nOdaberi studenta za izmenu : \n");
		
		int odluka = scanner.nextInt();
		scanner.nextLine();
		 
		for(Student s : studenti) {
			if(odluka != s.getId()) {
				
				continue; 
			} else {
				System.out.print("Unesi indeks:");
				String stIndex = scanner.nextLine();
				System.out.print("Unesi ime:");
				String stIme = scanner.nextLine();
				System.out.print("Unesi prezime:");
				String stPrezime = scanner.nextLine();
				System.out.print("Unesi postanski broj:");
				String stPtt = scanner.nextLine();
				
				try {
					String updateQery = "UPDATE studenti"
							+ " SET indeks='" + stIndex + "', ime='" + stIme + "', prezime='" + stPrezime + "', student_ptt='" + stPtt +"'"  
							+ " WHERE student_id=" + odluka;
					Statement st = conn.createStatement();
					st.executeUpdate(updateQery);

					
				} catch (SQLException sex) {
					sex.printStackTrace();
				}
				
			} 
				
		}
		
		
	}

	private static void pronadjiStudentaPoIndeksu(Connection conn) {
		System.out.println("Unesite indeks");
		String indeks = scanner.nextLine();
		try{
		
			String query = "SELECT * FROM studenti WHERE indeks = " + "'" + indeks + "'";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				System.out.println("Student je " + rs.getString(3) + " " + rs.getString(4));
			}
			
			st.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	// ispis teksta osnovnih opcija
	private static void ispisiMenu() {
		System.out.println("Studentska Sluzba - Meni:");
		System.out.println("\t1 - Spisak studenata");
		System.out.println("\t2 - Unos studenta");
		System.out.println("\t3 - Pronadji studenta po broju indeksa");
		System.out.println("\t4 - Izmeni studenta");
		System.out.println("\tx - IZLAZ IZ PROGRAMA");
	}
	
	private static void prikaziSveStudente(Connection conn) {
		List<Student> studenti = new ArrayList<Student>(); //lista studenata u memoriji
		try {
			String query = "SELECT student_id, indeks, " +
					"ime, prezime, naziv FROM studenti LEFT JOIN grad on studenti.student_ptt = grad.ptt";
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery(query); //preuzimamo studente iz baze
			while (rset.next()) { 
				int id = rset.getInt(1);
				String indeks = rset.getString(2);
				String ime = rset.getString(3);
				String prezime = rset.getString(4);		
				String mesto = rset.getString(5);
				//kreiramo objekat u memoriji na osnovu preuzetog sloga iz baze
				Student student = new Student(id, indeks, ime, prezime, mesto);
				studenti.add(student); //dodamo objekat Student u listu svih studenata
			}
			rset.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// sada imamo napunjenu listu studenata u memoriji 
		// Prolazimo kroz listu i ispisujemo podatke o svakom studentu
		for (Student s: studenti) {
			System.out.println(s);
		}
	}
	
	private static void unosStudenta(Connection conn) {
		System.out.print("Unesi indeks:");
		String stIndex = scanner.nextLine();
		System.out.print("Unesi ime:");
		String stIme = scanner.nextLine();
		System.out.print("Unesi prezime:");
		String stPrezime = scanner.nextLine();
		System.out.print("Unesi postanski broj:");
		String stPtt = scanner.nextLine();
		//kreiramo objekat student u memoriji
		Student student = new Student(0, stIndex, stIme, stPrezime, stPtt);
		//sadrzaj objekta ubacimo u bazu podataka
		try {
			String insert = "INSERT INTO studenti " +
					"(indeks, ime, prezime, student_ptt) values " +
					"(?, ?, ?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(insert);
			pstmt.setString(1, student.getIndeks());
			pstmt.setString(2, student.getIme());
			pstmt.setString(3, student.getPrezime());
			pstmt.setString(4, student.getMesto());
			
			
			if (pstmt.executeUpdate() == 1) {
				System.out.println("Student je uspesno dodan.");
			} else {
				System.out.println("Greska pri dodavanju studenta.");
			}
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
