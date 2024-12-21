package org.example;

public enum Operation {
    ADD("+", "Addition"),
    SUBTRACT("-", "Soustraction"),
    MULTIPLY("*", "Multiplication"),
    DIVIDE("/", "Division");

    private final String symbol;
    private final String description;

    Operation(String symbol, String description) {
        this.symbol = symbol;
        this.description = description;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getDescription() {
        return description;
    }

    public static Operation fromSymbol(String symbol) {
        for (Operation op : values()) {
            if (op.symbol.equals(symbol)) {
                return op;
            }
        }
        throw new IllegalArgumentException("Symbole d'opération invalide : " + symbol);
    }
}
