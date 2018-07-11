package com.twu.biblioteca.entity;

import static com.twu.biblioteca.view.Hint.BOOK_FORMAT;

public class Book {
    private long id;
    private String title;
    private String author;
    private String publishYear;
    private boolean isInStock;

    public Book(long id, String title, String author, String publishYear, boolean isInStock) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publishYear = publishYear;
        this.isInStock = isInStock;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(String publishYear) {
        this.publishYear = publishYear;
    }

    public boolean isInStock() {
        return isInStock;
    }

    public void setInStock(boolean inStock) {
        isInStock = inStock;
    }

    @Override
    public String toString() {
        return String.format(BOOK_FORMAT,id,title,author,publishYear);
    }
}
