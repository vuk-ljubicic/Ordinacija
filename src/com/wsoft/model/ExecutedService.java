package com.wsoft.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.time.DateUtils;

public class ExecutedService extends BaseModel implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6669899737167179785L;
	
	protected Long idPac;
	protected long increment;
	protected Date datum = new Date();
	protected Long idZuba = new java.lang.Long(0);
	protected Long dijagnoza= new java.lang.Long(0);
	protected Long usluga= new java.lang.Long(0);
	protected Long materijal= new java.lang.Long(0);
	protected String povrsine = "";
	public long getIncrement() {
		return increment;
	}
	public void setIncrement(long increment) {
		this.increment = increment;
	}

	protected String napomena = "";
	protected Long idStom = new java.lang.Long(0);
	
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
