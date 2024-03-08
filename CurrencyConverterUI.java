import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CurrencyConverterUI extends JFrame {

    private CurrencyConverter converter;
    private JComboBox<String> fromCurrencyComboBox;
    private JComboBox<String> toCurrencyComboBox;
    private JTextField amountTextField;
    private JLabel resultLabel;

    public CurrencyConverterUI() {
        super("Currency Converter");

        converter = new CurrencyConverter();

        JPanel mainPanel = new JPanel(new BorderLayout());

        // top panel for input fields
        JPanel inputPanel = new JPanel(new FlowLayout());
        JLabel amountLabel = new JLabel("Amount:");
        amountTextField = new JTextField(10);
        inputPanel.add(amountLabel);
        inputPanel.add(amountTextField);
        JLabel fromCurrencyLabel = new JLabel("From:");
        fromCurrencyComboBox = new JComboBox<>(converter.getAvailableCurrencies().toArray(new String[0]));
        inputPanel.add(fromCurrencyLabel);
        inputPanel.add(fromCurrencyComboBox);
        JLabel toCurrencyLabel = new JLabel("To:");
        toCurrencyComboBox = new JComboBox<>(converter.getAvailableCurrencies().toArray(new String[0]));
        inputPanel.add(toCurrencyLabel);
        inputPanel.add(toCurrencyComboBox);
        mainPanel.add(inputPanel, BorderLayout.NORTH);

        // center panel for convert button
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton convertButton = new JButton("Convert");
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double amount = Double.parseDouble(amountTextField.getText());
                String fromCurrency = (String) fromCurrencyComboBox.getSelectedItem();
                String toCurrency = (String) toCurrencyComboBox.getSelectedItem();
                double convertedAmount = converter.convert(amount, fromCurrency, toCurrency);
                resultLabel.setText(String.format("%.2f %s = %.2f %s", amount, fromCurrency, convertedAmount, toCurrency));
            }
        });
        buttonPanel.add(convertButton);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        // bottom panel for result label
        JPanel resultPanel = new JPanel(new FlowLayout());
        resultLabel = new JLabel(" ");
        resultPanel.add(resultLabel);
        mainPanel.add(resultPanel, BorderLayout.SOUTH);

        setContentPane(mainPanel);
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        CurrencyConverterUI ui = new CurrencyConverterUI();
        ui.setVisible(true);
    }
}