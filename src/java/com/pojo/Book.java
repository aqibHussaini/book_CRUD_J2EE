/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pojo;

/**
 *
 * @author Bhatti
 */
public class Book {
int id;
String booktitle,bookauthor,pic;

    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", booktitle=" + booktitle + ", bookauthor=" + bookauthor + ", pic=" + pic + ", bookprice=" + bookprice + '}';
    }

    public Book(String booktitle, String bookauthor, String pic, float bookprice) {
        this.booktitle = booktitle;
        this.bookauthor = bookauthor;
        this.pic = pic;
        this.bookprice = bookprice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBooktitle() {
        return booktitle;
    }

    public void setBooktitle(String booktitle) {
        this.booktitle = booktitle;
    }

    public String getBookauthor() {
        return bookauthor;
    }

    public void setBookauthor(String bookauthor) {
        this.bookauthor = bookauthor;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public float getBookprice() {
        return bookprice;
    }

    public void setBookprice(float bookprice) {
        this.bookprice = bookprice;
    }

    public Book(int id, String booktitle, String bookauthor, String pic, float bookprice) {
        this.id = id;
        this.booktitle = booktitle;
        this.bookauthor = bookauthor;
        this.pic = pic;
        this.bookprice = bookprice;
    }

    public Book() {
    }
float bookprice;

}
