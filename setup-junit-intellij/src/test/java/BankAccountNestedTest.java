import com.hidetora.BankAccount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountNestedTest {
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
        assertTrue(bankAccount.isActivate());
    }

    @Nested
    class whenBakanceEqualsZero {
        @Test
        @DisplayName("Withdraw below minimum balance")
        void testWithdrawMinimumBalanceIsZero() {
            BankAccount bankAccount = new BankAccount(0, 0    , true);
            assertThrows(RuntimeException.class, () -> bankAccount.withdraw(500));
        }

        @Test
        @DisplayName("Withdraw below negative balance")
        void testWithdrawMinimumBalanceIsNegative() {
            BankAccount bankAccount = new BankAccount(0, -1000, true);
            bankAccount.withdraw(500);
            assertEquals(-500, bankAccount.getBalance());
        }
    }

}
