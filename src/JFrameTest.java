import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JFrameTest implements ActionListener {

    int count = 0;
    JLabel label;
    JFrame frame;
    JPanel panel;
    JButton button;

    public JFrameTest() {
        JFrame frame = new JFrame();

        JButton button = new JButton("Button Test 1");
        button.addActionListener(this);

        JLabel label = new JLabel("Number of clicks: 0");

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(button);
        panel.add(label);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("JFrame Test");
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        new JFrameTest();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        count++;
        label.setText("Number of clicks: " + count);
    }
}