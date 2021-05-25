package org.denamyte.hyperskill.sandbox;

import java.lang.reflect.Field;

public class AccountUtils {

    private AccountUtils() { }

    public static void increaseBalance(Account account, long amount) {
        try {
            final Field balance = Account.class.getDeclaredField("balance");
            balance.setAccessible(true);
            balance.set(account, (Long) balance.get(account) + amount);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Account a = new Account(10);
        increaseBalance(a, 15);
        System.out.println(a.getBalance());
    }
}

class Account {
    private long balance;

    public Account(long balance) {
        this.balance = balance;
    }

    public long getBalance() {
        return balance;
    }

    // some other methods
}

