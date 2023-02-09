package evenOdd;

import java.util.Arrays;
/*
 * rearrange the array:
 * even numbers come first, odd numbers after.
 * numbers can come in any order.
 *  - dont need to sort the order.
 */

public class Main {
    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9};
        seperateEvenOdd(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void seperateEvenOdd(int[] array) {
        //keep track of which indexes are sorted.
        //even numbers first(left), odd numbers last(right)
        int evenIndices = 0;
        int oddIndices = array.length-1;

        //start from the outside and move towards the middle / the other sides.
        while(evenIndices < oddIndices) { //iterate until the sorted indicies cross over.

            //iterate until an odd number is found. Make sure we're not in the odd sorted nums.
            while(array[evenIndices] % 2 == 0 && evenIndices < oddIndices) {
                evenIndices++;
            }

            //-II- but for odd numbers.
            while(array[oddIndices] % 2 != 0 && evenIndices < oddIndices) {
                oddIndices--;
            }   

            //swapping.
            if(evenIndices < oddIndices) {
                int temp = array[evenIndices];
                array[evenIndices] = array[oddIndices];
                array[oddIndices] = temp;

                evenIndices++;
                oddIndices--;
            } 
        }
    }
}
