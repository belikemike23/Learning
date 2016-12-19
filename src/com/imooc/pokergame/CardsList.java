package com.imooc.pokergame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by mike.wang on 2016/11/13.
 */
public class CardsList {

    public List<Card> cards = new ArrayList<>();
    String[] colorArray = {"黑桃","红桃","梅花","方块"};
    String[] pointArray = {"1","2","3","4","5","6","7","8","9","J","Q","K","A"};
    public void creatCards(){
        System.out.println("创建扑克牌");
        System.out.println("扑克牌为：");
        for(int i =0;i<4;i++){
            for(int j=0;j<13;j++) {
                cards.add(new Card(colorArray[i],pointArray[j]));
            }
        }
        for (Card card:cards
                ) {
            System.out.print(card.getColor()+card.getPoint()+",");
        }
    }

    public void shuffleCards(){
//        Card[] shufflecards =new Card[cards.size()];
//        cards.toArray(shufflecards);
        System.out.println("开始洗牌");
        Collections.shuffle(cards);
        System.out.println("洗牌完毕");
//        for (Card card:cards
//                ) {
//            System.out.print(card.getColor()+card.getPoint()+",");
//        }
    }
}
