package com.banyechan.spring5_webflux_demo.entity;

import java.io.Serializable;
import java.util.Date;

public class Book implements Serializable{

    private static final long serialVersionUID = 6961484767331836691L;

    public Book() {
    }

    private Integer id;

    private String name;

    private String author;

    private Double price;

    private Date createTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Book(Integer id, String name, String author, Double price, Date createTime) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.price = price;
        this.createTime = createTime;
    }
}
