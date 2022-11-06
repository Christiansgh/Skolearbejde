package SortingArrayList;
import java.util.ArrayList;
/*
 * Takes an ArrayList of a type
 * Sorts it by the parameter
 * Boolean: Low-High - otherwise High-Low
 * Boolean: Print each iteration
 */

public class Sorting {
    private boolean lowToHigh;
    private boolean printEach;
    


    public void sortByInteger(ArrayList<Integer> list) {
        for(int i = 0; i < list.size(); i++) {
            int temp = 0;
            if(prevGreater(list, i) == true) {
                
            }
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
    }

    private boolean prevGreater(ArrayList<Integer> list, int i) {
        return list.get(i-1) > list.get(i);
    }
}
