package opgaver.exercise1;

public class Customer implements Comparable<Customer>{
    private String firstName;
    private String lastName;

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }


    @Override
    public int compareTo(Customer customer2) {
        int compared = this.getLastName().compareTo(customer2.getLastName());

        if (compared == 0)
            compared = this.getFirstName().compareTo(customer2.getFirstName());

        return compared;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


}
