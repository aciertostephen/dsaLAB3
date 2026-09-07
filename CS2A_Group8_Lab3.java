import java.util.Scanner;
/**
 * 
 * Group #8
 * Authors: Salceda, Zac Luther L.(Leader)
 * Acierto, Stephen Shane R. (Member1)
 * Pedrita, Genrev (Member2)
 * Laboratory Exercise #3
 * Date: Sept 7 , 2026
 */
public class CS2A_Group8_Lab3 {
    static int [] array = null;
    static Scanner sc = new Scanner(System.in);
    public static void main() {
        array = createArray();
        insertElement(array);
        boolean run = true;
        do {
            printMenu();
            boolean validAction = false;
    
            while (!validAction) {
                System.out.print("Enter Choice: ");
                int selection = getValidInt();
                if ((selection == Integer.MIN_VALUE) || (selection < 0 || selection > 5)) {
                    System.out.println(" ▶ Selection invalid. Please try again.");
                    continue;
                }
                switch (selection) {
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        System.out.println("\n───────────────────┤ ✦ PROGRAM CLOSED ✦ ├──────────────────");
                        run = false;
                        validAction = true;
                        break;
                }
            }
        } while (run);
    }
    public static void printMenu(){
        clearConsole();
        System.out.println();
        System.out.println("════════════════════════════════════════════════════════════");
        System.out.println("         ───✧─✦── SORTING ALGORITHMS ──✦─✧───            ");
        System.out.println("════════════════════════════════════════════════════════════");
        System.out.println("                          ‹ menu ›                          ");
        System.out.println("────────────────────────────────────────────────────────────"); 
        System.out.println();
        System.out.println("                  [ 1 ]      Optimized Bubble Sort          ");
        System.out.println("                  [ 2 ]      Selection Sort                 ");
        System.out.println("                  [ 3 ]      Insertion Sort                 ");
        System.out.println("                  [ 4 ]      Exit                           ");
        System.out.println();
        System.out.println("════════════════════════════════════════════════════════════");
        System.out.println();
    }
    public static int getValidInt() {
        if (!sc.hasNextInt()) {
            sc.nextLine();
            return Integer.MIN_VALUE;
        }
        int num = sc.nextInt();
        sc.nextLine();
        return num;
    }
    public static int[] createArray() {
        int n;
        while (true) {
            System.out.print(" ■ Enter array size (5-20): ");
            n = getValidInt();
            if ((n == Integer.MIN_VALUE) || (n < 5 || n > 20)) {
                System.out.println(" ▶ Invalid Input. Please choose a number between 5 and 15.");
                continue;
            }
            break;
        }
        System.out.println(" ▶ Array created with size " + n + ".");
        return new int[n];
    }
    public static void clearConsole() {
        System.out.print("\f");
        System.out.flush();
    }
    public static void insertElement(int[] array) {
    System.out.println();
    for (int i = 0; i < array.length; i++) {
        while (true) {
            System.out.print(" ■ Enter element [" + (i + 1) + "/" + array.length + "]: ");
            int val = getValidInt();
            if (val == Integer.MIN_VALUE) {
                System.out.println(" ▶ Invalid Input. Please enter a number.");
                continue;
            }
            array[i] = val;
            break;
        }
    }
}
}