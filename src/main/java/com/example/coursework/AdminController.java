package com.example.coursework;

import com.example.coursework.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    DBService dbService;

    @PutMapping("/set_nickname")
    public int setUserNickname( String nick , int id ){
        int list = dbService.setUserNickname(id , nick);
        return list;
    }

    @GetMapping("/get Users")
    public List<Users> getUsers(){
        long start = System.currentTimeMillis();
        List<Users> list = dbService.getUsers();
        long end = System.currentTimeMillis();
        System.out.println(end-start);
        return list;
    }

    @GetMapping("/get_Publisher")
    public List<Publisher> getPublisher(){
        List<Publisher> list = dbService.getPublisher();
        return list;
    }

    @GetMapping("/get_Developer")
    public List<Developer> getDeveloper(){
        List<Developer> list = dbService.getDeveloper();
        return list;
    }

    @GetMapping("/get_Discount")
    public List<Discount> getDiscount(){
        List<Discount> list = dbService.getDiscount();
        return list;
    }

    @GetMapping("/get_Order")
    public List<Order> getOrder(){
        List<Order> list = dbService.getOrder();
        return list;
    }

    @GetMapping("/get_OrderGame")
    public List<OrderGame> getOrderGame(){
        List<OrderGame> list = dbService.getOrderGame();
        return list;
    }

    @GetMapping("/get_CompletedOrder")
    public List<CompletedOrder> getCompletedOrder(){
        List<CompletedOrder> list = dbService.getCompletedOrder();
        return list;
    }

    @GetMapping("/get_Review")
    public List<Review> getReview(){
        List<Review> list = dbService.getReview();
        return list;
    }

    @DeleteMapping("/delete_Review")
    public int deleteReview(String text){
        int list = dbService.deleteReview(text);
        return list;
    }

    @PostMapping("/add_Game")
    public int addGame(int game_id , String game_name , double price , String publisher , String developer , String game_genre , String discount){
        int list = dbService.addGame(game_id , game_name , price , publisher , developer , game_genre , discount);
        return list;
    }
}
