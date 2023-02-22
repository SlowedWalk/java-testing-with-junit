import com.hidetora.BankAccount;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

public class BankAccountParameterResolver implements ParameterResolver {
    /**
     * @param parameterContext
     * @param extensionContext
     * @return
     * @throws ParameterResolutionException
     */
    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext.getParameter().getType() == BankAccount.class;
    }

    /**
     * @param parameterContext
     * @param extensionContext
     * @return
     * @throws ParameterResolutionException
     */
    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return new BankAccount(0, 0);
    }
}
