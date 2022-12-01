package com.example.coursework.Model;

public class Developer {


    private String developer;
    private String country;
    private String date_of_foundation;
    private int game_released;

    public Developer(String developer , String country , String date_of_foundation , int game_released){
        this.developer = developer;
        this.country = country;
        this.date_of_foundation = date_of_foundation;
        this.game_released = game_released;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer){
        this.developer = developer;
    }

    public String getCountry(){
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDate_of_foundation(){
        return date_of_foundation;
    }

    public void setDate_of_foundation(String date_of_foundation) {
        this.date_of_foundation = date_of_foundation;
    }

    public int getGame_released() {
        return game_released;
    }

    public void setGame_released(int game_released) {
        this.game_released = game_released;
    }
}
