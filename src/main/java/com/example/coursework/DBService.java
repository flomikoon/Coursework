package com.example.coursework;

import com.example.coursework.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DBService {

    @Autowired
    DBRepository dbRepository;

    @Cacheable("Users")
    public List<Users> getUsers(){
        return dbRepository.getUsers();
    }

    public List<Users> getUsersNickname(String nick_name){
        return dbRepository.getUsersNickname(nick_name);
    }

    public List<Publisher> getPublisher(){
        return dbRepository.getPublisher();
    }

    public List<Publisher> getPublisherName(String publisher){return dbRepository.getPublisherName(publisher);}

    public List<Developer> getDeveloper(){return dbRepository.getDeveloper();}

    public List<Developer> getDeveloperName(String developer){return dbRepository.getDeveloperName(developer);}

    public List<Discount> getDiscount(){return dbRepository.getDiscount();}

    public List<Discount> getDiscountName(String discount){return dbRepository.getDiscountName(discount);}

    @Cacheable("game")
    public List<Game> getGame(){return dbRepository.getGame();}

    public List<Game> getGameName(String name){return dbRepository.getGameName(name);}

    public List<Order> getOrder(){return dbRepository.getOrder();}

    public List<OrderGame> getOrderGame(){return dbRepository.getOrderGame();}

    public List<CompletedOrder> getCompletedOrder(){return dbRepository.getCompletedOrder();}

    public List<Review> getReview(){return dbRepository.getReview();}

    public List<Review> getReviewGame(int game_id){return dbRepository.getReviewGame(game_id);}

    public int setUserNickname(int id , String nick){return dbRepository.setUserNickname(nick , id);}

    public int deleteReview(String text){return dbRepository.deleteReview(text);}

    public int addReview(String text , int assessment , int game_id){return dbRepository.addReview(text , assessment , game_id);}

    public int addGame(int game_id , String game_name , double price , String publisher , String developer , String game_genre , String discount)
    {return dbRepository.addGame(game_id , game_name , price , publisher , developer, game_genre , discount);}
}
