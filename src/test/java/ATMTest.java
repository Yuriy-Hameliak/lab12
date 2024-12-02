import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import lab12.task1.ATM;

class ATMTest {

    @Test
    void testChainOfSections() {
        ATM atm = new ATM();
        atm.giveMoney(700);
    }

    @Test
    void testUnprocessableAmountInATM() {
        ATM atm = new ATM();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            atm.giveMoney(750);
        });
        assertEquals("Hernia sia stala", exception.getMessage());
    }

    @Test
    void testExactDenominationAmount() {
        ATM atm = new ATM();
        atm.giveMoney(1500);
    }

    @Test
    void testZeroAmount() {
        ATM atm = new ATM();
        atm.giveMoney(0);
    }

    @Test
    void testLargeAmount() {
        ATM atm = new ATM();
        atm.giveMoney(3200);
    }
}
