package opgaver;

import opgaver.exercise1.Customer;

import java.util.ArrayList;

public class Util {

    /**
     * Return a sorted list containing all customers
     * from the lists l1 and l2.
     * Pre: l1 and l2 are sorted.
     */
    public static ArrayList<Customer> mergeAllCustomers (
            ArrayList<Customer> l1, ArrayList<Customer> l2) {

        ArrayList<Customer> arr = new ArrayList<>();
        int i1 = 0;
        int i2 = 0;
        while (i1 < l1.size() && i2 < l2.size()) {


            int compared = l1.get(i1).compareTo(l2.get(i2));
            if (compared < 0) {
                arr.add(l1.get(i1));
                i1++;
            }
            else {
                arr.add(l2.get(i2));
                i2++;
            }
        }

        ArrayList<Customer> arr2 = i1 < l1.size() ? l1 : l2;
        for (int i = i1 < l1.size() ? i1 : i2; i < arr2.size(); i++)
            arr.add(arr2.get(i));


        return arr;
    }

    /**
     * Return a sorted array containing all elements
     * shared by l1 and l2.
     * The returned array must have no empty entries.
     * Pre: l1 and l2 are sorted and have no empty entries.
     */
    public static int[] sharedNumbers (int[] l1, int[] l2) {
        int[] arr = new int[l1.length + l2.length];
        int i1 = 0;
        int i2 = 0;
        int j = 0;
        while (i1 < l1.length && i2 < l2.length) {


            int compared = Integer.compare(l1[i1], l2[i2]);
            if (compared == 0) {
                arr[j] = l1[i1];
                i1++; j++;
            } else if (compared < 0) {
                i1++;

            } else {
                i2++;
            }
        }

        if (j != arr.length) {
            int[] arr2 = new int[j];

            for (int i = 0; i < j; i++)
                arr2[i] = arr[i];

            arr = arr2;
        }

        return arr;
    }

    /**
     * Return a sorted ArrayList containing all customers
     * from l1 that are not in l2.
     * Pre: l1 and l2 are sorted and l2 has no empty
     * entries.
     */
    public static ArrayList<Customer> goodCustomers(
            ArrayList<Customer> customers1, Customer[] badCustomers) {
        ArrayList<Customer> arr = new ArrayList<>();
        int i1 = 0;
        int i2 = 0;
        while (i1 < customers1.size() && i2 < badCustomers.length) {


            int compared = customers1.get(i1).compareTo(badCustomers[i2]);
            if (compared < 0) {
                arr.add(customers1.get(i1));
                i1++;
            } else if (compared > 0) {
                i2++;
            }
            else
                i1++;

        }
        while (i1 < customers1.size()) {
            arr.add(customers1.get(i1));
            i1++;
        }

        return arr;
    }
}
