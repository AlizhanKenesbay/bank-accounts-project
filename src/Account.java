import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class Account {
    BigDecimal balance = new BigDecimal(0);

    public abstract void pay(BigDecimal amount);

    public abstract void transfer(Account account, BigDecimal amount);

    public abstract void addMoney(BigDecimal amount);

    public BigDecimal getBalance() {
        return balance.setScale(2, RoundingMode.CEILING);
    }
}