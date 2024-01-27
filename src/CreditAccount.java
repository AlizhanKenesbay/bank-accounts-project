import java.math.BigDecimal;

public class CreditAccount extends Account {
    @Override
    public void pay(BigDecimal amount) {
        if (balance.compareTo(BigDecimal.ZERO) <= 0) { // if (balance <= 0)
            balance = balance.subtract(amount);
            System.out.println("Оплата прошла успешно");
        } else {
            System.out.println("Ошибка, ваш счет имеет положительный баланс");
        }
    }

    @Override
    public void transfer(Account account, BigDecimal amount) {
        if (balance.compareTo(BigDecimal.ZERO) <= 0) { // if (balance <= 0)
            balance = balance.subtract(amount);
            account.addMoney(amount);
            if (account instanceof SavingsAccount) {
                System.out.println("Перевод на сберегательный счет в размере " + amount + " был выполнен");
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
        BigDecimal potentialBalance = balance.add(amount);

        if (potentialBalance.compareTo(BigDecimal.ZERO) >= 0) { // if (potentialBalance >= 0)
            balance = BigDecimal.ZERO;
            System.out.println("Баланс кредитного счета пополнен на: " + amount);
        } else {
            System.out.println("Ошибка, введена отрицательная сумма");
        }
    }
}