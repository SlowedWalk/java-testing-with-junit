import com.hidetora.BankAccount;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BankAccountBeforAndAfterTest {
    static BankAccount bankAccount;

    @BeforeEach
    public void prepTest() {
        bankAccount = new BankAccount(500, 0);
    }
    @Test
    void testWithdraw() {
        bankAccount.withdraw(300);
        assertEquals(200, bankAccount.getBalance());
    }

    @Test
    void testDeposit() {
        bankAccount.deposit(500);
        assertEquals(1000, bankAccount.getBalance());
    }
}
