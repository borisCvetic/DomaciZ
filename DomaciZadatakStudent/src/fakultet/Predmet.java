package fakultet;

import java.util.ArrayList;
import java.util.List;

public class Predmet {
	
	
	int sifraPredmeta;
	String nazivPredmeta;
	private List<Student> studentiKojiSuPolozili = new ArrayList<>();
	
	
	public Predmet(int sifraPredmeta, String nazivPredmeta) {
		this.sifraPredmeta = sifraPredmeta;
		this.nazivPredmeta = nazivPredmeta;
	}
	public int getSifraPredmeta() {
		return sifraPredmeta;
	}
	public void setSifraPredmeta(int sifraPredmeta) {
		this.sifraPredmeta = sifraPredmeta;
	}
	public String getNazivPredmeta() {
		return nazivPredmeta;
	}
	public void setNazivPredmeta(String nazivPredmeta) {
		this.nazivPredmeta = nazivPredmeta;
	}
	
	public List<Student> getStudentiKojiSuPolozili() {
		return studentiKojiSuPolozili;
	}
	
	public void setStudentiKojiSuPolozili(List<Student> studentiKojiSuPolozili) {
		this.studentiKojiSuPolozili = studentiKojiSuPolozili;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + sifraPredmeta;
		return result;
	
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Predmet other = (Predmet) obj;
		if (sifraPredmeta != other.sifraPredmeta)
			return false;
		return true;
			
	}
	
	@Override
	public String toString() {
		return new StringBuilder().append("Sifra predmeta: ").append(this.sifraPredmeta).append("; Naziv predmeta: ").append(this.nazivPredmeta).toString();		
	}

}
