package com.example.coursework.Model;

import java.util.Objects;

public class Users {

    private int user_id;
    private String nick_name;
    private double balance;
    private String phone_number;

    public Users(int user_id , String nick_name , double balance , String phone_number){
        this.user_id = user_id;
        this.nick_name = nick_name;
        this.balance = balance;
        this.phone_number = phone_number;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getNick_name(){
        return nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getPhone_number(){
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    @Override
    public String toString() {
        return "Users{" +
                "user_id=" + user_id +
                ", nick_name='" + nick_name + '\'' +
                ", balance=" + balance +
                ", phone_number='" + phone_number + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return user_id == users.user_id && Double.compare(users.balance, balance) == 0 && Objects.equals(nick_name, users.nick_name) && Objects.equals(phone_number, users.phone_number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user_id, nick_name, balance, phone_number);
    }

    public Users()
    {
        super();
    }
}
