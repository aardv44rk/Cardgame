package ntnu.idi.idatt.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class HandEvaluatorTest {

    @Test
    void testGetCardValue() {
        assertEquals(14, HandEvaluator.getCardValue('A'));
        assertEquals(13, HandEvaluator.getCardValue('K'));
        assertEquals(12, HandEvaluator.getCardValue('Q'));
        assertEquals(11, HandEvaluator.getCardValue('J'));
        assertEquals(10, HandEvaluator.getCardValue('T'));
        assertEquals(9, HandEvaluator.getCardValue('9'));
        assertEquals(2, HandEvaluator.getCardValue('2'));
    }
    
    @Test
    void testIsFlushTrue() {
        List<Card> flushHand = List.of(
            new Card('H', 'A'),
            new Card('H', '5'),
            new Card('H', 'T'),
            new Card('H', '3'),
            new Card('H', 'K')
        );
        
        assertTrue(HandEvaluator.isFlush(flushHand));
    }
    
    @Test
    void testIsFlushFalse() {
        List<Card> nonFlushHand = List.of(
            new Card('H', 'A'),
            new Card('S', '5'),
            new Card('H', 'T'),
            new Card('H', '3'),
            new Card('H', 'K')
        );
        
        assertFalse(HandEvaluator.isFlush(nonFlushHand));
    }
}