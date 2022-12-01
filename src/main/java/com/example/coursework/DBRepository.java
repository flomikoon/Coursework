package com.example.coursework;


import com.example.coursework.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DBRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Users> getUsers(){
        return jdbcTemplate.query("SELECT * FROM \"USERS\"" ,
                (rs , rowNum) -> new Users(rs.getInt("user_id") ,
                        rs.getString("nick_name"),
                rs.getDouble("balance"),
                        rs.getString("phone_number") ));
    }

    public List<Users> getUsersNickname(String nick_name){
        return jdbcTemplate.query("SELECT * FROM \"USERS\" where nick_name=?" ,
                (rs , rowNum) -> new Users(rs.getInt("user_id") ,
                        rs.getString("nick_name"),
                rs.getDouble("balance"),
                        rs.getString("phone_number") ) , nick_name);
    }

    public int setUserNickname(String nick , int id){
        return jdbcTemplate.update("UPDATE \"USERS\" SET nick_name = ?  where user_id = ?" , nick , id);
    }

    public List<Publisher> getPublisher(){
        return jdbcTemplate.query("SELECT * FROM \"PUBLISHER\"" , (rs , rowNum) -> new Publisher(rs.getString("publisher") , rs.getString("country"),
                rs.getString("date_of_foundation"), rs.getInt("games_released") ));
    }

    public List<Publisher> getPublisherName(String publisher){
        return jdbcTemplate.query("SELECT * FROM \"PUBLISHER\" where publisher = ?" , (rs , rowNum) -> new Publisher(rs.getString("publisher") , rs.getString("country"),
                rs.getString("date_of_foundation"), rs.getInt("games_released") ) , publisher);
    }

    public List<Developer> getDeveloper(){
        return jdbcTemplate.query("SELECT * FROM \"DEVELOPER\"" , (rs , rowNum) -> new Developer(rs.getString("developer") , rs.getString("country"),
                rs.getString("date_of_foundation"), rs.getInt("games_released") ));
    }

    public List<Developer> getDeveloperName(String developer){
        return jdbcTemplate.query("SELECT * FROM \"DEVELOPER\" where developer = ?" , (rs , rowNum) -> new Developer(rs.getString("developer") ,
                rs.getString("country"),
                rs.getString("date_of_foundation"), rs.getInt("games_released") ) , developer);
    }

    public List<Discount> getDiscount(){
        return jdbcTemplate.query("SELECT * FROM \"DISCOUNT\"" , (rs , rowNum) -> new Discount(rs.getString("discount") ,
                rs.getString("start_date"),
                rs.getString("end_date"), rs.getInt("discount_amount") ));
    }

    public List<Discount> getDiscountName(String discount){
        return jdbcTemplate.query("SELECT * FROM \"DISCOUNT\" where discount = ?" , (rs , rowNum) -> new Discount(rs.getString("discount") ,
                rs.getString("start_date"),
                rs.getString("end_date"), rs.getInt("discount_amount") ) , discount);
    }

    public List<Game> getGame(){
        return jdbcTemplate.query("SELECT * FROM \"GAME\"" , (rs, rowNum) -> new Game(rs.getInt("game_id") , rs.getString("game_name") ,
                rs.getDouble("price") , rs.getString("publisher") , rs.getString("developer") ,
                rs.getString("release_date") , rs.getString("game_genre") , rs.getString("discount")) );
    }

    public List<Game> getGameName(String game){
        game = game + "%";
        return jdbcTemplate.query("SELECT * FROM \"GAME\" where game_name LIKE ?" , (rs, rowNum) -> new Game(rs.getInt("game_id") ,
                rs.getString("game_name") ,
                rs.getDouble("price") , rs.getString("publisher") , rs.getString("developer") ,
                rs.getString("release_date") , rs.getString("game_genre") , rs.getString("discount")) , game);
    }

    public List<Order> getOrder(){
        return jdbcTemplate.query("SELECT * FROM \"ORDER\"" , (rs , rowNum) -> new Order(rs.getString("order_date") , rs.getInt("user_id") ,
                rs.getDouble("order_price") , rs.getInt("order_id")));
    }

    public List<OrderGame> getOrderGame(){
        return jdbcTemplate.query("SELECT * FROM \"ORDER_GAME\"" , (rs , rowNum) -> new OrderGame(rs.getInt("order_id") , rs.getInt("game_id")));
    }

    public List<CompletedOrder> getCompletedOrder(){
        return jdbcTemplate.query("SELECT * FROM completed_order" , (rs , rowNum) -> new CompletedOrder(rs.getString("completion_date") ,
                rs.getInt("completed_order_id"), rs.getDouble("order_price"), rs.getInt("order_id") ));
    }


    public List<Review> getReview(){
        return jdbcTemplate.query("SELECT * FROM \"REVIEWS\"" , (rs , rowNum) -> new Review(rs.getInt("review_id") ,
                rs.getString("text"), rs.getInt("assessment"), rs.getInt("game_id") ));
    }

    public List<Review> getReviewGame(int game_id){
        return jdbcTemplate.query("SELECT * FROM \"REVIEWS\" where game_id = ?" , (rs , rowNum) -> new Review(rs.getInt("review_id") ,
                rs.getString("text"), rs.getInt("assessment"), rs.getInt("game_id") ) , game_id);
    }

    public int deleteReview(String text){
        text = "%" + text + "%";
        return jdbcTemplate.update("DELETE FROM \"REVIEWS\" WHERE text LIKE ?" , text );
    }

    public int addReview(String text , int assessment , int game_id){
        return jdbcTemplate.update("INSERT INTO \"REVIEWS\" (text , assessment , game_id) VALUES (?,?,?)" , text , assessment , game_id);
    }

    public int addGame(int game_id , String game_name , double price , String publisher , String developer, String game_genre , String discount){
        return jdbcTemplate.update("INSERT INTO \"GAME\" (game_id , game_name , price , publisher , developer , release_date , game_genre , discount) VALUES (?,?,?,?,?, CURRENT_DATE,?,?)" ,
               game_id , game_name , price , publisher , developer , game_genre , discount);
    }

}
