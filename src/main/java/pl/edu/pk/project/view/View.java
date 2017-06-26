package pl.edu.pk.project.view;

import org.apache.commons.lang3.StringUtils;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class View {
    public Map<String, JButton> buttons = new HashMap<>();
    private List<JTextField> txtFields = new ArrayList<>();
    protected JFrame frame;
    protected JPanel panel;
    protected String name = "";

    public View(String name) {
        this.name = name;
    }

    public abstract void display();

    public boolean putButton(String buttonName, JButton button) {
        if (!buttons.containsKey(buttonName)) {
            buttons.put(buttonName, button);
            return true;
        }
        return false;
    }

    public JButton getButton(String name) {
        return buttons.get(name);
    }

    public void addTxtField(JTextField txtFieldName) {
        txtFields.add(txtFieldName);
    }

    public String getTextValue(String txtFieldName) {
        for (JTextField txtField : txtFields) {
            if (txtField.getName().equals(txtFieldName)) {
                return txtField.getText();
            }
        }
        throw new RuntimeException("No such txtField");
    }

    public JTextField getTextField(String txtFieldName) {
        for (JTextField txtField : txtFields) {
            if (txtField.getName().equals(txtFieldName)) {
                return txtField;
            }
        }
        throw new RuntimeException("No such txtField");
    }

    public void cleanTxtValues() {
        for (JTextField txtField : txtFields) {
            txtField.setText(StringUtils.EMPTY);
        }
    }

    public void displayConfirmation(String message) {
        JOptionPane.showMessageDialog(panel, message);
    }

    public boolean validateNumber(boolean isOptional, String... txtFieldName) {
        boolean isValid = true;
        if (!isOptional) {
            for (JTextField txtField : txtFields) {
                for (String fieldName : txtFieldName) {
                    if (txtField.getName().equals(fieldName) && !StringUtils.isNumeric(txtField.getText())) {
                        txtField.setText("Błąd! Proszę podać liczbę.");
                        isValid = false;
                    }
                }
            }
        }
        return isValid;
    }

    public boolean validateNotEmpty() {
        boolean isValid = true;
        for (JTextField txtField : txtFields) {
            if (!StringUtils.isNotBlank(txtField.getText())) {
                isValid = false;
                break;
            }
        }
        if (!isValid) JOptionPane.showMessageDialog(panel, "Wszystkie pola są obowiązkowe");
        return isValid;
    }

}
