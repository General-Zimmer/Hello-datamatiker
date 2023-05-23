package opgaver.exercise3;

import opgaver.Util;
import opgaver.exercise1.Customer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Test {
    public static void main(String[] args) {
        String[] firstNames = {"Thomas","Robert","Maria","Leroy","Kimberly"};
        String[] lastNames = {"Schulze","Schulze","Cortez","Holden","Goldfinger"};
        ArrayList<Customer> customers = new ArrayList<>();

        String[] fn = {"Sammy", "Sally", "Robert", "Martin", "Albert", "Fernando"};
        String[] ln = {"Harutyunyan", "Jones", "Grigoryan", "Sarjsyan", "Harutyunyan", "Ambrosia"};
        Customer[] badCustomers = new Customer[5];
        for (int i = 0; i < 5; i++){
            Customer temp = new Customer(firstNames[i],lastNames[i]);
            customers.add(temp);
            Customer tempo = new Customer(fn[i],ln[i]);
            customers.add(tempo);
            badCustomers[i] = tempo;

        }

        Collections.sort(customers);
        Arrays.sort(badCustomers);

        System.out.println(customers);
        System.out.println(Arrays.toString(badCustomers));


        ArrayList<Customer> goodCustomers = Util.goodCustomers(customers, badCustomers);
        for (Customer customer : goodCustomers)
            System.out.println(customer);
    }


}
