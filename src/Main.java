import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame implements ActionListener, KeyListener {

    private JLabel label1, label2, label3;
    private JTextField textField;
    private JButton button;
    private JComboBox<String> comboBox;

    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        super("Valorant Points Calculator");

        ImageIcon icon = new ImageIcon("1Artboard_1.png");

        this.setIconImage(icon.getImage());

        label1 = new JLabel("Currency:");
        label2 = new JLabel("How many Valorant points do you need?");
        label3 = new JLabel("Result:");

        String[] currencies = {"USD", "UAH"};
        comboBox = new JComboBox<>(currencies);

        textField = new JTextField(10);
        textField.addKeyListener(this);
        textField.requestFocus();

        button = new JButton("Calculate");
        button.addActionListener(this);

        JPanel panel1 = new JPanel(new FlowLayout());
        panel1.add(label1);
        panel1.add(comboBox);

        JPanel panel2 = new JPanel(new FlowLayout());
        panel2.add(label2);
        panel2.add(textField);

        JPanel panel3 = new JPanel(new FlowLayout());
        panel3.add(button);

        JPanel panel4 = new JPanel(new FlowLayout());
        panel4.add(label3);

        JPanel panel5 = new JPanel(new FlowLayout());
        panel5.add(panel1);
        panel5.add(panel2);
        panel5.add(panel3);
        panel5.add(panel4);

        this.setContentPane(panel5);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 150);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            calculateResult();
        }
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            calculateResult();
        }
    }

    public void keyReleased(KeyEvent e) {}

    public void keyTyped(KeyEvent e) {}

    private void calculateResult() {
        String input = comboBox.getSelectedItem().toString();
        double amount = Double.parseDouble(textField.getText());

        if (input.equals("USD")) {
            if (amount <= 475) {
                label3.setText(String.format("Result: %.2f", 4.99 / 475 * amount));
            } else if (amount <= 1000) {
                label3.setText(String.format("Result: %.2f", 9.99 / 1000 * amount));
            } else if (amount <= 2050) {
                label3.setText(String.format("Result: %.2f", 19.99 / 2050 * amount));
            } else if (amount <= 3650) {
                label3.setText(String.format("Result: %.2f", 34.99 / 3650 * amount));
            } else if (amount <= 5350) {
                label3.setText(String.format("Result: %.2f", 49.99 / 5350 * amount));
            } else if (amount <= 11000) {
                label3.setText(String.format("Result: %.2f", 99.99 / 11000 * amount));
            } else {
                label3.setText("limit 11000!");
            }
        } else if (input.equals("UAH")) {
            if (amount <= 420) {
                label3.setText(String.format("Result: %.2f", 80.0 / 420.0 * amount));
            } else if (amount <= 880) {
                label3.setText(String.format("Result: %.2f", 160.0 / 880.0 * amount));
            } else if (amount <= 1825) {
                label3.setText(String.format("Result: %.2f", 320.0 / 1825.0 * amount));
            } else if (amount <= 3225) {
                label3.setText(String.format("Result: %.2f", 560.0 / 3225.0 * amount));
            } else if (amount <= 4650) {
                label3.setText(String.format("Result: %.2f", 800.0 / 4650.0 * amount));
            } else if (amount <= 9650) {
                label3.setText(String.format("Result: %.2f", 1600.0 / 9650.0 * amount));
            } else {
                label3.setText("limit 9650!");
            }
        }
    }
}
