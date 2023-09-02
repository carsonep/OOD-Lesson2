package test;

import model.CoinDispenser;
import model.Dime;
import model.Nickel;
import model.Quarter;

public class CoinDispenserTester {
    public static void main(String[] args) {
        CoinDispenser cd = new CoinDispenser(5, 6, 4);

        cd.insert(new Dime());
        cd.insert(new Dime());
        cd.insert(new Dime());
        cd.insert(new Quarter());
        cd.insert(new Quarter());
        cd.insert(new Nickel());
        cd.insert(new Nickel());
        cd.insert(new Nickel());
        assert cd.getDimeCount() == 3;
        assert cd.getQuarterCount() == 2;
        assert cd.getNickelCount() == 3;

        cd.removeCoinByValue(Nickel.VALUE);
        assert cd.getNickelCount() == 2;
    }
}
