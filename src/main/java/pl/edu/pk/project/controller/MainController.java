package pl.edu.pk.project.controller;

import pl.edu.pk.project.model.Customer;
import pl.edu.pk.project.model.CustomerList;
import pl.edu.pk.project.model.Model;
import pl.edu.pk.project.model.Reservation;
import pl.edu.pk.project.service.CustomerService;
import pl.edu.pk.project.service.ReservationService;
import pl.edu.pk.project.service.Service;
import pl.edu.pk.project.view.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static pl.edu.pk.project.view.ViewFactory.buildView;
import static pl.edu.pk.project.view.ViewType.*;

public class MainController extends Controller {
    private final static Controller instance = new MainController(null, buildView(MainView));
    private final Service<Customer> customerService = new CustomerService();
    private final Service<Reservation> reservationService = new ReservationService();

    private ActionListener addCustomerListener;
    private ActionListener showCustomersListener;
    private ActionListener addReservationListener;

    private MainController(Model model, View view) {
        super(model, view);
    }

    public static Controller getInstance() {
        return instance;
    }

    @Override
    public void control() {
        showCustomersListener = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                Controller controller = new ShowCustomersController(new CustomerList(customerService.getAll()), buildView(DisplayCustomerView));
                controller.control();
                controller.getView().display();
            }
        };
        view.getButton("showCustomersButton").addActionListener(showCustomersListener);

        addCustomerListener = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                Controller<Customer> controller = new AddCustomerController(new Reservation(), buildView(AddCustomerView));
                controller.setService(customerService);
                controller.control();
                controller.getView().display();

            }
        };
        view.getButton("addCustomerButton").addActionListener(addCustomerListener);

        addReservationListener = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                Controller<Reservation> controller = new AddReservationController(new Customer(), buildView(AddReservationView));
                controller.setService(reservationService);
                controller.control();
                controller.getView().display();
            }
        };
        view.getButton("addReservationButton").addActionListener(addReservationListener);
    }
}
