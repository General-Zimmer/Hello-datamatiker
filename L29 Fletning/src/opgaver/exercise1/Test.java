package opgaver.exercise1;

import opgaver.Util;

import java.util.ArrayList;
import java.util.Collections;

public class Test {
    public static void main(String[] args) {

        String[] firstNames = {"Thomas","Robert","Maria","Leroy","Kimberly"};
        String[] lastNames = {"Schulze","Schulze","Cortez","Holden","Goldfinger"};
        ArrayList<Customer> customers = new ArrayList<>();

        String[] fn = {"Sammy", "Sally", "Robert", "Martin", "Albert", "Fernando"};
        String[] ln = {"Harutyunyan", "Jones", "Grigoryan", "Sarjsyan", "Harutyunyan", "Ambrosia"};
        ArrayList<Customer> badCustomers = new ArrayList<>();
        Customer[] arrBadCustomers = new Customer[5];
        for (int i = 0; i < 5; i++){
            Customer temp = new Customer(firstNames[i],lastNames[i]);
            customers.add(temp);
            Customer tempo = new Customer(fn[i],ln[i]);
            badCustomers.add(tempo);
            arrBadCustomers[i] = tempo;
        }

        Collections.sort(customers);
        Collections.sort(badCustomers);

        ArrayList<Customer> arr = Util.mergeAllCustomers(customers, badCustomers);
        for (Customer customer : arr) {
            System.out.println(customer);
        }

    }



}
