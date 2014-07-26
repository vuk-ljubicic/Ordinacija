package com.wsoft.model;

import java.io.Serializable;

public class Dentist extends BaseModel implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7178998652752890468L;

	public Dentist(){
		
	}
	
	private Long idStom;
	private String prez;
	private String ime;
	private String titula;
	
	public Long getIdStom() {
		return idStom;
	}
	public void setIdStom(Long idStom) {
		this.idStom = idStom;
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
	public String getTitula() {
		return titula;
	}
	public void setTitula(String titula) {
		this.titula = titula;
	}
	
	@Override
	public String toString(){
		return this.ime+" "+this.prez;
	}
}
