package com.example.coursework.Model;

public class Game {

    private int game_id;
    private String game_name;
    private double price;
    private String publisher;
    private String developer;
    private String release_date;
    private String game_genre;
    private String discount;

    public Game(int game_id , String game_name , double price , String publisher , String developer , String release_date , String game_genre , String discount){
        this.game_id = game_id;
        this.game_name = game_name;
        this.price = price;
        this.publisher = publisher;
        this.developer = developer;
        this.release_date = release_date;
        this.game_genre = game_genre;
        this.discount = discount;
    }

     public int getGame_id() {
        return game_id;
    }

    public void setGame_id(int game_id) {
        this.game_id = game_id;
    }

    public String getGame_name() {
        return game_name;
    }

    public void setGame_name(String game_name) {
        this.game_name = game_name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDeveloper() {
        return developer;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getRelease_date() {
        return release_date;
    }

    public String getDiscount() {
        return discount;
    }

    public String getGame_genre() {
        return game_genre;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setGame_genre(String game_genre) {
        this.game_genre = game_genre;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }
}
