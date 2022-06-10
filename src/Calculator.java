
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Calculator {

	static int num1; //holds first user-input number
	static int num2; //holds second user-input number
	static char operator; //holds math sign/operator
	static String strConv; //holds math operator as string for conversion to char
	

	public static void calcInput() {
		Scanner input = new Scanner(System.in);
		num1 = Integer.parseInt(JOptionPane.showInputDialog("Enter the first number you would like to use for your calculation."));
		strConv = JOptionPane.showInputDialog("Enter the math sign you would like to use for your calculation.");
		operator=strConv.charAt(0);
		num2 = Integer.parseInt(JOptionPane.showInputDialog("Enter the second number you would like to use for your calculation."));
		input.close();
	}
	
	public static void calcOutput() { 
		//Math operations
		double add = (num1 + num2);
		double sub = (num1 - num2);
		double mul = (num1 * num2);
		double div = (num1 / num2);
		double mod = (num1 % num2);
		
		switch(operator) {
		case '+':
			JOptionPane.showMessageDialog(null, "The result of your calculation is: " + add);
			break;
		case '-':
			JOptionPane.showMessageDialog(null, "The result of your calculation is: " + sub);
			break;
		case '*':
			JOptionPane.showMessageDialog(null, "The result of your calculation is: " + mul);
			break;
		case '/':
			JOptionPane.showMessageDialog(null, "The result of your calculation is: " + div);
			break;
		case '%':
			JOptionPane.showMessageDialog(null, "The result of your calculation is: " + mod);
			break;
		default:
			JOptionPane.showMessageDialog(null, "You have entered an incorrect math sign. Please try again.");
			break;
		}
	}
	
	public static void main(String[] args) {
		calcInput();
		calcOutput();
	}
}
