package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;

import controller.App;
import controller.CoinTypeButtonListener;
import controller.InsertButtonListener;
import controller.RemoveButtonListener;
import model.CoinDispenser;

public class AppWindow extends JFrame {
    public static final String radioButtonActionNickel = "nickel";
    public static final String radioButtonActionDime = "dime";
    public static final String radioButtonActionQuarter = "quarter";
    public static final String buttionActionInsert = "Insert";
    public static final String buttionActionRemove = "Remove";

    private JButton insertButton;
    private JButton removeButton;

    private AppCanvas canvas = new AppCanvas();

    public void init() {
        var cp = getContentPane();
        cp.add(canvas, BorderLayout.CENTER);

        JPanel southPanel = new JPanel();
        cp.add(southPanel, BorderLayout.SOUTH);

        southPanel.setLayout(new GridLayout(2, 1));

        JPanel coinTypePanel = new JPanel();
        coinTypePanel.setBorder(new TitledBorder("Coin Type"));

        int selectedIndex = App.coinDispenser.selectedSlotIndex;

        JRadioButton nickelButton = new JRadioButton(radioButtonActionNickel,
                selectedIndex == CoinDispenser.SLOT_NICKELS);
        JRadioButton dimeButton = new JRadioButton(radioButtonActionDime,
                selectedIndex == CoinDispenser.SLOT_DIMES);
        JRadioButton quarterButton = new JRadioButton(radioButtonActionQuarter,
                selectedIndex == CoinDispenser.SLOT_QUARTERS);
        ButtonGroup coinGroup = new ButtonGroup();
        coinGroup.add(nickelButton);
        coinGroup.add(dimeButton);
        coinGroup.add(quarterButton);
        coinTypePanel.add(nickelButton);
        coinTypePanel.add(dimeButton);
        coinTypePanel.add(quarterButton);
        southPanel.add(coinTypePanel);

        CoinTypeButtonListener coinTypeButtonListener = new CoinTypeButtonListener();
        nickelButton.addActionListener(coinTypeButtonListener);
        dimeButton.addActionListener(coinTypeButtonListener);
        quarterButton.addActionListener(coinTypeButtonListener);

        JPanel actionPanel = new JPanel();
        actionPanel.setBorder(new TitledBorder("Action"));
        insertButton = new JButton(buttionActionInsert);
        removeButton = new JButton(buttionActionRemove);
        actionPanel.add(insertButton);
        actionPanel.add(removeButton);
        southPanel.add(actionPanel);

        InsertButtonListener insertButtonListener = new InsertButtonListener();
        RemoveButtonListener removeButtonListener = new RemoveButtonListener();
        insertButton.addActionListener(insertButtonListener);
        removeButton.addActionListener(removeButtonListener);

        updateWindow();

    }

    public void updateWindow() {

        int selectedIndex = App.coinDispenser.selectedSlotIndex;
        int coinCount = 0;
        int maxAllowed = 0;
        switch (selectedIndex) {
            case CoinDispenser.SLOT_NICKELS:
                coinCount = App.coinDispenser.getNickelCount();
                maxAllowed = App.coinDispenser.maxNickels;
                break;
            case CoinDispenser.SLOT_DIMES:
                coinCount = App.coinDispenser.getDimeCount();
                maxAllowed = App.coinDispenser.maxDimes;
                break;
            case CoinDispenser.SLOT_QUARTERS:
                coinCount = App.coinDispenser.getQuarterCount();
                maxAllowed = App.coinDispenser.maxQuarters;
                break;
        }

        insertButton.setEnabled(coinCount < maxAllowed);
        removeButton.setEnabled(coinCount > 0);
        canvas.repaint();
    }

}
