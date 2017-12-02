package com.spensoft.testgame;
 /* -----------------------------------------------------
      Deck: a deck of cards
      ----------------------------------------------------- */

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class DeckOfCards
{
    public static final int NCARDS = 52;

    private Card[] deckOfCards;         // Contains all 52 cards
    private int currentCard;            // deal THIS card in deck

    public DeckOfCards( )    // Constructor
    {
        deckOfCards = new Card[ NCARDS ];

        int i = 0;

        Texture master = new Texture("cards.png");
        int x = 0;
        int y = 0;

        for ( int suit = 1; suit <= 4; suit++ ) {
            for (int rank = 1; rank <= 13; rank++) {
                TextureRegion face = new TextureRegion(master, x, y, 73, 98);
                deckOfCards[i++] = new Card(rank, suit, face);
                x += 73;
            }
            x=0;
            y+=98;
        }
        currentCard = 0;
    }

    /* ---------------------------------
      shuffle(n): shuffle the deck
      --------------------------------- */
    public void shuffle(int n)
    {
        int i, j, k;

        for ( k = 0; k < n; k++ )
        {
            i = (int) ( NCARDS * Math.random() );  // Pick 2 random cards
            j = (int) ( NCARDS * Math.random() );  // in the deck

   	     /* ---------------------------------
   		swap these randomly picked cards
   		--------------------------------- */
            Card tmp = deckOfCards[i];
            deckOfCards[i] = deckOfCards[j];
            deckOfCards[j] = tmp;;
        }

        currentCard = 0;   // Reset current card to deal
    }
    /* -------------------------------------------
      deal(): deal deckOfCards[currentCard] out
      ------------------------------------------- */
    public Card deal()
    {
        if ( currentCard < NCARDS )
        {
            return ( deckOfCards[ currentCard++ ] );
        }
        else
        {
            System.out.println("Out of cards error");
            return ( null );  // Error;
        }
    }

    public String toString()
    {
        String s = "";
        int k;

        k = 0;
        for ( int i = 0; i < 4; i++ )
        {
            for ( int j = 1; j <= 13; j++ )
                s += (deckOfCards[k++] + " ");

            s += "\n";
        }
        return ( s );
    }
}