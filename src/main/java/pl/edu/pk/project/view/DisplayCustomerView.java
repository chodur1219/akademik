package pl.edu.pk.project.view;

import javax.swing.*;

public class DisplayCustomerView extends View {

    private JTextArea customerArea;

    public DisplayCustomerView(String name) {
        super(name);
        frame = new JFrame(name);
        panel = new JPanel();
        panel.setLayout(null);

        customerArea = new JTextArea();
        customerArea.setLineWrap(false);
        customerArea.setBounds(10,50,340,200);
        customerArea.setAutoscrolls(true);
        customerArea.setEditable(false);

        panel.add(customerArea);
        frame.add(panel);
    }

    public void display() {
        frame.setSize(370, 400);
        frame.setVisible(true);
    }

    public JTextArea getCustomerArea(){
        return customerArea;
    }
}
