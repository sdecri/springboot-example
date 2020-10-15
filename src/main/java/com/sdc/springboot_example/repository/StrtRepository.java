/**
 * StrtRepository.java
 */
package com.sdc.springboot_example.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sdc.springboot_example.model.Strt;
import com.sdc.springboot_example.model.StrtPK;

/**
 * @author Simone.DeCristofaro
 * Oct 14, 2020
 */
@Repository
public interface StrtRepository extends CrudRepository<Strt, StrtPK>{

    /**
     * @param idno
     * @return
     */
    Iterable<Strt> findByIdno(int idno);
}
