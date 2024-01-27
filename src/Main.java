public class Main {
    public static void main(String[] args) {
        SavingsAccount savingsAccount = new SavingsAccount();
        CreditAccount creditAccount = new CreditAccount();
        CheckingAccount checkingAccount = new CheckingAccount();

        savingsAccount.addMoney(1000);
        creditAccount.addMoney(1000);
        checkingAccount.addMoney(-5000);
        System.out.println();

        System.out.println("Баланс на сберегательном счету: " + savingsAccount.getBalance());
        System.out.println("Баланс на кредитном счету: " + creditAccount.getBalance());
        System.out.println("Баланс на расчетном счету: " + checkingAccount.getBalance());
        System.out.println();

        savingsAccount.pay(1000);
        savingsAccount.transfer(creditAccount, 1);
        savingsAccount.addMoney(5000);
        System.out.println();

        creditAccount.addMoney(1000);
        System.out.println("Баланс на кредитном счету: " + creditAccount.getBalance());
        creditAccount.transfer(savingsAccount, 1000);
        System.out.println("Баланс на кредитном счету: " + creditAccount.getBalance());
    }
}