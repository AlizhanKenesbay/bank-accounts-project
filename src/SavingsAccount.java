public class SavingsAccount extends Account {

    @Override
    public void pay(int amount) {
        System.out.println("Вы не можете оплатить со сберегательного счета");
    }

    @Override
    public void transfer(Account account, int amount) {
        if (balance >= amount) {
            balance -= amount;
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
    public void addMoney(int amount) {
        if (amount >= 0) {
            balance += amount;
            System.out.println("Баланс сберегательного счета пополнен на: " + amount);
        } else {
            System.out.println("Ошибка, введена отрицательная сумма");
        }
    }
}