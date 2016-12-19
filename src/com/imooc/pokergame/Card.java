package com.imooc.pokergame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static java.lang.Integer.getInteger;

/**
 * Created by mike.wang on 2016/11/5.
 */
public class Card{
    private String color;
    private String point;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }
    public Card(){}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Card)) return false;

        Card card = (Card) o;

        if (!getColor().equals(card.getColor())) return false;
        return getPoint().equals(card.getPoint());

    }

    @Override
    public int hashCode() {
        int result = getColor().hashCode();
        result = 31 * result + getPoint().hashCode();
        return result;
    }

    public Card(String color, String point){
        setColor(color);
        setPoint(point);

    }


    public int compareCards(Card o) {
        if(getCardNumber(this)[0]==getCardNumber(o)[0]){
            return getCardNumber(this)[1]-getCardNumber(o)[1];
        }
        return getCardNumber(this)[0]-getCardNumber(o)[0];

    }

    public int[] getCardNumber(Card card){
        int colorNumber,pointNumber;
        int[] numbers= new int[2];
        switch (card.getColor()){
            case("黑桃"):
                colorNumber=400;break;
            case("红桃"):
                colorNumber=300;break;
            case("梅花"):
                colorNumber=200;break;
            case("方块"):
                colorNumber=100;break;
                default:
                    colorNumber=0;
        }
        switch (card.getPoint()){
            case("J"):
                pointNumber=11;break;
            case("Q"):
                pointNumber=12;break;
            case("K"):
                pointNumber=13;break;
            case("A"):
                pointNumber=14;break;
                default:
                    pointNumber=Integer.valueOf(card.getPoint());
        }
        numbers[0] = pointNumber;
        numbers[1]=colorNumber+pointNumber;
        return numbers;
    }
}
