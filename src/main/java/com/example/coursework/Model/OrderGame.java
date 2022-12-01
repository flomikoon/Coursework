package com.example.coursework.Model;

public class OrderGame {
    private int order_id;
    public int game_id;

    public OrderGame(int order_id , int game_id){
        this.order_id = order_id;
        this.game_id = game_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getGame_id() {
        return game_id;
    }

    public void setGame_id(int game_id) {
        this.game_id = game_id;
    }
}
