package pl.edu.pk.project.controller;

import pl.edu.pk.project.model.Customer;
import pl.edu.pk.project.model.Model;
import pl.edu.pk.project.view.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddCustomerController extends Controller<Customer> {
    private ActionListener addCustomerListener;

    public AddCustomerController(Model model, View view) {
        super(model, view);
    }

    @Override
    public void control() {
        addCustomerListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (view.validateNotEmpty() && view.validateNumber(false, "peselTxt", "ageTxt")) {
                    Customer customer = new Customer.Builder()
                            .withAge(Integer.valueOf(view.getTextValue("ageTxt")))
                            .withName(view.getTextValue("nameTxt"))
                            .withSurname(view.getTextValue("surnameTxt"))
                            .withPesel(Integer.valueOf(view.getTextValue("peselTxt")))
                            .build();
                    model = customer;
                    if (service.add(customer)) {
                        view.cleanTxtValues();
                        view.displayConfirmation("Klient został dodany");
                    }
                }

            }
        };
         view.getButton("addCustomerButton").addActionListener(addCustomerListener);
    }
}
