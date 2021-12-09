/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.BMS.Models;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author HIMAJA PARACHURI
 */
@Entity
public class Author {
  @Id
  private int authorId;
  private String authorFName;
  private String authorLName;

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public void setAuthorFName(String authorFName) {
        this.authorFName = authorFName;
    }

    public void setAuthorLName(String authorLName) {
        this.authorLName = authorLName;
    }

    public int getAuthorId() {
        return authorId;
    }

    public String getAuthorFName() {
        return authorFName;
    }

    public String getAuthorLName() {
        return authorLName;
    }

    @Override
    public String toString() {
        return  authorFName +" "+ authorLName;
    }
  
  
  
}
