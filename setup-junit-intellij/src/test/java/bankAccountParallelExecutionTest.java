import com.hidetora.BankAccount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Execution(ExecutionMode.CONCURRENT)
@ExtendWith(BankAccountParameterResolver.class)
class bankAccountParallelExecutionTest {
    Logger logger = Logger.getLogger(bankAccountParallelExecutionTest.class.getName());
    @Test
    @DisplayName("Deposit of 5000")
    void testDeposit(BankAccount bankAccount) {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        bankAccount.deposit(5000);
        assertEquals(5000, bankAccount.getBalance());
        logger.info("BankAccount Balance: " + bankAccount.getBalance());
    }

    @Test
    @DisplayName("Deposit of 2000")
    void testDeposit2(BankAccount bankAccount) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        bankAccount.deposit(2000);
        assertEquals(2000, bankAccount.getBalance());
        logger.info("BankAccount Balance: " + bankAccount.getBalance());
    }

    @Test
    @DisplayName("Deposit of 1500")
    void testDeposit3(BankAccount bankAccount) {
        try {
            Thread.sleep(1200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        bankAccount.deposit(5000);
        assertEquals(5000, bankAccount.getBalance());
        logger.info("BankAccount Balance: " + bankAccount.getBalance());
    }
}
