/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.BMS.Repository;

import com.example.BMS.Models.Author;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author HIMAJA PARACHURI
 */
public interface AuthorRepository extends CrudRepository<Author, Integer>{
    
}
