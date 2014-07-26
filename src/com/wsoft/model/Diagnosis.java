package com.wsoft.model;

import java.io.Serializable;

public class Diagnosis extends BaseModel implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3462983009535254015L;
	private Long idDijagnoze;
	private String nazivDijagnoze;
	public Long getIdDijagnoze() {
		return idDijagnoze;
	}
	public void setIdDijagnoze(Long idDijagnoze) {
		this.idDijagnoze = idDijagnoze;
	}
	public String getNazivDijagnoze() {
		return nazivDijagnoze;
	}
	public void setNazivDijagnoze(String nazivDijagnoze) {
		this.nazivDijagnoze = nazivDijagnoze;
	}
	public Diagnosis(){
		
	}
	
	@Override
	public String toString(){
		return this.nazivDijagnoze;
	}
}
