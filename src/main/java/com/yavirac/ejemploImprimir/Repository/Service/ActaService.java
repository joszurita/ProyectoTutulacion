/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yavirac.ejemploImprimir.Repository.Service;

import com.yavirac.ejemploImprimir.Model.Acta;
import com.yavirac.ejemploImprimir.Repository.ActaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author josue
 */
@Service
public class ActaService{
    @Autowired
    ActaRepository actaRepository;
    
    public List<Acta> findAll()
    {
        return actaRepository.findAll();
    }
    
    /**Read*/
    public Acta findById(Long id)
    {
        return actaRepository.findById(id).get();
    }
    
    /**Create, Update */
    public Acta save(Acta acta)
    {
        return actaRepository.save(acta);
    }
    
    /**Delete */
    public void deleteById(long id)
    {
        actaRepository.deleteById(id);
    }
}
