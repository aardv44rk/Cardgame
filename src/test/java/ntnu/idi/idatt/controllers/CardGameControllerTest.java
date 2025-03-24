package ntnu.idi.idatt.controllers;

import ntnu.idi.idatt.models.Card;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

class CardGameControllerTest {
    
    private CardGameController controller;
    
    @BeforeEach
    void setUp() {
        controller = new CardGameController();
    }
    
    @Test
    void testDealNewHand() {
        controller.dealNewHand(5);
        List<Card> hand = controller.getCurrentHand();
        assertNotNull(hand);
        assertEquals(5, hand.size());
    }
    
    @Test
    void testGetSum() {
        // Create a test hand with known values
        List<Card> testHand = new ArrayList<>();
        testHand.add(new Card('H', 'A')); // 1
        testHand.add(new Card('S', 'K')); // 13
        testHand.add(new Card('D', '5')); // 5
        
        // Use reflection to set the hand
        try {
            java.lang.reflect.Field handField = CardGameController.class.getDeclaredField("currentHand");
            handField.setAccessible(true);
            handField.set(controller, testHand);
        } catch (Exception e) {
            fail("Test setup failed");
        }
        
        assertEquals(19, controller.getSum());
    }
    
    @Test
    void testGetHeartsAsString() {
        List<Card> testHand = new ArrayList<>();
        testHand.add(new Card('H', 'A'));
        testHand.add(new Card('S', 'K'));
        testHand.add(new Card('H', '5'));
        
        try {
            java.lang.reflect.Field handField = CardGameController.class.getDeclaredField("currentHand");
            handField.setAccessible(true);
            handField.set(controller, testHand);
        } catch (Exception e) {
            fail("Test setup failed");
        }
        
        String result = controller.getHeartsAsString();
        assertTrue(result.contains("AH") && result.contains("5H"));
        assertFalse(result.contains("KS"));
    }
    
    @Test
    void testHasQos() {
        List<Card> testHand = new ArrayList<>();
        testHand.add(new Card('S', 'Q'));
        testHand.add(new Card('H', 'K'));
        
        try {
            java.lang.reflect.Field handField = CardGameController.class.getDeclaredField("currentHand");
            handField.setAccessible(true);
            handField.set(controller, testHand);
        } catch (Exception e) {
            fail("Test setup failed");
        }
        
        assertTrue(controller.hasQos());
    }
}