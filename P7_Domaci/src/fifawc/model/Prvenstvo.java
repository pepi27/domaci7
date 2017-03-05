package fifawc.model;

import java.util.ArrayList;

public class Prvenstvo {

	private int godinaOdrzavanja; 
	private String nazivPrvenstva; 
	private Drzava drzavaOsvajac, drzavaDomacin;
	
	public Prvenstvo() {
	}

	public Prvenstvo(int godinaOdrzavanja, String nazivPrvenstva, Drzava drzavaDomacin, Drzava drzavaOsvajac) {
		super();
		this.godinaOdrzavanja = godinaOdrzavanja;
		this.nazivPrvenstva = nazivPrvenstva;
		this.drzavaDomacin = drzavaDomacin;
		this.drzavaOsvajac = drzavaOsvajac;
	}

	public int getGodinaOdrzavanja() {
		return godinaOdrzavanja;
	}

	public void setGodinaOdrzavanja(int godinaOdrzavanja) {
		this.godinaOdrzavanja = godinaOdrzavanja;
	}

	public String getNazivPrvenstva() {
		return nazivPrvenstva;
	}

	public void setNazivPrvenstva(String nazivPrvenstva) {
		this.nazivPrvenstva = nazivPrvenstva;
	}

	public Drzava getDrzavaOsvajac() {
		return drzavaOsvajac;
	}

	public void setDrzavaOsvajac(Drzava drzavaOsvajac) {
		this.drzavaOsvajac = drzavaOsvajac;
	}

	public Drzava getDrzavaDomacin() {
		return drzavaDomacin;
	}

	public void setDrzavaDomacin(Drzava drzavaDomacin) {
		this.drzavaDomacin = drzavaDomacin;
	}

	@Override
	public String toString() {
		return "Prvenstvo [godinaOdrzavanja=" + godinaOdrzavanja + ", nazivPrvenstva=" + nazivPrvenstva
				+ ", Domacin=" + drzavaDomacin + ", Osvajac=" + drzavaOsvajac + "]";
	}
	
}
