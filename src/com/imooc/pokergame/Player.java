package com.imooc.pokergame;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by mike.wang on 2016/11/5.
 */
public class Player {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Card> getCards() {
        return cardsInHand;
    }

    public void setCards(Set<Card> cards) {
        this.cardsInHand = cards;
    }

    public Player(int id, String name){
        setId(id);
        setName(name);
        this.cardsInHand = new HashSet<>();
    }
    public Set<Card> cardsInHand;

    public Card showTopCard(){
        Card maxCard = new Card("方块","1");
        for (Card card:cardsInHand
             ) {
            if(maxCard.compareCards(card)<0){
                maxCard =card;
            }
        }
        return maxCard;
    }
 }
