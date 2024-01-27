public class CheckingAccount extends Account {
    @Override
    public void pay(int amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Оплата прошла успешно");
        } else {
            System.out.println("Ошибка, ваш счет имеет положительный баланс");
        }
    }

    @Override
    public void transfer(Account account, int amount) {
        if (balance >= amount) {
            balance -= amount;
            account.addMoney(amount);
            if (account instanceof SavingsAccount) {
                System.out.println("Перевод на сберегательный счет в размере " + amount + " был выполнен");
            } else if (account instanceof CreditAccount) {
                System.out.println("Перевод на кредитный счет в размере " + amount + " был выполнен");
            } else {
                System.out.println("Ошибка, счет не найден");
            }
        } else {
            System.out.println("Недостаточно денег для перевода");
        }
    }

    @Override
    public void addMoney(int amount) {
        if (amount >= 0) {
            balance += amount;
            System.out.println("Баланс сберегательного счета пополнен на: " + amount);
        } else {
            System.out.println("Ошибка, введена отрицательная сумма");
        }
    }
}