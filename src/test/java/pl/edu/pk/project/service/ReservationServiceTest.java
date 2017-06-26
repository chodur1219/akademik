package pl.edu.pk.project.service;

import org.junit.Assert;
import org.junit.Test;
import pl.edu.pk.project.model.Customer;
import pl.edu.pk.project.model.Reservation;

import java.util.Date;
import java.util.List;

public class ReservationServiceTest {


    @Test
    public void shouldAddReservation() {
        //given
        ReservationService reservationService = new ReservationService();
        Customer customer = new Customer.Builder().
                withAge(10).withName("Name").withSurname("Surname").withPesel(123).build();
        Reservation reservation = new Reservation.Builder()
                .withCustomer(customer).withStartDate(new Date()).withEndDate(new Date()).withRoomNumber(12).build();
        String reservationId = reservation.getId();

        //when
        reservationService.add(reservation);

        //then
        Reservation other = reservationService.get(reservationId);
        Assert.assertEquals(reservation, other);
    }

    @Test
    public void shouldRemoveReservation() {
        //given
        ReservationService reservationService = new ReservationService();
        Customer customer = new Customer.Builder().
                withAge(10).withName("Name").withSurname("Surname").withPesel(123).build();
        Reservation reservation = new Reservation.Builder()
                .withCustomer(customer).withStartDate(new Date()).withEndDate(new Date()).withRoomNumber(12).build();
        String reservationId = reservation.getId();
        reservationService.add(reservation);

        //when
        reservationService.remove(reservationId);

        //then
        Reservation other = reservationService.get(reservationId);
        Assert.assertNull(other);
    }

    @Test
    public void shouldGetAllReservations(){
        //given
        ReservationService reservationService = new ReservationService();
        Customer customer = new Customer.Builder().
                withAge(10).withName("Name").withSurname("Surname").withPesel(123).build();
        Reservation reservation1 = new Reservation.Builder()
                .withCustomer(customer).withStartDate(new Date()).withEndDate(new Date()).withRoomNumber(12).build();
        Reservation reservation2 = new Reservation.Builder()
                .withCustomer(customer).withStartDate(new Date()).withEndDate(new Date()).withRoomNumber(12).build();
        reservationService.add(reservation1);
        reservationService.add(reservation2);

        //when
        List<Reservation> reservations = reservationService.getAll();
        Assert.assertTrue(reservations.size() == 2);
    }
}
