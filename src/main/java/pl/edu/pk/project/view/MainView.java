package pl.edu.pk.project.view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class MainView extends View {

    private JButton addCustomerButton;
    private JButton showCustomersButton;
    private JButton addReservationButton;

    public MainView(String name) {
        super(name);
        frame = new JFrame(name);
        panel = new JPanel(null);

        addCustomerButton = new JButton("Dodaj klienta");
        panel.add(addCustomerButton);
        addCustomerButton.setBounds(100, 40, 170, 23);
        putButton("addCustomerButton", addCustomerButton);

        showCustomersButton = new JButton("Wyswietl klienta");
        panel.add(showCustomersButton);
        showCustomersButton.setBounds(100, 70, 170, 23);
        putButton("showCustomersButton", showCustomersButton);


        addReservationButton = new JButton("Dodaj rezerwacje");
        panel.add(addReservationButton);
        addReservationButton.setBounds(100, 100, 170, 23);
        putButton("addReservationButton", addReservationButton);

        try {
            BufferedImage myPicture = ImageIO.read(this.getClass().getClassLoader().getResource("akademik.png"));
            JLabel picLabel = new JLabel(new ImageIcon(myPicture));
            picLabel.setBounds(35,135, 300, 200);
            panel.add(picLabel);
        } catch (IOException e) {
            e.printStackTrace();
        }
        frame.add(panel);
    }


    public void display() {
        frame.setSize(370, 400);
        frame.setVisible(true);
    }
}
