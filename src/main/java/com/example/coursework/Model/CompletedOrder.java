package com.example.coursework.Model;

public class CompletedOrder {

    private String completion_date;
    private int order_id;
    private double order_price;
    private int completed_order_id;

    public CompletedOrder(String completion_date , int order_id, double order_price , int completed_order_id){
        this.completion_date = completion_date;
        this.order_id = order_id;
        this.order_price = order_price;
        this.completed_order_id = completed_order_id;
    }


    public int getOrder_id() {
        return order_id;
    }

    public double getOrder_price() {
        return order_price;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public void setOrder_price(double order_price) {
        this.order_price = order_price;
    }

    public int getCompleted_order_id() {
        return completed_order_id;
    }

    public String getCompletion_date() {
        return completion_date;
    }

    public void setCompleted_order_id(int completed_order_id) {
        this.completed_order_id = completed_order_id;
    }

    public void setCompletion_date(String completion_date) {
        this.completion_date = completion_date;
    }
}
