import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class GUI implements ActionListener {
    JTextField txtField1;
    JTextField txtField2;
    JTextField txtOperation;
    JLabel label;
    JLabel title;
    JPanel panel;
    JFrame frame;

    public GUI() {
        Color color = new Color(0, 17, 141);
        frame = new JFrame();
        panel = new JPanel();
        txtField1 = new JTextField("Enter number 1: ");
        txtField2 = new JTextField("Enter number 2: "); 
        txtOperation = new JTextField("Enter the operation: "); 
        JButton button = new JButton("Enter");
        button.addActionListener(this);
        label = new JLabel("Result: none");
        title = new JLabel("Java GUI Calculator");
        title.setFont(new Font("Verdana", Font.BOLD, 30));
        title.setForeground(color);
        panel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(title);
        panel.add(txtField1);
        panel.add(txtField2);
        panel.add(txtOperation);
        panel.add(button);
        panel.add(label);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Simple Calculator using Java GUI");
        frame.pack();
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new GUI();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        int input1 = Integer.parseInt(txtField1.getText());
        int input2 = Integer.parseInt(txtField2.getText());
        String operationStr = txtOperation.getText();
        if (operationStr.equals("+")) {
            label.setText("Result: " + (input1 + input2));
        } else if (operationStr.equals("-")) {
            label.setText("Result: " + (input1 - input2));
        } else if (operationStr.equals("*")) {
            label.setText("Result: " + (input1 * input2));
        } else if (operationStr.equals("/")) {
            double dbl1 = (double) input1;
            double dbl2 = (double) input2;
            label.setText("Result: " + (dbl1 / dbl2));
        } else if (operationStr.equals("^")) {
            label.setText("Result: " + (Math.pow(input1, input2)));
        } else if (operationStr.equals("root")) {
            label.setText("Result: " + Math.pow(input1, 1.0 / input2));
        }
    }
}
