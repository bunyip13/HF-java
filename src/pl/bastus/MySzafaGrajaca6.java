import java.util.*;

import java.io.*;

public class MySzafaGrajaca6 {
	private ArrayList<Piosenka> listaPiosenek = new ArrayList<Piosenka>();

	public static void main(String... args) {
		MySzafaGrajaca6 szf = new MySzafaGrajaca6();
		szf.doDziela();
	}

	private class ArtystaCompare implements Comparator<Piosenka> {
		public int compare(Piosenka p1, Piosenka p2) {
			return p1.getArtysta().compareTo(p2.getArtysta());
		}
	}

	private class TytulCompare implements Comparator<Piosenka> {
		public int compare(Piosenka p1, Piosenka p2) {
			return p1.getTytul().compareTo(p2.getTytul());
		}
	}

	private class BPMCompare implements Comparator<Piosenka> {
		public int compare(Piosenka p1, Piosenka p2) {
			return p1.getBpm().compareTo(p2.getBpm());
		}
	}

	private class OcenaCompare implements Comparator<Piosenka> {
		public int compare(Piosenka p1, Piosenka p2) {
			return p1.getOcena().compareTo(p2.getOcena());
		}
	}

	public void doDziela() {
		pobierzPiosenki();
		System.out.print(listaPiosenek);

//		Collections.sort(listaPiosenek);
//		TytulCompare komparatorTytulow = new TytulCompare();
//		Collections.sort(listaPiosenek, komparatorTytulow);
//		System.out.print(listaPiosenek);

//		ArtystaCompare komparatorArtystow = new ArtystaCompare();
//		Collections.sort(listaPiosenek, komparatorArtystow);
//		System.out.println(listaPiosenek);

//		BPMCompare komparatorBPM = new BPMCompare();
//		Collections.sort(listaPiosenek, komparatorArtystow);
//		System.out.println(listaPiosenek);

//		OcenaCompare komparatorOcen = new OcenaCompare();
//		Collections.sort(listaPiosenek, komparatorArtystow);
//		System.out.println(listaPiosenek);

		Collections.sort(listaPiosenek, (Piosenka p1, Piosenka p2) -> p1.getTytul().compareTo(p2.getTytul()));
		Collections.sort(listaPiosenek, (Piosenka p1, Piosenka p2) -> p1.getArtysta().compareTo(p2.getArtysta()));
		Collections.sort(listaPiosenek, (Piosenka p1, Piosenka p2) -> p1.getOcena().compareTo(p2.getOcena()));
		Collections.sort(listaPiosenek, (Piosenka p1, Piosenka p2) -> p1.getBpm().compareTo(p2.getBpm()));

		for(Piosenka p : listaPiosenek){
			p.printSong();
		}

		HashSet<Piosenka> songHashList = new HashSet<>();
		songHashList.addAll(listaPiosenek);
//		System.out.println(songHashList + "\n");
//		System.out.println(songHashList);
		for(Piosenka p : songHashList){
			System.out.println(p);
		}

		/*
		 * Kolekcja HashSet posiada prostą metodę addAll(), która umożliwia
		 * przekazanie innej kolekcji i zapisanie w zbiorze wszystkich jej
		 * elementów. Efekt jest ten sam, jakbyśmy każdą piosenkę dodali osobno
		 */
	}

	private void pobierzPiosenki() {
		try {
			File plik;
			BufferedReader reader;
			String wiersz;

			plik = new File("y:\\Programowanie\\Tutorials\\ListaPiosenek.txt");
			reader = new BufferedReader(new FileReader(plik));
			wiersz = null;
			while ((wiersz = reader.readLine()) != null) {
				dodajPiosenke(wiersz);
			}
			reader.close();
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void dodajPiosenke(String wierszDoAnalizy) {
		String[] elementy = wierszDoAnalizy.split("/");
		Piosenka nastepnaPiosenka = new Piosenka(elementy[0], elementy[1], elementy[2], elementy[3]);
		listaPiosenek.add(nastepnaPiosenka);
	}
}