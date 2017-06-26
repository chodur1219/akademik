package pl.edu.pk.project.model;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Date;

public class Reservation implements Model {
    private Date startDate;
    private Date endDate;
    private Customer customer;
    private int roomNumber;
    private String id = RandomStringUtils.randomAlphabetic(6);

    public Reservation() {
    }

    private Reservation(Builder builder){
        this.startDate = builder.startDate;
        this.endDate = builder.endDate;
        this.customer = builder.customer;
        this.roomNumber = builder.roomNumber;
    }

    public static class Builder{
        private Date startDate;
        private Date endDate;
        private Customer customer;
        private int roomNumber;

        public Builder withStartDate(Date startDate){
            this.startDate = startDate;
            return this;
        }

        public Builder withEndDate(Date endDate){
            this.endDate = endDate;
            return this;
        }

        public Builder withCustomer(Customer customer){
            this.customer = customer;
            return this;
        }

        public Builder withRoomNumber(int roomNumber){
            this.roomNumber = roomNumber;
            return this;
        }

        public Reservation build(){
            return new Reservation(this);
        }
    }

    public boolean equals(Object o){
        if (o == null) {
            return false;
        }

        if (o.getClass() != getClass()){
            return false;
        }

        Reservation other = (Reservation)  o;
        return id.equals(other.id);

    }

    public int hashCode(){
        return id.hashCode();
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getId() {
        return id;
    }
}
