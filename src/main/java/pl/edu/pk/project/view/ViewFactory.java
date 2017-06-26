package pl.edu.pk.project.view;

public class ViewFactory {
    public static View buildView(ViewType viewType) {
        View result;
        switch (viewType) {
            case AddCustomerView:
                result = new AddCustomerView("Dodaj klienta");
                break;
            case AddReservationView:
                result = new AddReservationView("Dodaj rezerwację");
                break;
            case DisplayCustomerView:
                result = new DisplayCustomerView("Wyswietl klientów");
                break;
            default:
                result = new MainView("Ekran głowny");
        }
        return result;
    }
}
