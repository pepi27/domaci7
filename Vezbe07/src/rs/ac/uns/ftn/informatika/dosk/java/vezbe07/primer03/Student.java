package rs.ac.uns.ftn.informatika.dosk.java.vezbe07.primer03;

public class Student {
	protected int id;
	protected String ime;
	protected String prezime;
	protected String indeks;
	protected String mesto;
	
	public Student() {
	}
	
	public Student(int id, String indeks, 
			String ime, String prezime, String mesto) {
		this.id = id;
		this.indeks = indeks;
		this.ime = ime;
		this.prezime = prezime;
		this.mesto = mesto; 
	}
	
	//prebacivanje objekta Student u string reprezentaciju
	@Override
	public String toString() {
		String s = "Student [" + indeks + " " + 
				ime + " " + prezime + " " + mesto + "]";
		return s;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getIndeks() {
		return indeks;
	}
	public void setIndeks(String index) {
		this.indeks = index;
	}

	public String getMesto() {
		return mesto;
	}

	public void setMesto(String mesto) {
		this.mesto = mesto;
	}
	
	
}
