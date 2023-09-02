package test;

import model.Coin;
import model.Dime;
import model.Nickel;
import model.Quarter;

public class Ref {
    public static void main(String[] args) {
        Coin c;
        // c = new Coin(15,20)

        c = new Dime(); // super <= sub
        Dime d = new Dime();
        c = d;
        // d = c;

        Coin[] array = new Coin[5];
        array[0] = new Dime();
        array[1] = new Quarter();
        array[2] = new Nickel();
        array[3] = new Dime();
        array[4] = new Dime();

        for (var coin : array) {
            System.out.println(coin.getValue());
        }

    }
}
