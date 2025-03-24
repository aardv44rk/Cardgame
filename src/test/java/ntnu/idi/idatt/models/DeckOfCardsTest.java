package ntnu.idi.idatt.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class DeckOfCardsTest {

    @Test
    void testConstructor() {
        DeckOfCards deck = new DeckOfCards();
        assertEquals(52, deck.getNumberOfCards());
    }
    
    @Test
    void testDealCard() {
        DeckOfCards deck = new DeckOfCards();
        Card card = deck.dealCard();
        assertNotNull(card);
        assertEquals(51, deck.getNumberOfCards());
    }
    
    @Test
    void testDealHand() {
        DeckOfCards deck = new DeckOfCards();
        List<Card> hand = deck.dealHand(5);
        assertEquals(5, hand.size());
        assertEquals(47, deck.getNumberOfCards());
    }
    
    @Test
    void testDealHandThrowsExceptionWhenNotEnoughCards() {
        DeckOfCards deck = new DeckOfCards();
        assertThrows(IllegalStateException.class, () -> deck.dealHand(53));
    }
    
    @Test
    void testShuffle() {
        DeckOfCards deck1 = new DeckOfCards();
        DeckOfCards deck2 = new DeckOfCards();
        
        deck1.shuffle();
        // Statistical test - this may occasionally fail by chance
        // We deal 10 cards from each deck and check if they're different
        List<Card> hand1 = deck1.dealHand(10);
        List<Card> hand2 = deck2.dealHand(10);
        
        boolean allSame = true;
        for (int i = 0; i < hand1.size(); i++) {
            if (!hand1.get(i).toString().equals(hand2.get(i).toString())) {
                allSame = false;
                break;
            }
        }
        assertFalse(allSame, "Shuffle didn't change card order");
    }
}