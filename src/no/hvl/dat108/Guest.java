package no.hvl.dat108;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(schema = "oblig3", name = "guest")
public class Guest {

	@Id
	private String mobil;
	private String passord;
	private String fornavn;
	private String etternavn;
	private char kjonn;
	
	
	public String getMobil() {
		return mobil;
	}
	public String getPassord() {
		return passord;
	}
	public String getFornavn() {
		return fornavn;
	}
	public String getEtternavn() {
		return etternavn;
	}
	
	public String getDeltager() {
		return getFornavn() + " " + getEtternavn(); 
	}
	public char getKjonn() {
		return kjonn;
	}
	public void setMobil(String mobil) {
		this.mobil = mobil;
	}
	public void setPassord(String passord) {
		this.passord = passord;
	}
	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}
	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}
	public void setKjonn(char kjonn) {
		this.kjonn = kjonn;
	}
	
	@Override
	public String toString() {
		return "Guest [mobil=" + mobil + ", passord=" + passord + ", fornavn=" + fornavn + ", etternavn="
				+ etternavn + ", kjonn=" + kjonn + "]";
	}
	

	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name="klasse_kode", referencedColumnName = "kode") private Klasse
	 * klasse;
	 */

}