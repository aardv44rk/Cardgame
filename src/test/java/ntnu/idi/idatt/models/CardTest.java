package ntnu.idi.idatt.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CardTest {
    
    @Test
    void testConstructorAndGetters() {
        Card card = new Card('H', 'A');
        assertEquals('H', card.getSuit());
        assertEquals('A', card.getValue());
    }
    
    @Test
    void testToString() {
        Card card1 = new Card('H', 'A');
        assertEquals("AH", card1.toString());
        
        Card card2 = new Card('S', 'K');
        assertEquals("KS", card2.toString());
        
        Card card3 = new Card('D', 'T');
        assertEquals("TD", card3.toString());
    }
}