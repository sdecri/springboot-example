package com.sdc.springboot_example.model;

import javax.persistence.*;
import lombok.Data;


/**
 * The persistent class for the strt database table.
 * 
 */
@Entity
@Table(name = "strt")
//@NamedQuery(name="Strt.findAll", query="SELECT s FROM Strt s")
//@NamedQuery(name="Strt.findById", query="SELECT s FROM Strt s where s.id.idno = ?1 and s.id.tail = ?2")
@NamedQuery(name="Strt.findByIdno", query="SELECT s FROM Strt s where s.id.idno = ?1")
@Data
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

}