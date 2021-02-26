/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.humanbooster.examWSJavaMartinsAnthony.repository;

import com.humanbooster.examWSJavaMartinsAnthony.model.Color;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author HB
 */
@Repository
public interface ColorRepository extends CrudRepository<Color, Integer>{
    
    List<Color> findAll();
    
}
