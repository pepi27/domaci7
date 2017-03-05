package fifawc.model;

public class Drzava {

	private int id; 
	private String nazivDrzave; 
	
	public Drzava() {}
	
	public Drzava(int id, String nazivDrzave) {
		this.id = id; 
		this.nazivDrzave = nazivDrzave;
	}

	public String getNazivDrzave() {
		return nazivDrzave;
	}

	public void setNazivDrzave(String nazivDrzave) {
		this.nazivDrzave = nazivDrzave;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Drzava [id =" + id + ", Ime =" + nazivDrzave + "]";
	}
	
	
}
