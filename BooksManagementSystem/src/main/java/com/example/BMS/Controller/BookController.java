package com.example.BMS.Controller;

import com.example.BMS.Models.Book;
import com.example.BMS.Models.Author;
import com.example.BMS.Models.Store;
import com.example.BMS.Repository.BookRepository;
import com.example.BMS.Repository.AuthorRepository;
import com.example.BMS.Repository.StoreRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author HIMAJA PARACHURI
 */
@Controller
public class BookController {
    ModelAndView mv = new ModelAndView();
    @Autowired
    BookRepository bookRepo;
    @Autowired
    AuthorRepository authorRepo;
    @Autowired
    StoreRepository storeRepo;
    
    
    @RequestMapping("")
    public ModelAndView index() {
        mv.setViewName("index");
        return mv;
    }
    
    @RequestMapping("index")
    public ModelAndView home() {
        mv.setViewName("home");
        return mv;
    }
    
    
    @RequestMapping("addBook")
    public ModelAndView addBook(){
        mv.setViewName("addNewBook");
        Iterable<Author> authorList = authorRepo.findAll();
        mv.addObject("authors", authorList);

        return mv;
    }
    
    @RequestMapping("addNewBook")
    public ModelAndView addNewBook(Book book, @RequestParam("authorId") int id, @RequestParam("storeId") int sid) {
        Author author = authorRepo.findById(id).orElse(new Author());
        book.setAuthor(author);
        Store store = storeRepo.findById(sid).orElse(new Store());
        book.setStore(store);
        bookRepo.save(book);
        mv.setViewName("home");
        return mv;
    }
    
    @RequestMapping("addAuthor")
    public ModelAndView addAuthor() {
        mv.setViewName("addNewAuthor");
        return mv;
    }

    @RequestMapping("addNewAuthor")
    public ModelAndView addNewAuthor(Author author) {
        authorRepo.save(author);
        mv.setViewName("home");
        return mv;
    }

    @RequestMapping("addStore")
    public ModelAndView addStore() {
        mv.setViewName("addNewStore");
        return mv;
    }
    
    @RequestMapping("addNewStore")
    public ModelAndView addNewStore(Store store) {
        storeRepo.save(store);
        mv.setViewName("home");
        return mv;
    }
    
    @RequestMapping("viewBooks")
    public ModelAndView viewBooks() {
        mv.setViewName("viewBooks");
        Iterable<Book> bookList = bookRepo.findAll();
        mv.addObject("books", bookList);
        return mv;
    }

    @RequestMapping("viewAuthors")
    public ModelAndView viewAuthors() {
        mv.setViewName("viewAuthors");
        Iterable<Author> authorList = authorRepo.findAll();
        mv.addObject("authors", authorList);
        return mv;
    }
    
    @RequestMapping("viewStores")
    public ModelAndView viewStores() {
        mv.setViewName("viewStores");
        Iterable<Store> storeList = storeRepo.findAll();
        mv.addObject("stores", storeList);
        return mv;
    }

    @RequestMapping("search")
    public ModelAndView searchByCategory(String category) {
        List<Book> bookList=bookRepo.findBySearch(category);
        mv.setViewName("searchResults");
        mv.addObject("books", bookList);
        
        return mv;
    }

    @RequestMapping("editBook")
    public ModelAndView editBook(Book book) {
        Book bookEdit= bookRepo.findById(book.getBookId()).orElse(new Book());
        book.setAuthor(bookEdit.getAuthor());
        book.setStore(bookEdit.getStore());
        bookRepo.save(book);
        mv.setViewName("editBook");
        return mv;
    }

    @RequestMapping("editAuthor")
    public ModelAndView editAuthor(Author author) {
        authorRepo.save(author);
        mv.setViewName("editAuthor");
        return mv;
    }
    
    @RequestMapping("editStore")
    public ModelAndView editStore(Store store) {
        storeRepo.save(store);
        mv.setViewName("editStore");
        return mv;
    }

    @RequestMapping("deleteBook")
    public ModelAndView deleteBook(Book book) {
        Optional<Book> bookFound = bookRepo.findById(book.getBookId());
        if (bookFound.isPresent()) {
            bookRepo.delete(book);
        }
        return home();
    }

    @RequestMapping("deleteAuthor")
    public ModelAndView deleteAuthor(Author author) {
        Optional<Author> authorFound = authorRepo.findById(author.getAuthorId());
        if (authorFound.isPresent()) {
            authorRepo.delete(author);
        }
        return home();
    }

    @RequestMapping("deleteStore")
    public ModelAndView deleteStore(Store store) {
        Optional<Store> storeFound = storeRepo.findById(store.getStoreId());
        if (storeFound.isPresent()) {
            storeRepo.delete(store);
        }
        return home();
    }

    }

