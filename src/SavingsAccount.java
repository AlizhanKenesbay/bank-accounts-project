import java.math.BigDecimal;

public class SavingsAccount extends Account {

    @Override
    public void pay(BigDecimal amount) {
        System.out.println("Вы не можете оплатить со сберегательного счета");
    }

    @Override
    public void transfer(Account account, BigDecimal amount) {
        if (balance.compareTo(amount) >= 0) { // if (balance >= amount)
            balance = balance.subtract(amount);
            account.addMoney(amount);
            if (account instanceof CreditAccount) {
                System.out.println("Перевод на кредитный счет в размере " + amount + " был выполнен");
            } else if (account instanceof CheckingAccount) {
                System.out.println("Перевод на расчетный счет в размере " + amount + " был выполнен");
            } else {
                System.out.println("Ошибка, счет не найден");
            }
        } else {
            System.out.println("Недостаточно денег для перевода");
        }
    }

    @Override
    public void addMoney(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) >= 0) { // if (amount >= 0)
            balance = balance.add(amount);
            System.out.println("Баланс сберегательного счета пополнен на: " + amount);
        } else {
            System.out.println("Ошибка, введена отрицательная сумма");
        }
    }
}