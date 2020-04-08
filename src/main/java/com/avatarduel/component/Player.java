package com.avatarduel.component;
import java.util.*;
import com.avatarduel.model;

public class Player{
    private String name;
    private int health;
    private Stack<Card> deck;
    private List<IHandCard> hand; //Ini harus IHandCard karna method play adanya di IHandCard
    private List<BoardCard> board; // Ini juga harus BoardCard biar bisa pake dekorator
    private List<SkillBoardCard> skillBoard; // Kalo perlu Cardnya, pake method getCardInstance() ya
    private int maxWater, currentWater,
                maxEarth, currentEarth,
                maxFire, currentFire,
                maxAir, currentAir;

    public Player(String name, int health)
    {
        this.name = name;
        this.health = health;
        this.deck = new Stack<Card>();
        this.hand = new ArrayList<IHandCard>();
        this.board = new ArrayList<BoardCard>();
        this.skillBoard = new ArrayList<SkillBoardCard>();
        this.maxWater = 0; this.currentWater = 0;
        this.maxEarth = 0; this.currentEarth = 0;
        this.maxFire = 0; this.currentFire = 0;
        this.maxAir = 0; this.currentAir = 0;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setHealth(int health){
        this.health = health;
	}

    public int getHealth(){
        return this.health;
	}

    public void setMaxElement(String element, int val ){
        switch(element){
            case ("FIRE"):
                this.maxFire = val;
            case ("WATER"):
                this.maxWater = val;
            case ("EARTH"):
                this.maxEarth = val;
            case ("AIR"):
                this.maxAir = val;
            default:
                System.out.println("No Match");
		}
	}

    public int getMaxElement(String element){
        switch(element){
            case ("FIRE"):
                return this.maxFire;
            case ("WATER"):
                return this.maxWater;
            case ("EARTH"):
                return this.maxEarth;
            case ("AIR"):
                return this.maxAir;
            default:
                System.out.println("No Match");
                return;
		}
	}

    public void setCurrentElement(String element, int val ){
        switch(element){
            case ("FIRE"):
                this.currentFire = val;
            case ("WATER"):
                this.currentWater = val;
            case ("EARTH"):
                this.currentEarth = val;
            case ("AIR"):
                this.currentAir = val;
            default:
                System.out.println("No Match");
		}
	}

    public int getCurrentElement(String element){
        switch(element){
            case ("FIRE"):
                return this.currentFire;
            case ("WATER"):
                return this.currentWater;
            case ("EARTH"):
                return this.currentEarth;
            case ("AIR"):
                return this.currentAir;
            default:
                System.out.println("No Match");
                return;
		}
	}

    public void draw(){
        //pop card dari deck
        Card top = deck.pop();
        HandCard factory = HandCardFactory.getFactory(top); // Gunakan factory method untuk menentukan factory yang akan digunakan
        // TODO, kasih exception kalo factory = null
        hand.add(factory.createHandCard(top, this)); // tambahkan IHandCard yang dibuat factory ke hand
	}

    public void play(int idx){
        System.out.println("belum diimplementasi");
        IHandCard card = hand.remove(idx);
        card.play();
        //TODO, ubah IHandCard jadi BoardCard/skillBoardCard lalu put ke boar/skillBoard
	}

    public void rotate(int idx){
        board.get(idx).rotate();
	}

    public void attack(int idx){
        //menyerang player/character musuh menggunakan character di board
        System.out.println("belum diimplementasi");
        //yang ngehandle attack board atau player?
        //buat interface targetable buat attack??
	}

    public void destroy(int idx){
        //membuang kartu skill di board;
        System.out.println("belum diimplementasi");
        //yang bisa didestroy kan skill sm character, cara tahunya gimana?
	}
}
