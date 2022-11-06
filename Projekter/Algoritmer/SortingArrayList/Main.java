package SortingArrayList;
import java.util.ArrayList;
/*
 * Takes an ArrayList of a type
 * Sorts it by the parameter
 * Boolean: Low-High - otherwise High-Low
 * Boolean: Print each iteration
 */

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> testList = new ArrayList<>();
        testList.add(0, 10);
        testList.add(1, 9);
        testList.add(2, 8);
        testList.add(3, 7);
        testList.add(4, 6);
        testList.add(5, 5);
        testList.add(6, 4);
        testList.add(7, 3);
        testList.add(8, 2);
        testList.add(9, 1);
        testList.add(10, 1);
            //recursion
                //check the index 
                //if prev index (i-1) > (i)
                    //use temp variable to placeholder then prev number
                    //replace prev with current
                    //replace current with placeholder
                    //call itself (recursion)
                    //break if prev number (i-1) < (i)
        //if print each iteration = true, print the ArrayList.
    }

    public void sortByInteger(ArrayList<Integer> list) {
        for(int i = 0; i < list.size(); i++) {

        }
    }
}