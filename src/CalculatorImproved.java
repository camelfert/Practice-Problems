import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CalculatorImproved implements ActionListener {

    JFrame frame;
    JTextField numField;
    JButton[] numButtons = new JButton[10];
    JButton[] funcButtons = new JButton[9];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equButton, delButton, clrButton, negButton;
    JPanel panel;

    double number1 = 0;
    double number2 = 0;
    double result;
    char operator;

    Font calcFont = new Font("Liga SFMono Nerd Font", Font.PLAIN, 20);

    CalculatorImproved() {
        frame = new JFrame("Improved Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 600);
        frame.setLayout(null);

        numField = new JTextField();
        numField.setBounds(0, 25, 400, 50);
        numField.setFont(calcFont);
        numField.setEditable(false); //controls whether text box is typable

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("<-");
        clrButton = new JButton("C");
        negButton = new JButton("(-)");

        funcButtons[0] = addButton;
        funcButtons[1] = subButton;
        funcButtons[2] = mulButton;
        funcButtons[3] = divButton;
        funcButtons[4] = decButton;
        funcButtons[5] = equButton;
        funcButtons[6] = delButton;
        funcButtons[7] = clrButton;
        funcButtons[8] = negButton;

        //attributes for function buttons
        for(int i = 0; i < 9; i++) {
            funcButtons[i].addActionListener(this);
            funcButtons[i].setFont(calcFont);
            funcButtons[i].setFocusable(false);
        }

        //attributes for number buttons
        for(int i = 0; i < 10; i++) {
            numButtons[i] = new JButton(String.valueOf(i));
            numButtons[i].addActionListener(this);
            numButtons[i].setFont(calcFont);
            numButtons[i].setFocusable(false);
        }

        negButton.setBounds(50, 430, 100, 50);
        delButton.setBounds(150, 430, 100, 50);
        clrButton.setBounds(250, 430, 100, 50);

        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4,4, 10, 10));
        panel.setBackground(Color.lightGray);
        panel.add(numButtons[1]);
        panel.add(numButtons[2]);
        panel.add(numButtons[3]);
        panel.add(addButton);
        panel.add(numButtons[4]);
        panel.add(numButtons[5]);
        panel.add(numButtons[6]);
        panel.add(subButton);
        panel.add(numButtons[7]);
        panel.add(numButtons[8]);
        panel.add(numButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numButtons[0]);
        panel.add(equButton);
        panel.add(divButton);


        
       
        
        frame.add(panel);
        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(numField);
        frame.setVisible(true);
        
    }

    public static void main(String[] args) throws Exception {
        new CalculatorImproved();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        for (int i = 0; i < 10; i++) {
            if(e.getSource() == numButtons[i]) {
                numField.setText(numField.getText().concat(String.valueOf(i)));
            }
        }

        if(e.getSource() == decButton) {
            numField.setText(numField.getText().concat(String.valueOf(".")));
        }

        if(e.getSource() == addButton) {
            number1 = Double.parseDouble(numField.getText());
            operator = '+';
            numField.setText("");
        }

        if(e.getSource() == subButton) {
            number1 = Double.parseDouble(numField.getText());
            operator = '-';
            numField.setText("");
        }

        if(e.getSource() == mulButton) {
            number1 = Double.parseDouble(numField.getText());
            operator = '*';
            numField.setText("");
        }

        if(e.getSource() == divButton) {
            number1 = Double.parseDouble(numField.getText());
            operator = '/';
            numField.setText("");
        }
        if(e.getSource() == equButton) {
            number2 = Double.parseDouble(numField.getText());
            switch(operator) {
            case '+':
			    result = number1 + number2;
			    break;
		    case '-':
                result = number1 - number2;
			    break;
		    case '*':
                result = number1 * number2;
			    break;
		    case '/':
                result = number1 / number2;
			    break;

            }
            numField.setText(String.valueOf(result));
            number1 = result;
        }
        if(e.getSource() == clrButton) {
            numField.setText("");
        }
        if(e.getSource() == delButton) {
            String delString = numField.getText();
            numField.setText("");
            for(int i = 0; i < delString.length() - 1; i++) {
                numField.setText(numField.getText() + delString.charAt(i));
            }
        }
        if(e.getSource()== negButton) {
			double temp = Double.parseDouble(numField.getText());
			temp*=-1;
			numField.setText(String.valueOf(temp));

		}

}
}
