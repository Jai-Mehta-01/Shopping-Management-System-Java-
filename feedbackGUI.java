package billing;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;

public class feedbackGUI implements ActionListener {
    JTextArea area;
    JPanel panel;
    JLabel label = new JLabel();
    JButton button;
    JFrame frame;
    feedbackGUI()
    {
        frame = new JFrame("Feedback");
        panel = new JPanel();
        panel.setLayout(new FlowLayout());
        area = new JTextArea("Type your feedback here", 10, 20);
        area.setLineWrap(true);
        frame.setResizable(false);
        button = new JButton();
        button.setText("Submit");
        panel.add(area);
        label.setText("ThankYou for your valuable feedback\nPlease visit us again !!\n");
        label.setBounds(0,0,250,250);
        panel.add(button);
        frame.add(panel);
        frame.setSize(250, 250);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        button.addActionListener(this);

    }
    public void actionPerformed(ActionEvent e) {
        FileWriter fout1 = null;
        try {
            fout1 = new FileWriter("feedback.txt", true);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        String feedback = area.getText();
        try {
            if (fout1 != null) {
                fout1.write(feedback+"\n");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        try {
            if (fout1 != null) {
                fout1.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        frame.dispose();
        System.out.println("ThankYou for your valuable feedback\nPlease visit us again !!\n");
        System.exit(0);
    }
}