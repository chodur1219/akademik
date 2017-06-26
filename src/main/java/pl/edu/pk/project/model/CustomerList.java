package pl.edu.pk.project.model;

import java.util.List;

public class CustomerList implements Model {
    private List<Customer> customers;

    public CustomerList(List<Customer> customers){
        this.customers = customers;
    }

    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        for (Customer customer : customers){
            stringBuilder.append(customer.toString()).append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
