package pl.edu.pk.project.controller;

import pl.edu.pk.project.model.Customer;
import pl.edu.pk.project.model.CustomerList;
import pl.edu.pk.project.model.Model;
import pl.edu.pk.project.view.DisplayCustomerView;
import pl.edu.pk.project.view.View;

public class ShowCustomersController extends Controller<Customer> {
    public ShowCustomersController(Model model, View view) {
        super(model, view);
    }

    @Override
    public void control() {
        CustomerList customerList = (CustomerList) model;
        DisplayCustomerView customerView = (DisplayCustomerView) view;
        customerView.getCustomerArea().append(customerList.toString());
    }
}
