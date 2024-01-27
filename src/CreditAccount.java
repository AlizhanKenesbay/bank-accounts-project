public class CreditAccount extends Account {
    @Override
    public void pay(int amount) {
        if (balance <= 0) {
            balance -= amount;
            System.out.println("Оплата прошла успешно");
        } else {
            System.out.println("Ошибка, ваш счет имеет положительный баланс");
        }
    }

    @Override
    public void transfer(Account account, int amount) {
        if (balance <= 0) {
            balance -= amount;
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
    public void addMoney(int amount) {
        int potentialBalance = balance + amount;

        if (potentialBalance >= 0) {
            balance = 0;
            System.out.println("Баланс кредитного счета пополнен на: " + amount);
        } else {
            System.out.println("Ошибка, введена отрицательная сумма");
        }
    }
}