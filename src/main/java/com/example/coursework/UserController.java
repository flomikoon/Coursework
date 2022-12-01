package com.example.coursework;

import com.example.coursework.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    DBService dbService;

    @GetMapping("/get_Users_nickname")
    public List<Users> getUsersNickname(String nick_name){
        List<Users> list = dbService.getUsersNickname(nick_name);
        return list;
    }

    @GetMapping("/get_Publisher_name")
    public List<Publisher> getPublisherName(String publisher){
        List<Publisher> list = dbService.getPublisherName(publisher);
        return list;
    }

    @GetMapping("/get_Developer_name")
    public List<Developer> getDeveloperName(String developer){
        List<Developer> list = dbService.getDeveloperName(developer);
        return list;
    }

    @GetMapping("/get_Discount_name")
    public List<Discount> getDiscountName(String discount){
        List<Discount> list = dbService.getDiscountName(discount);
        return list;
    }

    @GetMapping("/get_Game")
    public List<Game> getGame(){
        long start = System.currentTimeMillis();
        List<Game> list = dbService.getGame();
        long end = System.currentTimeMillis();
        System.out.println(end-start);
        return list;
    }

    @GetMapping("/get_Game_name")
    public List<Game> getGameName(String name){
        List<Game> list = dbService.getGameName(name);
        return list;
    }

    @GetMapping("/get_ReviewGame")
    public List<Review> getReview(int game_id){
        List<Review> list = dbService.getReviewGame(game_id);
        return list;
    }

    @PostMapping("/add_Review")
    public int addReview(String text , int assessment , int game_id){
        int list = dbService.addReview(text , assessment , game_id);
        return list;
    }

}
