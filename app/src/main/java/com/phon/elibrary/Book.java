package com.phon.elibrary;

public class Book {
    private int id;
    private String imgUrl;
    private String title;
    private String author;
    private String size;
    private String description;

    public Book(int id, String imgUrl, String title, String author, String size, String description) {
        this.id = id;
        this.imgUrl = imgUrl;
        this.title = title;
        this.author = author;
        this.size = size;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
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

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
