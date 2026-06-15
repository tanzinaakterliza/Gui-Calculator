import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Form2 {
    JFrame frame;
    JTextField x, y, sum;
    JPanel inputPanel, buttonPanel, resultPanel, mainPanel;
    JButton btn, subBtn, multiplicationBtn, divBtn;

    public Form2() {
        frame = new JFrame("MyForm");
        frame.setSize(300, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Main panel with vertical layout
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        // Input panel
        inputPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        x = new JTextField(5);
        y = new JTextField(5);
        inputPanel.add(new JLabel("Num 1:"));
        inputPanel.add(x);
        inputPanel.add(new JLabel("Num 2:"));
        inputPanel.add(y);
        mainPanel.add(inputPanel);

        // Sum button row
        buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        btn = new JButton("Sum");
        buttonPanel.add(btn);
        mainPanel.add(buttonPanel);

        // Sub button row
        buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        subBtn = new JButton("Sub");
        buttonPanel.add(subBtn);
        mainPanel.add(buttonPanel);

        // Multiply button row
        buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        multiplicationBtn = new JButton("Multiply");
        buttonPanel.add(multiplicationBtn);
        mainPanel.add(buttonPanel);

        // Division button row
        buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        divBtn = new JButton("Division");
        buttonPanel.add(divBtn);
        mainPanel.add(buttonPanel);

        // Result panel
        resultPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        sum = new JTextField("Result", 10);
        sum.setEditable(false);
        resultPanel.add(new JLabel("Result:"));
        resultPanel.add(sum);
        mainPanel.add(resultPanel);

        // Attach listeners
        HandelBtnClick handler = new HandelBtnClick();
        btn.addActionListener(handler);
        subBtn.addActionListener(handler);
        multiplicationBtn.addActionListener(handler);
        divBtn.addActionListener(handler);

        frame.setContentPane(mainPanel);
        frame.setVisible(true);
    }

    class HandelBtnClick implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                int a = Integer.parseInt(x.getText());
                int b = Integer.parseInt(y.getText());
                Object source = e.getSource();
                if (source == btn) {
                    sum.setText(String.valueOf(a + b));
                } else if (source == subBtn) {
                    sum.setText(String.valueOf(a - b));
                } else if (source == multiplicationBtn) {
                    sum.setText(String.valueOf(a * b));
                } else if (source == divBtn) {
                    if (b != 0) {
                        sum.setText(String.valueOf((double) a / b));
                    } else {
                        sum.setText("Divide by 0");
                    }
                }
            } catch (NumberFormatException ex) {
                sum.setText("Invalid input");
            }
        }
    }
}

public class ButtonEventExample {
    public static void main(String[] args) {
        new Form2();
    }
}
