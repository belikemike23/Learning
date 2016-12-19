package com.imooc.pokergame;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by mike.wang on 2016/11/13.
 */
public class PlayCards {

    public Map<Integer ,Player> playerMap;
    public PlayCards(){
        this.playerMap = new HashMap<>();
    }

    public void putPlayers(){
        int i = 1;
        while (i <3) {
            System.out.println("请输入第" + i + "位玩家的的Id和姓名");
            Integer id=0;
            Boolean inputBolean;
            do{
                inputBolean=true;
                System.out.println("输入Id:");
                Scanner scanner = new Scanner(System.in);
                try{
                    id=scanner.nextInt();
                }catch (Exception e){
                    System.out.println("请输入一个数字");
                    inputBolean = false;
                }
            }while (inputBolean==false);
            System.out.println("输入姓名:");
            Scanner scanner = new Scanner(System.in);
            String name = scanner.next();
            playerMap.put(id, new Player(id, name));
            i++;
        }
    }

    public void showPlayers(){
        Set<Integer> keyset = playerMap.keySet();
        for (Integer i:keyset
             ) {
            System.out.println(i);
            System.out.println("编号："+playerMap.get(i).getId()+"\n"+"名称："+playerMap.get(i).getName());
        }
    }

    public void showHandCards(){
        Set<Integer> keyset = playerMap.keySet();
        System.out.println("玩家各自手牌为");
        for (Integer i : keyset
             ) {
            System.out.println(playerMap.get(i).getName()+":");
            for (Card card:playerMap.get(i).cardsInHand
                 ) {
                System.out.println(card.getColor()+card.getPoint());
            }

        }
    }

    public static void main(String[] args) {
        CardsList cardlist =new CardsList();
        cardlist.creatCards();
        cardlist.shuffleCards();
        PlayCards playCards = new PlayCards();
        playCards.putPlayers();
        playCards.showPlayers();
        System.out.println("发牌开始");
        int j = playCards.playerMap.size();
        int i =0;
        List<Card> cardsToDeal = cardlist.cards;
        while (i<2){
            for(Integer k:playCards.playerMap.keySet()){
                System.out.println("玩家："+ playCards.playerMap.get(k).getName() +"拿牌");
                Random random = new Random();
                int r = random.nextInt(cardsToDeal.size());
                playCards.playerMap.get(k).cardsInHand.add(cardsToDeal.get(r));
                cardsToDeal.remove(r);
            }
            i++;
        }
        System.out.println("发牌结束，开始游戏");
        Card biggestCard=new Card("方块","2");
        int biggestPlayer= 0;
        for(Integer k:playCards.playerMap.keySet()){
            Card topCard = playCards.playerMap.get(k).showTopCard();
            System.out.println(playCards.playerMap.get(k).getName()+"的手牌最大是："+topCard.getColor()+topCard.getPoint());
            biggestPlayer = (topCard.compareCards(biggestCard))>0?k:biggestPlayer;
            biggestCard=(topCard.compareCards(biggestCard))>0?topCard:biggestCard;
        }
        System.out.println("获胜的是："+(playCards.playerMap.get(biggestPlayer).getName()));
        playCards.showHandCards();
        }
    }
