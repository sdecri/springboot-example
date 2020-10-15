/**
 * IStrtService.java
 */
package com.sdc.springboot_example.service.strt;

import java.util.List;
import java.util.Optional;

import com.sdc.springboot_example.model.Strt;

/**
 * @author Simone.DeCristofaro
 * Oct 14, 2020
 */
public interface IStrtService {

    Iterable<Strt> findAll();
    
    Optional<Strt> findByIdnoTail(int idno, int tail);
    
    List<Strt> findByIdno(int idno);
    
}
