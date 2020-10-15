/**
 * StrtService.java
 */
package com.sdc.springboot_example.service.strt;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdc.springboot_example.model.Strt;
import com.sdc.springboot_example.model.StrtPK;
import com.sdc.springboot_example.repository.StrtRepository;

/**
 * @author Simone.DeCristofaro
 * Oct 14, 2020
 */
@Service
public class StrtService implements IStrtService {

    @Autowired
    private StrtRepository repository;
    
    /**
    * {@inheritDoc}
    */
    @Override
    public List<Strt> findAll() {

        return (List<Strt>) repository.findAll();
        
    }

    /**
    * {@inheritDoc}
    */
    @Override
    public Optional<Strt> findByIdnoTail(int idno, int tail) {

        return repository.findById(new StrtPK(idno, tail));
        
    }

    /**
    * {@inheritDoc}
    */
    @Override
    public List<Strt> findByIdno(int idno) {

        return (List<Strt>) repository.findByIdno(idno);
        
    }

}
