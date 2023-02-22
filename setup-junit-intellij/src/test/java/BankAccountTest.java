import com.hidetora.BankAccount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.time.Duration.ofMillis;
import static java.time.Duration.ofNanos;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testing BankAccount Class Operations")
class BankAccountTest {

    @Test
    @DisplayName("Withdraw of 3000 from 10000")
    void testWithdraw() {
        BankAccount bankAccount = new BankAccount(10000.0, 1000.0);
        bankAccount.withdraw(3000);
        assertEquals(7000.0, bankAccount.getBalance());
    }

    @Test
    @DisplayName("Deposit of 5000 to 15000")
    void testDeposit() {
        BankAccount bankAccount = new BankAccount(15000.0, 1000.0);
        bankAccount.deposit(5000);
        assertEquals(20000.0, bankAccount.getBalance());
    }

    @Test
    @DisplayName("Account is activate")
    void testIsActivate() {
        BankAccount bankAccount = new BankAccount(15000.0, 1000.0, true);
        assertTrue( bankAccount.isActivate());
    }

    @Test
    @DisplayName("Account Holder Name is set")
    void testHolderNameSet() {
        BankAccount bankAccount = new BankAccount(15000.0, 1000.0, false);
        bankAccount.setHolderName("Hidetora");
        assertNotNull(bankAccount.getHolderName());
    }

    @Test
    @DisplayName("Withdraw below minimum balance")
    void testWithdrawBelowMinimumBalance() {
        BankAccount bankAccount = new BankAccount(15000.0, 1000.0, false);
        assertThrows(RuntimeException.class, () -> bankAccount.withdraw(14500));
    }

    @Test
    @DisplayName("Withdraw and Deposit without exception")
    void testWithdrawAndDepositWithoutException() {
        BankAccount bankAccount = new BankAccount(15000.0, 1000.0, false);
        assertAll(
                () -> assertDoesNotThrow(() -> bankAccount.withdraw(1000)),
                () -> assertDoesNotThrow(() -> bankAccount.deposit(1000))
        );
    }

    @Test
    @DisplayName("Deposit Time Out")
    void testDepositTimeOut() {
        BankAccount bankAccount = new BankAccount(15000.0, 1000.0, false);
        assertTimeout(ofNanos(10), () -> bankAccount.deposit(1000));
        assertEquals(0.33, 1.0/3.0, 0.01);
    }

}
