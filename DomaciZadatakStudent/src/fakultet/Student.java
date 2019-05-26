package fakultet;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


public class Student {
	
	String brojIndeksa;
	int godinaUpisa;
	String ime;
	String prezime;
	SimpleDateFormat datumRodjenja;
	private List<Predmet> prijavljeniIspiti = new ArrayList<>();

	

	public Student(String brojIndeksa, int godinaUpisa, String ime, String prezime, SimpleDateFormat datumRodjenja) {
		this.brojIndeksa = brojIndeksa;
		this.godinaUpisa = godinaUpisa;
		this.ime = ime;
		this.prezime = prezime;
		this.datumRodjenja = datumRodjenja;
	}
	public SimpleDateFormat getDatumRodjenja() {
		return datumRodjenja;
	}
	public void setDatumRodjenja(SimpleDateFormat datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}
	public String getBrojIndeksa() {
		return brojIndeksa;
	}
	public void setBrojIndeksa(String brojIndeksa) {
		this.brojIndeksa = brojIndeksa;
	}
	public int getGodinaUpisa() {
		return godinaUpisa;
	}
	public void setGodinaUpisa(int godinaUpisa) {
		this.godinaUpisa = godinaUpisa;
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
	
	public void prijaviIspit(Predmet ispit) {
		prijavljeniIspiti.add(ispit);
	}
	
	public List<Predmet> getPrijavljeniIspiti() {
		return prijavljeniIspiti;
	}
	public void setPrijavljeniIspiti(List<Predmet> prijavljeniIspiti) {
		this.prijavljeniIspiti = prijavljeniIspiti;
	}
	
	@Override
	public int hashCode() {		
		final int prime = 31;
		int result = 1;
		result = prime * result + ((brojIndeksa == null) ? 0 : brojIndeksa.hashCode());
		return result;
		
	}
	@Override
	public String toString() {
		return new StringBuilder().append("Broj indeksa: ").append(this.brojIndeksa).append("; Godina upisa: ").append(this.godinaUpisa).append("; Ime: ").append(this.ime).append("; Prezime: ").append(this.prezime).append("; DatumRodjenja: ").append(this.datumRodjenja).toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (brojIndeksa == null) {
			if (other.brojIndeksa != null)
				return false;
		} else if (!brojIndeksa.equals(other.brojIndeksa))
			return false;
		return true;
			
	}
	
	
	
	

}
