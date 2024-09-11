package com.example.PowerUP;


import jakarta.persistence.*;

//Creating an Entity table for JPA
@Entity
@Table(name = "video_games")
public class Video_Game {

    //Constructors plus setters and getters, ID will be auto generated on creation
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String Genre;
    private double price;
    private String publisher;
    private String developer;
    private double rating;


    public Integer getId() {
        return id;
    }


    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return Genre;
    }

    public void setGenre(String genre) {
        Genre = genre;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }
}

