package pl.edu.pk.project.service;

import pl.edu.pk.project.model.Customer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CustomerService implements Service<Customer> {
    Set<Customer> customers = new HashSet<>();

    public boolean add(Customer customer) {
        return customers.add(customer);
    }

    public Customer get(String pesel) {
        for (Customer customer : customers) {
            if (String.valueOf(customer.getPesel()).equals(pesel)) {
                return customer;
            }
        }
        return null;
    }

    public boolean remove(String pesel) {
        boolean isRemoved = false;
        for (Customer customer : customers) {
            if (String.valueOf(customer.getPesel()).equals(pesel)) {
                isRemoved = customers.remove(customer);
                break;
            }
        }
        return isRemoved;
    }

    public List<Customer> getAll() {
        return new ArrayList<>(customers);
    }
}
