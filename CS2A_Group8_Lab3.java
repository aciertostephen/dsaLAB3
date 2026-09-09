import java.util.Scanner;
/**
 *
 * Group #8
 * Authors: Zac Luther L. Salceda
 * Stephen Shane Acierto
 * Genrev R. Pedrita
 * Laboratory Exercise #3
 * Date: Sept 7 , 2026
 */
//try github//
public class CS2A_Group8_Lab3 {
    static int [] array = null;
    static Scanner sc = new Scanner(System.in);
    static int[] original = null;
    public static void main() {
        array = createArray();
        insertElement(array);
        original = array.clone();
        boolean run = true;
        do {
            printMenu();
            boolean validAction = false;
            while (!validAction) {
                System.out.print("Enter Choice: ");
                int selection = getValidInt();
                if ((selection == Integer.MIN_VALUE) || (selection < 0 || selection > 4)) {
                    System.out.println(" ▶ Selection invalid. Please try again.");
                    continue;
                }
                switch (selection) {
                    case 1:
                        bubblesort();
                        validAction = true;
                        returnButton();
                        break;
                    case 2:
                        break;
                    case 3:
                        insertionsort();
                        validAction = true;
                        returnButton();
                        break;
                    case 4:
                        System.out.println("\n───────────────────┤ ✦ PROGRAM CLOSED ✦ ├──────────────────");
                        run = false;
                        validAction = true;
                        break;
                    default: 
                        System.out.println(" ▶ Selection invalid. Please try again.");
                        break;
                }
            }
        } while (run);
    }
    public static void printMenu(){
        //clearConsole();
        System.out.println();
        System.out.println("════════════════════════════════════════════════════════════");
        System.out.println("          ───✧─✦── SORTING ALGORITHMS ──✦─✧───            ");
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
        returnButton();
    }
    public static void bubblesort(){
        array = original.clone();
        System.out.println("════════════════════════════════════════════════════════════");
        System.out.println("         ───✧─✦── OPTIMIZED BUBBLE SORT ──✦─✧───          ");
        System.out.println("════════════════════════════════════════════════════════════");
        System.out.print("Given Array Elements: ");
        for(int n : array){
            System.out.printf("%5d", n);
        }
        System.out.println();
        for(int i = 0; i < array.length - 1; i++){
            boolean swapped = false;
            for(int j = 0; j < array.length - 1 - i; j++){
                if(array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    swapped = true;
                }
            }
            System.out.printf("%d. ", (i + 1));
            for (int n : array) {
                System.out.printf("%5d", n);
            }
            System.out.println();
            if(swapped == false){
            break;
            }
        }
        System.out.println("Sorted Array Elements:");
        for (int n : array) {
            System.out.printf("%5d", n);
        }
        System.out.println();
    }
    public static void selectionsort(){
        array = original.clone();
        System.out.println("════════════════════════════════════════════════════════════");
        System.out.println("             ───✧─✦── SELECTION SORT ──✦─✧───             ");
        System.out.println("════════════════════════════════════════════════════════════");
    }
    public static void insertionsort(){
        array = original.clone();
        System.out.println("════════════════════════════════════════════════════════════");
        System.out.println("            ───✧─✦── INSERTION SORT ──✦─✧───              ");
        System.out.println("════════════════════════════════════════════════════════════");
        System.out.print("Given Array Elements: ");
        for(int n : array){
            System.out.printf("%5d", n);
        }
        System.out.println();
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
            System.out.printf("%d. ", i);
            for (int n : array) {
                System.out.printf("%5d", n);
            }
            System.out.println();
        }
        System.out.println("Sorted Array Elements:");
        for (int n : array) {
            System.out.printf("%5d", n);
        }
        System.out.println();
    }
    public static void returnButton() {
        System.out.println();
        System.out.println("────────────────────────────────────────────────────────────");
        System.out.println("          PRESS ENTER TO RETURN TO THE MAIN MENU...         ");
        System.out.println("────────────────────────────────────────────────────────────");
        System.out.println();
        
        sc.nextLine(); 
        clearConsole();
    }
}
