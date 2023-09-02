package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Coin;
import model.CoinDispenser;
import model.Dime;
import model.Nickel;
import model.Quarter;
import view.AppCanvas;

public class InsertButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        Coin newCoin = null;
        CoinDispenser coinDispenser = App.coinDispenser;
        int selectedIndex = coinDispenser.selectedSlotIndex;
        int x = 0;
        int y = 0;

        if (selectedIndex == CoinDispenser.SLOT_NICKELS) {
            assert coinDispenser.getNickelCount() < coinDispenser.maxNickels : "Nicket Slot is full";
            newCoin = new Nickel();
            x = AppCanvas.X_SLOT + coinDispenser.getNickelCount() * (Nickel.SIZE + 10);
            y = AppCanvas.Y_NICKEL;
        } else if (selectedIndex == CoinDispenser.SLOT_DIMES) {
            assert coinDispenser.getDimeCount() < coinDispenser.maxDimes : "Dime Slot is full";
            newCoin = new Dime();
            x = AppCanvas.X_SLOT + coinDispenser.getDimeCount() * (Dime.SIZE + 10);
            y = AppCanvas.Y_DIME;
        } else if (selectedIndex == CoinDispenser.SLOT_QUARTERS) {
            assert coinDispenser.getQuarterCount() < coinDispenser.maxQuarters : "Quarter Slot is full";
            newCoin = new Quarter();
            x = AppCanvas.X_SLOT + coinDispenser.getQuarterCount() * (Quarter.SIZE + 10);
            y = AppCanvas.Y_QUARTER;
        }
        assert newCoin != null : "Unknown coin type to insert";
        newCoin.setLocation(x, y);
        coinDispenser.getSlot(selectedIndex).push(newCoin);
        App.win.updateWindow();
    }
}
