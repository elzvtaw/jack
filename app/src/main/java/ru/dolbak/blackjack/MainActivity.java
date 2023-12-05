package ru.dolbak.blackjack;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    void putCard(int slot, Card card){
        int[] slots = {R.id.dealer_card_4, R.id.dealer_card_5, R.id.dealer_card_3,
                R.id.dealer_card_2, R.id.dealer_card_1, R.id.player_card_5, R.id.player_card_4,
                R.id.player_card_2, R.id.player_card_3, R.id.player_card_1};
        ImageView imageView = findViewById(slots[slot]);
        int cardDrawableID = CardMisc.CardToImageID(card);
        imageView.setImageDrawable(getResources().getDrawable(cardDrawableID));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Deck deck = new Deck();
        Card card1 = deck.take();
        Card card2 = deck.take();
        putCard(5, card1);
        putCard(6, card2);

        int dealerPoints =0;
        int dealerCards = 0;
        while (dealerPoints <16 && dealerCards <5 ){
            Card card = deck.take();
            putCard(dealerCards, card);
            dealerCards++;
            dealerPoints += card.rate.getPoints();
        }
    }
}