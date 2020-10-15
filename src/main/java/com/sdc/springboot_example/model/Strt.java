package com.sdc.springboot_example.model;

import javax.persistence.*;


/**
 * The persistent class for the strt database table.
 * 
 */
@Entity
@Table(name = "strt")
//@NamedQuery(name="Strt.findAll", query="SELECT s FROM Strt s")
//@NamedQuery(name="Strt.findById", query="SELECT s FROM Strt s where s.id.idno = ?1 and s.id.tail = ?2")
@NamedQuery(name="Strt.findByIdno", query="SELECT s FROM Strt s where s.id.idno = ?1")
public class Strt {
    
    /**
    * {@inheritDoc}
    */
    @Override
    public String toString() {
    
        return String.format("STRT: IDNO = %d, TAIL = %d, HEAD = %d, LENG = %f, SPED = %f"
                , id.getIdno(), id.getTail(), head, leng, sped);
        
    }
    
	@EmbeddedId
	private StrtPK id;

	private Double assg;

	private Double brdg;

	private Double capa;

	private Double cont;

	private Double cycl;

	private Double daut;

	private Double dbik;

	private Double dbus;

	private Double dcrp;

	private Double ddel;

	private Double demr;

	private Double disa;

	private Double dmot;

	private Double dped;

	private Double dtax;

	private Double dtrain;

	private Double dtram;

	private Double dtru;

	private Double dvdr;

	private Double fery;

	private Double fow;

	private Double fron;

	private Double gren;

	private Integer head;

	private Integer hier;

	private Double intr;

	private Double itim;

	private Double jden;

	private Double jwav;

	private Double leng;

	private String metadata;

	private Double mnvr;

	private String name;

	private Integer nlan;

	private Double npav;

	private Double nthr;

	private Double ocap;

	private Double open;

	private Double park;

	private Double prio;

	private Double ramp;

	private Double rdbt;

	private Integer refe;

	private String shap;

	private Double spdc;

	private Double sped;

	private Double toll;

	private Double tunn;

	private Double undt;

	private Double urbn;

	public Strt() {
	}

	public StrtPK getId() {
		return this.id;
	}

	public void setId(StrtPK id) {
		this.id = id;
	}

	public Double getAssg() {
		return this.assg;
	}

	public void setAssg(Double assg) {
		this.assg = assg;
	}

	public Double getBrdg() {
		return this.brdg;
	}

	public void setBrdg(Double brdg) {
		this.brdg = brdg;
	}

	public Double getCapa() {
		return this.capa;
	}

	public void setCapa(Double capa) {
		this.capa = capa;
	}

	public Double getCont() {
		return this.cont;
	}

	public void setCont(Double cont) {
		this.cont = cont;
	}

	public Double getCycl() {
		return this.cycl;
	}

	public void setCycl(Double cycl) {
		this.cycl = cycl;
	}

	public Double getDaut() {
		return this.daut;
	}

	public void setDaut(Double daut) {
		this.daut = daut;
	}

	public Double getDbik() {
		return this.dbik;
	}

	public void setDbik(Double dbik) {
		this.dbik = dbik;
	}

	public Double getDbus() {
		return this.dbus;
	}

	public void setDbus(Double dbus) {
		this.dbus = dbus;
	}

	public Double getDcrp() {
		return this.dcrp;
	}

	public void setDcrp(Double dcrp) {
		this.dcrp = dcrp;
	}

	public Double getDdel() {
		return this.ddel;
	}

	public void setDdel(Double ddel) {
		this.ddel = ddel;
	}

	public Double getDemr() {
		return this.demr;
	}

	public void setDemr(Double demr) {
		this.demr = demr;
	}

	public Double getDisa() {
		return this.disa;
	}

	public void setDisa(Double disa) {
		this.disa = disa;
	}

	public Double getDmot() {
		return this.dmot;
	}

	public void setDmot(Double dmot) {
		this.dmot = dmot;
	}

	public Double getDped() {
		return this.dped;
	}

	public void setDped(Double dped) {
		this.dped = dped;
	}

	public Double getDtax() {
		return this.dtax;
	}

	public void setDtax(Double dtax) {
		this.dtax = dtax;
	}

	public Double getDtrain() {
		return this.dtrain;
	}

	public void setDtrain(Double dtrain) {
		this.dtrain = dtrain;
	}

	public Double getDtram() {
		return this.dtram;
	}

	public void setDtram(Double dtram) {
		this.dtram = dtram;
	}

	public Double getDtru() {
		return this.dtru;
	}

	public void setDtru(Double dtru) {
		this.dtru = dtru;
	}

	public Double getDvdr() {
		return this.dvdr;
	}

	public void setDvdr(Double dvdr) {
		this.dvdr = dvdr;
	}

	public Double getFery() {
		return this.fery;
	}

	public void setFery(Double fery) {
		this.fery = fery;
	}

	public Double getFow() {
		return this.fow;
	}

	public void setFow(Double fow) {
		this.fow = fow;
	}

	public Double getFron() {
		return this.fron;
	}

	public void setFron(Double fron) {
		this.fron = fron;
	}

	public Double getGren() {
		return this.gren;
	}

	public void setGren(Double gren) {
		this.gren = gren;
	}

	public Integer getHead() {
		return this.head;
	}

	public void setHead(Integer head) {
		this.head = head;
	}

	public Integer getHier() {
		return this.hier;
	}

	public void setHier(Integer hier) {
		this.hier = hier;
	}

	public Double getIntr() {
		return this.intr;
	}

	public void setIntr(Double intr) {
		this.intr = intr;
	}

	public Double getItim() {
		return this.itim;
	}

	public void setItim(Double itim) {
		this.itim = itim;
	}

	public Double getJden() {
		return this.jden;
	}

	public void setJden(Double jden) {
		this.jden = jden;
	}

	public Double getJwav() {
		return this.jwav;
	}

	public void setJwav(Double jwav) {
		this.jwav = jwav;
	}

	public Double getLeng() {
		return this.leng;
	}

	public void setLeng(Double leng) {
		this.leng = leng;
	}

	public String getMetadata() {
		return this.metadata;
	}

	public void setMetadata(String metadata) {
		this.metadata = metadata;
	}

	public Double getMnvr() {
		return this.mnvr;
	}

	public void setMnvr(Double mnvr) {
		this.mnvr = mnvr;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getNlan() {
		return this.nlan;
	}

	public void setNlan(Integer nlan) {
		this.nlan = nlan;
	}

	public Double getNpav() {
		return this.npav;
	}

	public void setNpav(Double npav) {
		this.npav = npav;
	}

	public Double getNthr() {
		return this.nthr;
	}

	public void setNthr(Double nthr) {
		this.nthr = nthr;
	}

	public Double getOcap() {
		return this.ocap;
	}

	public void setOcap(Double ocap) {
		this.ocap = ocap;
	}

	public Double getOpen() {
		return this.open;
	}

	public void setOpen(Double open) {
		this.open = open;
	}

	public Double getPark() {
		return this.park;
	}

	public void setPark(Double park) {
		this.park = park;
	}

	public Double getPrio() {
		return this.prio;
	}

	public void setPrio(Double prio) {
		this.prio = prio;
	}

	public Double getRamp() {
		return this.ramp;
	}

	public void setRamp(Double ramp) {
		this.ramp = ramp;
	}

	public Double getRdbt() {
		return this.rdbt;
	}

	public void setRdbt(Double rdbt) {
		this.rdbt = rdbt;
	}

	public Integer getRefe() {
		return this.refe;
	}

	public void setRefe(Integer refe) {
		this.refe = refe;
	}

	public String getShap() {
		return this.shap;
	}

	public void setShap(String shap) {
		this.shap = shap;
	}

	public Double getSpdc() {
		return this.spdc;
	}

	public void setSpdc(Double spdc) {
		this.spdc = spdc;
	}

	public Double getSped() {
		return this.sped;
	}

	public void setSped(Double sped) {
		this.sped = sped;
	}

	public Double getToll() {
		return this.toll;
	}

	public void setToll(Double toll) {
		this.toll = toll;
	}

	public Double getTunn() {
		return this.tunn;
	}

	public void setTunn(Double tunn) {
		this.tunn = tunn;
	}

	public Double getUndt() {
		return this.undt;
	}

	public void setUndt(Double undt) {
		this.undt = undt;
	}

	public Double getUrbn() {
		return this.urbn;
	}

	public void setUrbn(Double urbn) {
		this.urbn = urbn;
	}

}