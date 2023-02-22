import com.hidetora.BankAccount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(BankAccountParameterResolver.class)
class BankAccountDITest {
    Logger logger = Logger.getLogger(BankAccountDITest.class.getName());
    @DisplayName("Deposit of 5000 to 15000")
    @RepeatedTest(5)
    void testDeposit(BankAccount bankAccount) {
        bankAccount.deposit(5000);
        assertEquals(5000, bankAccount.getBalance());
    }

    @DisplayName("Deposit of 5000 to 15000")
    @RepeatedTest(5)
    void testDepositRepetitionInfo(BankAccount bankAccount, RepetitionInfo repetitionInfo) {
        bankAccount.deposit(5000);
        assertEquals(5000, bankAccount.getBalance());
        logger.info("BankAccount Balance: " + bankAccount.getBalance());
        logger.info("Repetition: " + repetitionInfo.getCurrentRepetition());
    }
}
