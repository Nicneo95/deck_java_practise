package pokerDeck;

import java.security.SecureRandom;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class Deck {
    // 1. name the attribute 
    // a deck will have suit that contain spade, diamond, club and heart
    public static final String[] SUITS = { "Spade", "Diamond", "Clubs", "Heart" };
    // the name of the card
    public static final String[] CARD_NAME = { 
        "Ace", "Two", "Three", "Four",
        "Five", "Six", "Seven", "Eight",
        "Nine", "Ten", "Jack", "Queen", "King"
    };
    // the value of the card 
    public static final Integer[] CARD_VALUES = {
        1, 2, 3, 4,
        5, 6, 7, 8,
        9, 10, 10, 10, 10
    };
    // create a list to store the cards 
    private List<Card> cards = new LinkedList<>();

    // 2. constructor 
    public Deck() {
        this.cards = createDeck();
    }

    // method to take the first card from the deck 
    // we use optional when we dont have a clear answer if we return null or a non null value 
    public Optional<Card> take() {
        if (cards.size() > 0) {
            // remove the first card from the card list 
            Card c = cards.remove(0);
            // return a value 
            return Optional.of(c);

        }
        // return empty
        return Optional.empty();
    }
    // this method of shuffling we are randomly switching to decks
    // might not shuffle properly
    public void shuffle() {
        Random rnd = new SecureRandom();

        for (Integer i = 0; i < cards.size(); i++) {
            Integer idx0 = rnd.nextInt(cards.size());
            Integer idx1 = rnd.nextInt(cards.size());
            Card card0 = cards.get((int)idx0);
            Card card1 = cards.get((int)idx1);
            cards.set(idx0, card1);
            cards.set(idx1, card0);
        }
    }
    // this method of shuffling is taking the card from the top
    public void shuffleAlt() {
        Random rnd = new SecureRandom();

        for (Integer i = 0; i < cards.size(); i++) {
            Integer idx1 = rnd.nextInt(cards.size());
            Card card0 = cards.get((int)i);
            Card card1 = cards.get((int)idx1);
            cards.set(i, card1);
            cards.set(idx1, card0);
        }
    }
    // creating a deck
    private List<Card> createDeck() {
        List<Card> cards = new LinkedList<>();
        for (String suit: SUITS)
            for (Integer i = 0; i < CARD_NAME.length; i++) {
                Card card = new Card(suit, CARD_NAME[i], CARD_VALUES[i]);
                cards.add(card);
            }
        return cards;
    }

    @Override
    public String toString() {
        return "Deck [cards=" + cards + "]";
    }
}