package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.JPanel;

import controller.App;
import model.Coin;
import model.CoinDispenser;

public class AppCanvas extends JPanel {

    public static final int WIDTH = 700;
    public static final int Height = 300;

    public static final int X_SLOT = 90;
    public static final int Y_TITLE = 50;
    public static final int Y_NICKEL = 100;
    public static final int Y_DIME = 170;
    public static final int Y_QUARTER = 240;

    final Font titleFont = new Font("Courier New", Font.BOLD, 30);
    final Font coinTypeFont = new Font("Courier New", Font.ITALIC, 14);

    final Color nickelColor = Color.RED;
    final Color dimeColor = Color.BLUE;
    final Color quarterColor = Color.GREEN;

    public AppCanvas() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));

    }

    private void drawCoin(Graphics2D g2, Coin c) {
        var e = new Ellipse2D.Float(c.getX(), c.getY(), c.getSize(), c.getSize());
        g2.fill(e);

    }

    private void drawCoinSlots(Graphics2D g2) {
        g2.setColor((nickelColor));
        for (var c : App.coinDispenser.getSlot(CoinDispenser.SLOT_NICKELS)) {
            drawCoin(g2, c);
        }
        g2.setColor((dimeColor));
        for (var c : App.coinDispenser.getSlot(CoinDispenser.SLOT_DIMES)) {
            drawCoin(g2, c);
        }
        g2.setColor((quarterColor));
        for (var c : App.coinDispenser.getSlot(CoinDispenser.SLOT_QUARTERS)) {
            drawCoin(g2, c);
        }

    }

    private void drawTextStrings(Graphics2D g2) {
        CoinDispenser coinDispenser = App.coinDispenser;
        g2.setFont(titleFont);
        g2.drawString(
                String.format("Coin Dispenser (balance = %dc)",
                        coinDispenser.getBalance()),
                X_SLOT, Y_TITLE);
        g2.setFont(coinTypeFont);
        g2.drawString(
                String.format("Nickles (%d of %d)",
                        coinDispenser.getNickelCount(), coinDispenser.maxNickels),
                X_SLOT, Y_NICKEL);
        g2.drawString(
                String.format("Dimes (%d of %d)",
                        coinDispenser.getDimeCount(), coinDispenser.maxDimes),
                X_SLOT, Y_DIME);
        g2.drawString(
                String.format("Quarters (%d of %d)",
                        coinDispenser.getQuarterCount(), coinDispenser.maxQuarters),
                X_SLOT, Y_QUARTER);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        drawTextStrings(g2);
        drawCoinSlots(g2);
    }

}
