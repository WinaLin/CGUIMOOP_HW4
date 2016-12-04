package hw4;

import java.util.ArrayList;

public class Player {

    private String name;
    private int chips;
    private int bet = 0;
    private ArrayList<Card> oneRoundCard;

    public Player(String name, int chips) {
        this.name = name;
        this.chips = chips;
    }

    public String get_name() {
        return name;
    }

    public int make_bet() {
        bet = 1;
        return bet;
    }

    public void setOneRoundCard(ArrayList<Card> cards) {
        oneRoundCard = cards;
    }

    public boolean hit_me() {
        int tol = getTotalValue();
        if(tol<=16){
            return true;
        }else{
            return false;
        }
        
    }

    public int getTotalValue() {
        int total = 0;
        for(int i = 0;i<oneRoundCard.size();i++){
            if(oneRoundCard.get(i).getRank()>=2&&oneRoundCard.get(i).getRank()<=10){
                total+=oneRoundCard.get(i).getRank();
            }else if(oneRoundCard.get(i).getRank()==11||oneRoundCard.get(i).getRank()==1||oneRoundCard.get(i).getRank()==13){
                total+=10;
            }else if(oneRoundCard.get(i).getRank() == 1){
                if(total<=11){
                    total+=11;
                }else{
                    total+=1;
                }
            }
        }
        return total;
            
    }

    public int get_current_chips() {
        return chips;
    }

    public void increase_chips(int diff) {
        chips = chips+diff;
    }

    public void say_hello() {
        System.out.println("Hello, I am " + name + ".");
        System.out.println("I have " + chips + " chips.");
    }
}
