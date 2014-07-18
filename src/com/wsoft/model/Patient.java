package com.wsoft.model;

import java.io.Serializable;
import java.util.Date;

public class Patient extends BaseModel implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5494815622751243498L;
	private Long idPac;
	private Date datUp = new java.util.Date();
	private String prez;
	private String ime;
	private Long godRod = new Long(0);
	private String zan;
	private String adr;
	private String telSlu;
	private String telPri;
	private String telMob;
	private String pager;
	private Boolean akutOb = new Boolean(false);
	private String akutObNap;
	private Boolean alerg = new Boolean(false);
	private String alergNap;
	private Boolean hroOb = new Boolean(false);
	private String hroObNap;
	private Boolean lek = new Boolean(false);
	private String lekNap;
	private Boolean rtg = new Boolean(false);
	private Boolean opt = new Boolean(false);
	private Boolean teleRtg = new Boolean(false);
	private Boolean maksSin = new Boolean(false);
	private Boolean vilZglob = new Boolean(false);
	private String licniBroj;
	private String napomena;
	
	public Patient(){
		
	}
	
	public Long getIdPac() {
		return idPac;
	}
	public void setIdPac(Long idPac) {
		this.idPac = idPac;
	}
	public Date getDatUp() {
		return datUp;
	}
	public void setDatUp(Date datUp) {
		this.datUp = datUp;
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
	public Long getGodRod() {
		return godRod;
	}
	public void setGodRod(Long godRod) {
		this.godRod = godRod;
	}
	public String getZan() {
		return zan;
	}
	public void setZan(String zan) {
		this.zan = zan;
	}
	public String getAdr() {
		return adr;
	}
	public void setAdr(String adr) {
		this.adr = adr;
	}
	public String getTelSlu() {
		return telSlu;
	}
	public void setTelSlu(String telSlu) {
		this.telSlu = telSlu;
	}
	public String getTelPri() {
		return telPri;
	}
	public void setTelPri(String telPri) {
		this.telPri = telPri;
	}
	public String getTelMob() {
		return telMob;
	}
	public void setTelMob(String telMob) {
		this.telMob = telMob;
	}
	public String getPager() {
		return pager;
	}
	public void setPager(String pager) {
		this.pager = pager;
	}
	public Boolean getAkutOb() {
		return akutOb;
	}
	public void setAkutOb(Boolean akutOb) {
		this.akutOb = akutOb;
	}
	public String getAkutObNap() {
		return akutObNap;
	}
	public void setAkutObNap(String akutObNap) {
		this.akutObNap = akutObNap;
	}
	public Boolean getAlerg() {
		return alerg;
	}
	public void setAlerg(Boolean alerg) {
		this.alerg = alerg;
	}
	public String getAlergNap() {
		return alergNap;
	}
	public void setAlergNap(String alergNap) {
		this.alergNap = alergNap;
	}
	public Boolean getHroOb() {
		return hroOb;
	}
	public void setHroOb(Boolean hroOb) {
		this.hroOb = hroOb;
	}
	public String getHroObNap() {
		return hroObNap;
	}
	public void setHroObNap(String hroObNap) {
		this.hroObNap = hroObNap;
	}
	public Boolean getLek() {
		return lek;
	}
	public void setLek(Boolean lek) {
		this.lek = lek;
	}
	public String getLekNap() {
		return lekNap;
	}
	public void setLekNap(String lekNap) {
		this.lekNap = lekNap;
	}
	public Boolean getRtg() {
		return rtg;
	}
	public void setRtg(Boolean rtg) {
		this.rtg = rtg;
	}
	public Boolean getOpt() {
		return opt;
	}
	public void setOpt(Boolean opt) {
		this.opt = opt;
	}
	public Boolean getTeleRtg() {
		return teleRtg;
	}
	public void setTeleRtg(Boolean teleRtg) {
		this.teleRtg = teleRtg;
	}
	public Boolean getMaksSin() {
		return maksSin;
	}
	public void setMaksSin(Boolean maksSin) {
		this.maksSin = maksSin;
	}
	public Boolean getVilZglob() {
		return vilZglob;
	}
	public void setVilZglob(Boolean vilZglob) {
		this.vilZglob = vilZglob;
	}
	public String getLicniBroj() {
		return licniBroj;
	}
	public void setLicniBroj(String licniBroj) {
		this.licniBroj = licniBroj;
	}
	public String getNapomena() {
		return napomena;
	}
	public void setNapomena(String napomena) {
		this.napomena = napomena;
	}
}
