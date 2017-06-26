package pl.edu.pk.project.view;

import javax.swing.*;

public class AddCustomerView extends View {

    private JButton addButton;
    private JFrame frame;
    private JPanel panel;

    private JLabel nameLbl;
    private JTextField nameTxt;

    private JLabel surnameLbl;
    private JTextField surnameTxt;

    private JLabel ageLbl;
    private JTextField ageTxt;

    private JLabel peselLbl;
    private JTextField peselTxt;

    public AddCustomerView(String name) {
        super(name);

        frame = new JFrame(name);
        panel = new JPanel(null);

        nameLbl = new JLabel("Imie:");
        nameLbl.setBounds(20, 50, 120, 14);
        panel.add(nameLbl);

        nameTxt = new JTextField();
        nameTxt.setName("nameTxt");
        nameTxt.setBounds(140, 50, 210, 20);
        addTxtField(nameTxt);
        panel.add(nameTxt);

        surnameLbl = new JLabel("Nazwisko:");
        surnameLbl.setBounds(20, 80, 110, 14);
        panel.add(surnameLbl);

        surnameTxt = new JTextField();
        surnameTxt.setName("surnameTxt");
        surnameTxt.setBounds(140, 80, 210, 20);
        addTxtField(surnameTxt);
        panel.add(surnameTxt);


        ageLbl = new JLabel("Wiek:");
        ageLbl.setBounds(20, 110, 110, 14);
        panel.add(ageLbl);

        ageTxt = new JTextField();
        ageTxt.setName("ageTxt");
        ageTxt.setBounds(140, 110, 210, 20);
        addTxtField(ageTxt);
        panel.add(ageTxt);


        peselLbl = new JLabel("Pesel:");
        peselLbl.setBounds(20, 140, 130, 14);
        panel.add(peselLbl);

        peselTxt = new JTextField();
        peselTxt.setName("peselTxt");
        peselTxt.setBounds(140, 140, 210, 20);
        addTxtField(peselTxt);
        panel.add(peselTxt);

        addButton = new JButton("Dodaj");
        addButton.setBounds(100, 180, 170, 23);
        panel.add(addButton);
        putButton("addCustomerButton", addButton);

        frame.add(panel);
    }


    @Override
    public void display() {
        frame.setSize(370, 300);
        frame.setVisible(true);
    }

}
