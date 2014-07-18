package com.wsoft.model;

import java.io.Serializable;

public class Material  extends BaseModel implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8186430613655743581L;
	private Long idMat;
	private String nazMat;
	
	public Material(){
		
	}
	
	public Long getIdMat() {
		return idMat;
	}
	public void setIdMat(Long idMat) {
		this.idMat = idMat;
	}
	public String getNazMat() {
		return nazMat;
	}
	public void setNazMat(String nazMat) {
		this.nazMat = nazMat;
	}
	
}
