import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        SavingsAccount savingsAccount = new SavingsAccount();
        CreditAccount creditAccount = new CreditAccount();
        CheckingAccount checkingAccount = new CheckingAccount();

        savingsAccount.addMoney(BigDecimal.valueOf(1000.438));
        creditAccount.addMoney(BigDecimal.valueOf(1000.756));
        checkingAccount.addMoney(BigDecimal.valueOf(-5000.1));
        System.out.println();

        System.out.println("Баланс на сберегательном счету: " + savingsAccount.getBalance());
        System.out.println("Баланс на кредитном счету: " + creditAccount.getBalance());
        System.out.println("Баланс на расчетном счету: " + checkingAccount.getBalance());
        System.out.println();

        savingsAccount.pay(BigDecimal.valueOf(1000));
        savingsAccount.transfer(creditAccount, BigDecimal.valueOf(1));
        savingsAccount.addMoney(BigDecimal.valueOf(5000.52));
        System.out.println();

        creditAccount.addMoney(BigDecimal.valueOf(1000));
        System.out.println("Баланс на кредитном счету: " + creditAccount.getBalance());
        creditAccount.transfer(savingsAccount, BigDecimal.valueOf(1000));
        System.out.println("Баланс на кредитном счету: " + creditAccount.getBalance());
    }
}