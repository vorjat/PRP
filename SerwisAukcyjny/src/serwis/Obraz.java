package serwis;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Obraz {
	private final SimpleStringProperty tytul;
	private final SimpleStringProperty autor;
	private final SimpleStringProperty ksztalt;
	private final SimpleStringProperty wysokosc;
	private final SimpleStringProperty szerokosc;
	private final SimpleStringProperty promien;
	private final SimpleStringProperty powierzchnia;
	private final SimpleStringProperty waga;
	private final SimpleStringProperty cena;

	Obraz(String tytul, String autor, String ksztalt, String wysokosc, String szerokosc, String promien,
			String powierzchnia, String waga, String cena) {
		this.tytul = new SimpleStringProperty(tytul);
		this.autor = new SimpleStringProperty(autor);
		this.ksztalt = new SimpleStringProperty(ksztalt);
		this.wysokosc = new SimpleStringProperty(wysokosc);
		this.szerokosc = new SimpleStringProperty(szerokosc);
		this.promien = new SimpleStringProperty(promien);
		this.powierzchnia = new SimpleStringProperty(powierzchnia);
		this.waga = new SimpleStringProperty(waga);
		this.cena = new SimpleStringProperty(cena);
	}


	public String getTytul() {
		return tytul.get();
	}

	public void setTytul(String s) {
		tytul.set(s);
	}
	public String getAutor() {
		return autor.get();
	}

	public void setAutor(String s) {
		autor.set(s);
	}
	public String getKsztalt() {
		return ksztalt.get();
	}

	public void setKsztalt(String s) {
		ksztalt.set(s);
	}
	public String getWysokosc() {
		return wysokosc.get();
	}

	public void setWysokosc(String s) {
		wysokosc.set(s);
	}
	public String getSzerokosc() {
		return szerokosc.get();
	}

	public void setSzerokosc(String s) {
		szerokosc.set(s);
	}
	public String getPromien() {
		return promien.get();
	}

	public void setPromien(String s) {
		promien.set(s);
	}
	public String getPowierzchnia() {
		return powierzchnia.get();
	}

	public void setPowierzchnia(String s) {
		powierzchnia.set(s);
	}
	public String getWaga() {
		return waga.get();
	}

	public void setWaga(String s) {
		waga.set(s);
	}
	public String getCena() {
		return cena.get();
	}

	public void setCena(String s) {
		cena.set(s);
	}
}