/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.BMS.Repository;

import com.example.BMS.Models.Book;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author HIMAJA PARACHURI
 */
public interface BookRepository extends CrudRepository<Book, Integer>{
        @Query(" from Book b where b.category=:category")
        List<Book> findBySearch(@Param("category")String category);
}
