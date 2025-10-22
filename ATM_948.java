import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ATM_948 extends JFrame {
    private JPasswordField pinField_948;
    private JButton submitButton_948;
    private JPanel mainPanel_948;
    private JPanel optionsPanel_948;
    private JLabel messageLabel_948;
    private final String correctPin_948 = "1234";

    public ATM_948() {
        setTitle("ATM Simulator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350, 200);
        setLocationRelativeTo(null);

        mainPanel_948 = new JPanel(new GridBagLayout());
        GridBagConstraints gbc_948 = new GridBagConstraints();
        gbc_948.insets = new Insets(5, 5, 5, 5);

        JLabel pinLabel_948 = new JLabel("Enter PIN:");
        gbc_948.gridx = 0;
        gbc_948.gridy = 0;
        mainPanel_948.add(pinLabel_948, gbc_948);

        pinField_948 = new JPasswordField(10);
        gbc_948.gridx = 1;
        mainPanel_948.add(pinField_948, gbc_948);

        submitButton_948 = new JButton("Submit");
        gbc_948.gridx = 1;
        gbc_948.gridy = 1;
        mainPanel_948.add(submitButton_948, gbc_948);

        messageLabel_948 = new JLabel("");
        gbc_948.gridx = 0;
        gbc_948.gridy = 2;
        gbc_948.gridwidth = 2;
        mainPanel_948.add(messageLabel_948, gbc_948);

        submitButton_948.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handlePinEntry_948();
            }
        });

        add(mainPanel_948);
    }

    private void handlePinEntry_948() {
        String enteredPin_948 = new String(pinField_948.getPassword());
        if (enteredPin_948.equals(correctPin_948)) {
            showOptionsPanel_948();
        } else {
            messageLabel_948.setText("Incorrect PIN. Try again.");
            pinField_948.setText("");
        }
    }

    private void showOptionsPanel_948() {
        if (optionsPanel_948 == null) {
            optionsPanel_948 = new JPanel();
            optionsPanel_948.setLayout(new GridLayout(3, 1, 10, 10));
            JButton checkBalanceButton_948 = new JButton("Check Balance");
            JButton depositButton_948 = new JButton("Deposit");
            JButton withdrawButton_948 = new JButton("Withdraw");

            checkBalanceButton_948.addActionListener(e -> JOptionPane.showMessageDialog(this, "Balance: $1000"));
            depositButton_948.addActionListener(e -> JOptionPane.showMessageDialog(this, "Deposit selected."));
            withdrawButton_948.addActionListener(e -> JOptionPane.showMessageDialog(this, "Withdraw selected."));

            optionsPanel_948.add(checkBalanceButton_948);
            optionsPanel_948.add(depositButton_948);
            optionsPanel_948.add(withdrawButton_948);
        }
        setContentPane(optionsPanel_948);
        revalidate();
        repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ATM_948().setVisible(true);
        });
    }
}