package com.twu.biblioteca.repository;

import com.twu.biblioteca.entity.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BookRepository {
    List<Book> bookList;

    public BookRepository() {
        bookList = new ArrayList<>();
        bookList.add(new Book(1001,"Head First Java","Kathy Sierra, Bert Bates","2005",true));
        bookList.add(new Book(1002,"Thinking in Java","Bruce Eckel","2006",true));
        bookList.add(new Book(1003,"Refactoring: Improving the Design of Existing Code","Martin Fowler","1999",true));
        bookList.add(new Book(1004,"C++ Primer Plus","Stephen Prata","2011",true));
    }

    public List<Book> getBookList() {
        return bookList.stream().filter(book -> book.isInStock()).collect(Collectors.toList());
    }


}
