package com.example.coursework.Model;

public class Discount {

    private String discount;
    private String start_date;
    private String end_date;
    private int discount_amount;

    public Discount(String discount , String start_date , String end_date , int discount_amount){
        this.discount = discount;
        this.start_date = start_date;
        this.end_date = end_date;
        this.discount_amount = discount_amount;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount){
        this.discount = discount;
    }

    public String getStart_date(){
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date(){
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public int getDiscount_amount() {
        return discount_amount;
    }

    public void setDiscount_amount(int discount_amount) {
        this.discount_amount = discount_amount;
    }
}
