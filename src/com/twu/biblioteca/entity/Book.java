package com.twu.biblioteca.entity;

public class Book {
    private long id;
    private String title;
    private String author;
    private String publishTime;
    private boolean isInStock;

    public Book(long id, String title, String author, String publishTime, boolean isInStock) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publishTime = publishTime;
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

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public boolean isInStock() {
        return isInStock;
    }

    public void setInStock(boolean inStock) {
        isInStock = inStock;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publishTime='" + publishTime + '\'' +
                ", isInStock=" + isInStock +
                '}';
    }
}
