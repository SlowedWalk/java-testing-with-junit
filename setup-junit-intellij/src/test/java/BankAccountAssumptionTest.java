import com.hidetora.BankAccount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

class BankAccountAssumptionTest {
    @Test
    @DisplayName("Test Account activation after creation")
    void testIsActivate() {
        BankAccount bankAccount = new BankAccount(15000.0, 1000.0, true);
        assumingThat(bankAccount != null, () -> assertTrue( bankAccount.isActivate()));
    }
}
