package fakultet;

import java.text.SimpleDateFormat;
import java.util.Scanner;

import fakultet.Predmet;
import fakultet.Student;
import fakultet.Prijava;

public class Main {
	
	public static Scanner in;
	public static final Student[] studenti = new Student[8];
	public static final Predmet[] predmeti = new Predmet[5];

	public static void main(String[] args) {
		
		Predmet p0 = new Predmet(1122, "Politicka ekonomija");
		Predmet p1 = new Predmet(1133, "Osnovi prava");
		Predmet p2 = new Predmet(2244, "Filozofija");
		Predmet p3 = new Predmet(2255, "Sociologija");
		Predmet p4 = new Predmet(3377, "Medjunarodni odnosi");
		
		predmeti[0] = p0;
		predmeti[1] = p1;
		predmeti[2] = p2;
		predmeti[3] = p3;
		predmeti[4] = p4;

	    
		Student s0 = new Student("FPN0001", 2019, "Kata", "Katic", new SimpleDateFormat("17.08.1997."));
		Student s1 = new Student("FPN0002", 2018, "Sima", "Simic", new SimpleDateFormat("17.03.1996."));
		Student s2 = new Student("FPN0003", 2017, "Nikola", "Nikolic", new SimpleDateFormat("11.05.1998."));
		Student s3 = new Student("FPN0004", 2019, "Stefan", "Stefanovic", new SimpleDateFormat("13.09.1997."));
		Student s4 = new Student("FPN0005", 2018, "Ivana", "Ivanoic", new SimpleDateFormat("16.02.1996."));
		Student s5 = new Student("FPN0006", 2017, "Zorana", "Zoric", new SimpleDateFormat("10.08.1995."));
		Student s6 = new Student("FPN0007", 2016, "Miloš", "Miloševic", new SimpleDateFormat("08.12.1997."));
		Student s7 = new Student("FPN0001", 2017, "Kata", "Katic", new SimpleDateFormat("22.11.1997."));
		
		studenti[0] = s0;
		studenti[1] = s1;
		studenti[2] = s2;
		studenti[3] = s3;
		studenti[4] = s4;
		studenti[5] = s5;
		studenti[6] = s6;
		studenti[7] = s7;
		
		
		boolean nastavakPetlje = true;
		
		in = new Scanner(System.in);
		
		while (nastavakPetlje) {
			System.out.println("1. Pregled\n2. Unos nove prijave\n3. Izmena\n4. Kraj programa.\nIzaberite opciju:");
			int opcija = in.nextInt();
			
			switch (opcija) {
			
			case 1:
				System.out.println(' ');
				System.out.println("a. Pregled svih predmeta\nb. Pregled svih studenata\nc. "
						+ "Pregled svih prijava za trazenog studenta\nd. Pregled svih studenata koji su polozili odredjeni predmet\ne. Povratak u glavni meni\nIzaberite opciju:");
				String podopcija = in.next();
				
				switch (podopcija) {
				case "a":
					pregledPredmeta();
					break;
				case "b":
					pregledStudenata();
					break;
				case "c":
					System.out.println("Unesite broj indeksa:");
					String brojIndeksa = in.next();
					pregledSvihPrijava(brojIndeksa);
					break;
				case "d":
					System.out.println("Unesite sifru predmeta:");
					int sifraPredmeta = in.nextInt();
					pregledStudenataKojiSuPolozili(sifraPredmeta);
					break;
				case "e":
					break;
				}
				break;
				
				
			case 2:
				System.out.println("Unesite sifru predmeta: ");
				int sifraPredmeta = in.nextInt();
				System.out.println("Unesite naziv predmeta: ");
				String nazivPredmeta = in.next();
				System.out.println("Unesite broj indeksa: ");
				String brojIndeksa = in.next();
				System.out.println("Unesite ocenu: ");
				int ocena = in.nextInt();
				Prijava novaPrijava = new Prijava(sifraPredmeta, nazivPredmeta, brojIndeksa, ocena);
				Predmet prijavljenPredmet = null;
				Student studentPolozio = null;
				for (int i = 0; i < predmeti.length; i++) {
					if (sifraPredmeta == predmeti[i].getSifraPredmeta()) {
						prijavljenPredmet = predmeti[i];
					}
				}
				for (int i = 0; i < studenti.length; i++) {
					if (brojIndeksa.equals(studenti[i].getBrojIndeksa())) {
						studentPolozio = studenti[i];
					}
				}
				if (ocena > 5) {
					for (int i = 0; i < predmeti.length; i++) {
						if (prijavljenPredmet.equals(predmeti[i])) {
							predmeti[i].getStudentiKojiSuPolozili().add(studentPolozio);
						}
					}
				}
				for (int i = 0; i < studenti.length; i++) {
					if (studentPolozio.equals(studenti[i])) {
						studenti[i].getPrijavljeniIspiti().add(prijavljenPredmet);
					}
				}
				break;
				
			case 3:
				System.out.println("a. Izmena podataka o studentu\nb. Povratak u glavni meni\nIzaberite opciju:");
				String podopcija2 = in.next();
				
				switch(podopcija2) {
				case "a":
					System.out.println("Izaberite zeljenog studenta. Unesite broj indeksa:");
					String brojIndeksa2 = in.next();
					Student studentIzmena = null;
					for (int i = 0; i < studenti.length; i++) {
						if (brojIndeksa2.equals(studenti[i].getBrojIndeksa())) {
							studentIzmena = studenti[i];
						}
					}
					if(studentIzmena != null) {
						System.out.println("Unesite godinu upisa:");
						studentIzmena.setGodinaUpisa(in.nextInt());
					System.out.println("Unesite ime:");
					studentIzmena.setIme(in.next());
					System.out.println("Unesite prezime:");
					studentIzmena.setPrezime(in.next());
					System.out.println("Unesite datum rodjenja:");
					
					}
				}
				break;
			case 4:
				nastavakPetlje = false;
				System.out.println("---KRAJ PROGRAMA---");
				break;
			
			
			}
		}
		
	
	}	
	
	public static void pregledPredmeta() {
		for (int i = 0; i < predmeti.length; i++) {
			System.out.println((i+1) + ". " + predmeti[i]);
		}
		System.out.println(' ');
	}
	
	
	public static void pregledStudenata() {
		for (int i = 0; i < studenti.length; i++) {
			System.out.println((i+1) + ". " + studenti[i]);
		}
		System.out.println(' ');
	}
	
	public static void pregledSvihPrijava(String brojIndeksa) {
		for (int i = 0; i < studenti.length; i++) {
			if (brojIndeksa.equals(studenti[i].getBrojIndeksa())) {
				System.out.println(studenti[i].getPrijavljeniIspiti());
			}
		}
	}

	public static void pregledStudenataKojiSuPolozili(int sifraPredmeta) {
		for (int i = 0; i < predmeti.length; i++) {
			if(sifraPredmeta == predmeti[i].getSifraPredmeta()) {
				System.out.println(predmeti[i].getStudentiKojiSuPolozili());
			}			
		}
	}
	
	
    public static void unosNovePrijave(int sifraPredmeta, String brojIndeksa, SimpleDateFormat datumPolaganja, int ocena) {
		
	}
	
	public static void izmenaPodatakaOStudentu(Student student) {

	}
}
