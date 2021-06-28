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
    
        return String.format("STRT: IDNO = %d, TAIL = %d, NAME = %s, LENG = %f, SPED = %f"
                , id.getIdno(), id.getTail(), name, leng, sped);
        
    }
    
	@EmbeddedId
	private StrtPK id;

	private String name;
	private Double leng;
	private Double sped;

}