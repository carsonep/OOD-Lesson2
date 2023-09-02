package model;

import java.util.ArrayList;
import java.util.Stack;

public class CoinDispenser {
    public static final int SLOT_NICKELS = 0;
    public static final int SLOT_DIMES = 1;
    public static final int SLOT_QUARTERS = 2;

    private final ArrayList<Stack<Coin>> slots = new ArrayList<>(initialCapacity:3);

    public final int maxNickels;
    public final int maxDimes;
    public final int maxQuarters;

    public CoinDispenser(int maxNickels, int maxDimes, int maxQuarters) {
        this.maxNickels = maxNickels;
        this.maxDimes = maxDimes;
        this.maxQuarters = maxQuarters;

        slots.add(new Stack<Coin>());
        slots.add(new Stack<Coin>());
        slots.add(new Stack<Coin>());
    }
}
