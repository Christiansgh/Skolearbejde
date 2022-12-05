package Opg12;

public class Main {
    public static void main(String[] args) {
        int[] numbers = {5, 2, 8, 4, 0, 3, 1, 4};
        theSmallOneOut(numbers);
        //iterater gennem arrayet og finder det mindste element.
        //metoden sætter elements værdi til det næstmindste.
        //      kræver at vi finder og opbevarer det næstmindste værdi.
        //       Kan dele den op og lave en metode, som gennemløber arrayet og returner den mindste.
        //           så tager den anden metode værdien og finder den mindste værdi, som er også er større end den mindste værdi
        //              - Den 2. mindste værdi.
        //                  sæt den mindste værdi til 2. mindste
        //                      continue;
        //
        // Den kan løses ved at finde indexet, eller værdien.
        //      Vi gemmer indexet.
        //
        // && Lav en ny metode, som  kører forige metode, indtil der ikke foretages flere ændringer.
        //      Cycle igennem arrayet, og hvis der foretages en ændring forbliver booleanen true, således at loopet fortsætter.
        //          Når der ikke foretages flere ændringer => sæt til false, og break loopet.
        //              while (true) {
        //                  metode
        //              }
    }

    public static void theSmallOneOut(int[] x) {
        int smallest = x[0];
        int secondSmallest = x[0];

        for (int i = 0; i < x.length; i++) {
            if (x[i] < x[smallest]) {
                smallest = i;
                continue;
            }
            else if (x[i] < x[secondSmallest] && x[i] > x[smallest]) {
                secondSmallest = i;
            }
        }
        System.out.println(smallest);
        System.out.println(secondSmallest);
    }
}
