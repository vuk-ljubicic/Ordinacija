package com.wsoft.model.custom;

import com.wsoft.model.ExecutedService;

public class ExecutedServicesCustom extends ExecutedService{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String nazivDijagnoze;
	protected String prez;
	protected String ime;
	protected String nazMat;
	public String getNazivDijagnoze() {
		return nazivDijagnoze;
	}
	public void setNazivDijagnoze(String nazivDijagnoze) {
		this.nazivDijagnoze = nazivDijagnoze;
	}
	public String getPrez() {
		return prez;
	}
	public void setPrez(String prez) {
		this.prez = prez;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getNazMat() {
		return nazMat;
	}
	public void setNazMat(String nazMat) {
		this.nazMat = nazMat;
	}
	public String getNazUsl() {
		return nazUsl;
	}
	public void setNazUsl(String nazUsl) {
		this.nazUsl = nazUsl;
	}
	protected String nazUsl;
}
