package pl.edu.pk.project.view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class AddReservationView extends View {
    public AddReservationView(String name) {
        super(name);
        try {
            frame = new JFrame(name);
            panel = new JPanel(null);

            BufferedImage myPicture = ImageIO.read(this.getClass().getClassLoader().getResource("todo.png"));
            JLabel picLabel = new JLabel(new ImageIcon(myPicture));
            picLabel.setBounds(30,80, 300, 200);
            panel.add(picLabel);
            frame.add(panel);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void display() {
        frame.setSize(370, 400);
        frame.setVisible(true);
    }
}
