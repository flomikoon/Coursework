package com.example.coursework.Model;

public class Order {

    private String order_date;
    private int user_id;
    private double order_price;
    private int order_id;

    public Order(String order_date , int user_id , double order_price , int order_id){
        this.order_date = order_date;
        this.user_id = user_id;
        this.order_price = order_price;
        this.order_id = order_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public double getOrder_price() {
        return order_price;
    }

    public String getOrder_date() {
        return order_date;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public void setOrder_price(double order_price) {
        this.order_price = order_price;
    }
}
