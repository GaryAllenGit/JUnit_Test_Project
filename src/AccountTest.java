import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    private Account testAccount;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        testAccount = new Account();
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @Test
    void testConstructor(){
        Account ac = new Account();
        assertTrue(ac.getBalance() == 0, "Account no-args constructor failed - not initialised to 0");
    }

    @Test
    void testConstructor1(){
        Account ac = new Account(5.55);
        assertTrue(ac.getBalance() == 5.55, "Account constructor failed - not initialised to 5.55");
    }

    @Test
    void getBalance() {
        assertTrue(testAccount.getBalance() == 0, "getBalance not returning 0");
    }

    @Test
    void getBalance1() {
        testAccount.credit(10.01);
        assertTrue(testAccount.getBalance() == 10.01, "getBalance not returning 10.01 after debit");
    }


    @Test
    void credit() {
        testAccount.credit(10.50);
        assertTrue(testAccount.getBalance() == 10.50, "Account not credited correctly");
    }

    @Test
    void debit() {
        try {
            testAccount.credit(10.50);
            testAccount.debit(5.25);
            assertTrue(testAccount.getBalance() == 5.25, "Account not debited correctly");
        } catch (Overdrawn overdrawn) {
            fail("Unexpected Exception from debit");
        }
    }

    @Test
    void debit1() {
        try {
            testAccount.debit(0.01);
            fail("Failed to throw Overdrawn exception");
        } catch (Overdrawn overdrawn) {
            assertTrue(testAccount.getBalance() == 0.00, "Account allowed to go overdrawn");
        }
    }

    @Test
    void debit2() {
        try {
            testAccount.credit(1.00);
            testAccount.debit(1.00);
            assertTrue(testAccount.getBalance() == 0.00, "Account not debited correctly");
        } catch (Overdrawn overdrawn) {
            fail("Unexpected Exception from debit - treating balance of 0.00 as overdrawn");
        }
    }
}
