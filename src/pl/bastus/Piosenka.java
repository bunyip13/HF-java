package pl.bastus;

import com.sun.istack.internal.NotNull;

class Piosenka {
	private String tytul;
	private String artysta;
	private String ocena;
	private String bpm;

	/*
	public int compareTo(Piosenka p) {
		return tytul.compareTo(p.getTytul());
	}
	*/

	@Override
	public boolean equals(Object piosenka) throws ClassCastException {
		if piosenka instanceof Piosenka {
			Piosenka p = (Piosenka) piosenka;
			return getTytul().equals(p.getTytul());
		}
	}

	public int hashCode() {
		return tytul.hashCode();
	}

	Piosenka(String t, String a, String o, String b) {
		tytul = t;
		artysta = a;
		ocena = o;
		bpm = b;
	}

	void printSong() {
		System.out.println("" + getArtysta() + " - " + getTytul() + ", " + getOcena() + ", " + getBpm());
	}

	String getTytul() {
		return tytul;
	}

	String getArtysta() {
		return artysta;
	}

	String getOcena() {
		return ocena;
	}

	String getBpm() {
		return bpm;
	}

	@Override
	public String toString() {
		return tytul;
	}
}