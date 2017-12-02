package com.spensoft.testgame;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Card {
    private int rank;
    private int suit;
    TextureRegion face;

    public Card(int rank, int suit, TextureRegion face){
        this.rank = rank;
        this.suit = suit;
        this.face = face;
    }

    public int getRank(){return rank; }

    public int getSuit() {return suit; }

    public TextureRegion getFace() { return face; }
}

