import com.hidetora.BankAccount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BanckAccountAssertionTest {
    @Test
    @DisplayName("Withdraw of 3000 from 10000")
    public void testWithdraw() {
        BankAccount bankAccount = new BankAccount(10000.0, 1000.0);
        bankAccount.withdraw(3000);
        assertEquals(7000.0, bankAccount.getBalance());
    }

    @Test
    @DisplayName("Deposit of 5000 to 15000")
    public void testDeposit() {
        BankAccount bankAccount = new BankAccount(15000, 1000);
        bankAccount.deposit(5000);
        assertEquals(20000, bankAccount.getBalance());
    }

    @Test
    @DisplayName("Withdraw will be negative")
    public void testWithdrawNotStuckAtZero() {
        BankAccount bankAccount = new BankAccount(500, -1000);
        bankAccount.withdraw(800);
        assertNotEquals(0, bankAccount.getBalance());
    }
}
