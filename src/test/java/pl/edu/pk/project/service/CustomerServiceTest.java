package pl.edu.pk.project.service;

import org.junit.Assert;
import org.junit.Test;
import pl.edu.pk.project.model.Customer;

public class CustomerServiceTest {


    @Test
    public void shouldAddCustomer() {
        //given
        CustomerService customerService = new CustomerService();
        Customer customer = new Customer.Builder().
                withAge(10).withName("Name").withSurname("Surname").withPesel(123).build();

        //when
        customerService.add(customer);

        //then
        Customer other = customerService.get(String.valueOf(123));
        Assert.assertEquals(customer, other);

    }

    @Test
    public void shouldRemoveCustomer() {
        //given
        CustomerService customerService = new CustomerService();
        Customer customer = new Customer.Builder().
                withAge(10).withName("Name").withSurname("Surname").withPesel(123).build();
        customerService.add(customer);

        //when
        customerService.remove(String.valueOf(123));

        //then
        Customer other = customerService.get(String.valueOf(123));
        Assert.assertNull(other);
    }
}
