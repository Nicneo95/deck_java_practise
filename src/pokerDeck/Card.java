package pokerDeck;

public class Card {
    // 1. Set the attribute of the class
    // cards have suit - spades, clubs, hearts, diamonds
    private final String suit;
    // the name of the card 
    private final String name;
    // value of the cards eg - jack = 10, 2 = 2
    private final Integer value;

    // 2. set the constructor to call card
    public Card(String suit, String name, Integer value) {
        this.suit = suit;
        this.name = name;
        this.value = value;
    }

    // get the attribute since is a private class
    // we don't need set because we not going to change the card 
    public String getSuit() { return suit; }
    public String getName() { return name; }
    public Integer getValue() { return value; }

    // overide the toString method so when we print the format will be like this 
    @Override
    public String toString() {
        return "Card [suit=" + suit + ", name=" + name + ", value=" + value + "]";
    }

}
