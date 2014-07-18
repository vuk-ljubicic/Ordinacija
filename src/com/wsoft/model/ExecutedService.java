package com.wsoft.model;

import java.io.Serializable;
import java.util.Date;

public class ExecutedService extends BaseModel implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6669899737167179785L;
	
	private Long idPac;
	private Date datum;
	private Long idZuba;
	private Long dijagnoza;
	private Long usluga;
	private Long materijal;
	private String povrsine;
	private String napomena;
	private Long idStom;
	
	public Long getIdPac() {
		return idPac;
	}
	public void setIdPac(Long idPac) {
		this.idPac = idPac;
	}
	public Date getDatum() {
		return datum;
	}
	public void setDatum(Date datum) {
		this.datum = datum;
	}
	public Long getIdZuba() {
		return idZuba;
	}
	public void setIdZuba(Long idZuba) {
		this.idZuba = idZuba;
	}
	public Long getDijagnoza() {
		return dijagnoza;
	}
	public void setDijagnoza(Long dijagnoza) {
		this.dijagnoza = dijagnoza;
	}
	public Long getUsluga() {
		return usluga;
	}
	public void setUsluga(Long usluga) {
		this.usluga = usluga;
	}
	public Long getMaterijal() {
		return materijal;
	}
	public void setMaterijal(Long materijal) {
		this.materijal = materijal;
	}
	public String getPovrsine() {
		return povrsine;
	}
	public void setPovrsine(String povrsine) {
		this.povrsine = povrsine;
	}
	public String getNapomena() {
		return napomena;
	}
	public void setNapomena(String napomena) {
		this.napomena = napomena;
	}
	public Long getIdStom() {
		return idStom;
	}
	public void setIdStom(Long idStom) {
		this.idStom = idStom;
	}
	
	public ExecutedService(){
		
	}
}
