package com.example.coursework.Model;

import java.util.Objects;

public class Review {
    private String text;
    private int review_id;
    private int game_id;
    private int assessment;

    public Review(int review_id , String text , int assessment , int game_id){
        this.review_id = review_id;
        this.text = text;
        this.assessment = assessment;
        this.game_id = game_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return game_id == review.game_id && assessment == review.assessment && Objects.equals(text, review.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, game_id, assessment);
    }

    public int getGame_id() {
        return game_id;
    }

    public int getReview_id() {
        return review_id;
    }

    public int getAssessment() {
        return assessment;
    }

    public String getText() {
        return text;
    }

    public void setGame_id(int game_id) {
        this.game_id = game_id;
    }

    public void setReview_id(int review_id) {
        this.review_id = review_id;
    }

    public void setAssessment(int assessment) {
        this.assessment = assessment;
    }

    public void setText(String text) {
        this.text = text;
    }
}
