import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator_948 extends JFrame implements ActionListener {
    JTextField display_948;
    StringBuilder input_948;
    JButton[] digitButtons_948;
    JButton addButton_948, subButton_948, mulButton_948, divButton_948, eqButton_948, clrButton_948;
    char operator_948;
    double num1_948, num2_948, result_948;

    public Calculator_948() {
        setTitle("Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        input_948 = new StringBuilder();
        display_948 = new JTextField();
        display_948.setEditable(false);
        display_948.setFont(new Font("Arial", Font.BOLD, 24));
        add(display_948, BorderLayout.NORTH);

        JPanel panel_948 = new JPanel(new GridLayout(4, 4, 5, 5));
        digitButtons_948 = new JButton[10];
        for (int i_948 = 0; i_948 <= 9; i_948++) {
            digitButtons_948[i_948] = new JButton(String.valueOf(i_948));
            digitButtons_948[i_948].addActionListener(this);
        }

        addButton_948 = new JButton("+");
        subButton_948 = new JButton("-");
        mulButton_948 = new JButton("*");
        divButton_948 = new JButton("/");
        eqButton_948 = new JButton("=");
        clrButton_948 = new JButton("C");

        addButton_948.addActionListener(this);
        subButton_948.addActionListener(this);
        mulButton_948.addActionListener(this);
        divButton_948.addActionListener(this);
        eqButton_948.addActionListener(this);
        clrButton_948.addActionListener(this);

        // Row 1
        panel_948.add(digitButtons_948[7]);
        panel_948.add(digitButtons_948[8]);
        panel_948.add(digitButtons_948[9]);
        panel_948.add(addButton_948);

        // Row 2
        panel_948.add(digitButtons_948[4]);
        panel_948.add(digitButtons_948[5]);
        panel_948.add(digitButtons_948[6]);
        panel_948.add(subButton_948);

        // Row 3
        panel_948.add(digitButtons_948[1]);
        panel_948.add(digitButtons_948[2]);
        panel_948.add(digitButtons_948[3]);
        panel_948.add(mulButton_948);

        // Row 4
        panel_948.add(digitButtons_948[0]);
        panel_948.add(clrButton_948);
        panel_948.add(eqButton_948);
        panel_948.add(divButton_948);

        add(panel_948, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e_948) {
        Object src_948 = e_948.getSource();

        for (int i_948 = 0; i_948 <= 9; i_948++) {
            if (src_948 == digitButtons_948[i_948]) {
                input_948.append(i_948);
                display_948.setText(input_948.toString());
                return;
            }
        }

        if (src_948 == addButton_948 || src_948 == subButton_948 ||
            src_948 == mulButton_948 || src_948 == divButton_948) {
            try {
                num1_948 = Double.parseDouble(input_948.toString());
            } catch (NumberFormatException ex_948) {
                display_948.setText("Error");
                input_948.setLength(0);
                return;
            }
            input_948.setLength(0);
            if (src_948 == addButton_948) operator_948 = '+';
            if (src_948 == subButton_948) operator_948 = '-';
            if (src_948 == mulButton_948) operator_948 = '*';
            if (src_948 == divButton_948) operator_948 = '/';
            display_948.setText(String.valueOf(operator_948));
        } else if (src_948 == eqButton_948) {
            try {
                num2_948 = Double.parseDouble(input_948.toString());
            } catch (NumberFormatException ex_948) {
                display_948.setText("Error");
                input_948.setLength(0);
                return;
            }
            switch (operator_948) {
                case '+': result_948 = num1_948 + num2_948; break;
                case '-': result_948 = num1_948 - num2_948; break;
                case '*': result_948 = num1_948 * num2_948; break;
                case '/': 
                    if (num2_948 == 0) {
                        display_948.setText("Divide by 0");
                        input_948.setLength(0);
                        return;
                    }
                    result_948 = num1_948 / num2_948; 
                    break;
                default: result_948 = 0;
            }
            display_948.setText(String.valueOf(result_948));
            input_948.setLength(0);
        } else if (src_948 == clrButton_948) {
            input_948.setLength(0);
            display_948.setText("");
            num1_948 = num2_948 = result_948 = 0;
            operator_948 = '\0';
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Calculator_948().setVisible(true);
        });
    }
}