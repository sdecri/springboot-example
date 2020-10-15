package com.sdc.springboot_example.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the strt database table.
 * 
 */
@Embeddable
public class StrtPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private Integer idno;

	@Column(insertable=false, updatable=false)
	private Integer tail;

	public StrtPK() {
	}
	
	
	/**
     * @param idno
     * @param tail
     */
    public StrtPK(Integer idno, Integer tail) {

        super();
        this.idno = idno;
        this.tail = tail;
    }


    public Integer getIdno() {
		return this.idno;
	}
	public void setIdno(Integer idno) {
		this.idno = idno;
	}
	public Integer getTail() {
		return this.tail;
	}
	public void setTail(Integer tail) {
		this.tail = tail;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof StrtPK)) {
			return false;
		}
		StrtPK castOther = (StrtPK)other;
		return 
			this.idno.equals(castOther.idno)
			&& this.tail.equals(castOther.tail);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idno.hashCode();
		hash = hash * prime + this.tail.hashCode();
		
		return hash;
	}
}