class Bank {

    private static final class Account {
        int id = -1;
        long balance = 0;

        public Account(int id, long bal) {
            this.id = id;
            this.balance = bal;
        }
    }

    private final Map<Integer, Account> accounts = new HashMap<>();
    public Bank(long[] balance) {
        int n = balance.length;
        for (int i = 0; i < n; i++) {
            accounts.put(i + 1, new Account(i + 1, balance[i]));
        }
    }
    
    public boolean transfer(int account1, int account2, long money) {
        Account from = accounts.get(account1);
        Account to = accounts.get(account2);
        if (from == null || to == null) return false;
        if (money > from.balance) return false;

        from.balance -= money;
        to.balance += money;
        return true;
    }
    
    public boolean deposit(int account, long money) {
        Account acc = accounts.get(account);
        if (acc == null) return false;

        acc.balance += money;
        return true;
    }
    
    public boolean withdraw(int account, long money) {
        Account acc = accounts.get(account);
        if (acc == null) return false;

        if (money > acc.balance) return false;
        acc.balance -= money;
        return true;
    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */