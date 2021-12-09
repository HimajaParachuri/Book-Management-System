/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.BMS.Models;

import com.example.BMS.Repository.BookRepository;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author HIMAJA PARACHURI
 */
@Entity
public class Book{

    public static List<Book> getBookByCategory;

    @Id
    private int bookId;
    private String bookName;
    private String category;
    private String publication;
   
    @ManyToOne
    private Author author;
    @ManyToOne
    private Store store;

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

     
    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setPublication(String publication) {
        this.publication = publication;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public String getCategory() {
        return category;
    }

    public String getPublication() {
        return publication;
    }

    public int getBookId() {
        return bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public Author getAuthor() {
        return author;
    }
    
    @Override
    public String toString() {
        return "Book{" + "bookId=" + bookId + ", bookName=" + bookName + ", category=" + category + ", publication=" + publication + ", author=" + author + ", store=" + store + '}';
    }
  
    
}
