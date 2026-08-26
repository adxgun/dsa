class Solution {

    class Transaction {
        String name;
        int time;
        int amount;
        String city;

        public Transaction(String s) {
            String[] values = s.split(",");
            this.name = values[0];
            this.time = Integer.parseInt(values[1]);
            this.amount = Integer.parseInt(values[2]);
            this.city = values[3];
        }

        public String toString() {
            return String.format("%s,%d,%d,%s", name, time, amount, city);
        }
    }

    public List<String> invalidTransactions(String[] txns) {
        List<Transaction> transactions = new ArrayList<>();
        for (String tx : txns) {
            transactions.add(new Transaction(tx));
        }

        Collections.sort(transactions, (a, b) -> b.time - a.time);
        List<String> result = new ArrayList<>();
        for (Transaction cur : transactions) {
            boolean invalid = cur.amount > 1000;
            if (!invalid) {
                for (int i = 0; i < transactions.size(); i++) {
                    Transaction next = transactions.get(i);
                    if (Math.abs(cur.time - next.time) <= 60 && 
                        cur.name.equals(next.name) && 
                        !cur.city.equals(next.city)) {
                        invalid = true;
                        break;
                    }
                }
            }

            if (invalid) result.add(cur.toString());
        }
        return result;
    }
}