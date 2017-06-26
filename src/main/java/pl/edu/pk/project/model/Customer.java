package pl.edu.pk.project.model;

public class Customer implements Model {
    private String name;
    private String surname;
    private int age;
    private int pesel;

    private Customer(Builder builder) {
        this.age = builder.age;
        this.name = builder.name;
        this.surname = builder.surname;
        this.pesel = builder.pesel;

    }

    public Customer() {
    }

    public static class Builder {
        private String name;
        private String surname;
        private int age;
        private int pesel;


        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public Builder withAge(int age) {
            this.age = age;
            return this;
        }

        public Builder withPesel(int pesel) {
            this.pesel = pesel;
            return this;
        }

        public Customer build() {
            return new Customer(this);
        }
    }


    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }

        if (o.getClass() != getClass()) {
            return false;
        }

        Customer other = (Customer) o;
        return pesel == other.pesel;

    }

    public String toString(){
        return "NAME:" + name + " , SURNAME:" + surname + " ,PESEL:" + pesel;
    }

    public int hashCode() {
        return pesel;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public int getPesel() {
        return pesel;
    }
}
