package com.wsoft.model;

import java.io.Serializable;

public class Service extends BaseModel implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7071175510597040410L;
	private Long idUsl;
	private String nazUsl; 
	
	public Service(){
		
	}
	
	public Long getIdUsl() {
		return idUsl;
	}
	public void setIdUsl(Long idUsl) {
		this.idUsl = idUsl;
	}
	public String getNazUsl() {
		return nazUsl;
	}
	public void setNazUsl(String nazUsl) {
		this.nazUsl = nazUsl;
	}
	
	@Override
	public String toString(){
		return this.nazUsl;
	}
}
