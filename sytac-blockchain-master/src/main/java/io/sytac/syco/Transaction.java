package io.sytac.syco;

public class Transaction {

    private final String from;
    private final String to;
    private final Double amount;


    public Transaction(String from, String to, Double amount) {
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", amount=" + amount +
                '}';
    }
}
