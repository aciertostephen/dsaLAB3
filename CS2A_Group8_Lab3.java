import java.util.Scanner;
/**
 * 
 * Group #8
 * Authors:Zac Luther Salceda
 * Stephen Shane Acierto
 * Genrev Pedrito
 * Laboratory Exercise #3
 * Date: Sept 7 , 2026
 */
public class CS2A_Group8_Lab3 {
    static int[] array = null;
    static int[] original = null;
    static Scanner sc = new Scanner(System.in);
    
    public static void main() {
        boolean runProgram = true;
        
        do {
            array = createArray();
            insertElement();
            original = array.clone();

            boolean runMenu = true;
            while (runMenu) {
                printMenu();
                System.out.print(" ■ Enter your choice: ");
                int selection = getValidInt();
                if ((selection == Integer.MIN_VALUE) || (selection < 1 || selection > 4)) {
                    System.out.println("\n                                                         ✧ Selection invalid. Please try again. ✧                                                         \n");
                    continue;
                }
            
                switch (selection) {
                        case 1:
                            bubbleSort();
                            break;
                        case 2:
                            selectionSort();
                            break;
                        case 3:
                            insertionSort();
                            break;
                        case 4:
                            boolean tryAgain = exit();
                            if (!tryAgain) {
                                System.out.print("\n──────────────────────────────────────────────────────────────┤ ✦ PROGRAM CLOSED ✦ ├──────────────────────────────────────────────────────────────");
                                runMenu = false;
                                runProgram = false;
                            } else {
                                runMenu = false;
                            } 
                        continue;
                }
                enterButton("                                                 PRESS ENTER TO RETURN TO MAIN MENU                                                 ");
            }
        } while (runProgram);
    }
    
    public static void printMenu() {
        clearConsole();
        System.out.println();
        System.out.println("════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════");
        System.out.println("                                                   ───✧─✦── SORTING ALGORITHMS ──✦─✧───                                                    ");
        System.out.println("════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════");
        System.out.println("                                                                   ‹ menu ›                                                                 ");
        System.out.println("────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────"); 
        System.out.println();
        System.out.println("                                                       [ 1 ]   Optimized Bubble Sort                                                        ");
        System.out.println("                                                       [ 2 ]   Selection Sort                                                               ");
        System.out.println("                                                       [ 3 ]   Insertion Sort                                                               ");
        System.out.println("                                                       [ 4 ]   Exit                                                                         ");
        System.out.println();
        System.out.println("════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════");
        System.out.println();
    }
    
    public static int[] createArray() {
        clearConsole();
        int size;
        
        System.out.println("════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════");
        System.out.println("                                                 ───✧─✦── ENTER ARRAY SIZE [ 5 - 15 ] ──✦─✧───                                              ");
        System.out.println("════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════");
        System.out.println();
        
        while (true) {
            System.out.print(" ■ Enter your choice : ");
            size = getValidInt();
            if ((size == Integer.MIN_VALUE) || (size < 5 || size > 15)) {
                System.out.println("\n                                                 ✧ Invalid. Choose a number between 5 and 15. ✧                                              \n");
                continue;
            }
            break;
        }         
        System.out.println("\n                                                           ✦ Array created with size " + size + " ✦"); 
        enterButton("                                                   PRESS ENTER TO INSERT ELEMENTS                                                   ");
        return new int[size];
    }
    
    public static void insertElement() {
        clearConsole();
        System.out.println();
        
        System.out.println("════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════");
        System.out.println("                                                   ───✧─✦── INSERT ARRAY VALUES ──✦─✧───                                                    ");
        System.out.println("════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════");
        System.out.println();
        
        int count = 0;
        while (count < array.length) {
            System.out.print(" ■ Enter element [" + (count + 1) + "/" + array.length + "]: ");
            int val = getValidInt();
            
                if (val == Integer.MIN_VALUE) {
                    System.out.println("\n                                                 ✧ Invalid Input. Please enter a number. ✧                                                   \n");
                    continue;
                }
                boolean duplicate = false;
                for (int i = 0; i < count; i++) {
                    if (array[i] == val) {
                       duplicate = true;
                       break;
                    }
                }
                if (duplicate) {
                    System.out.println("\n                                                 ✧ Duplicate values are not allowed. ✧                                                     \n");
                    continue; 
                }
                
                array[count] = val;
                count++;
            }
        
        enterButton("                                           PRESS ENTER IN ORDER TO PROCEED TO MAIN MENU                                             ");
    }     

    public static void bubbleSort() {
        clearConsole();
        array = original.clone();
        
        System.out.println("════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════");
        System.out.println("                                                   ───✧─✦── OPTIMIZED BUBBLE SORT ──✦─✧───                                                  ");
        System.out.println("════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════");
        System.out.println("   Given Array Elements:"); 
        printArray(array);
        System.out.println("────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────"); 
        System.out.println();
    
        for (int i = 0; i < array.length - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
    
            System.out.print(i+1 + ". ");
            printArray(array);
            System.out.println();
    
            if (!swapped) {
                break;
            }
        }
    
        System.out.println("════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════");
        System.out.println("   Sorted Array Elements:");
        printArray(array); 
        System.out.println("════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════");
    }
    
    public static void selectionSort() {
        clearConsole();
        array = original.clone();
        
        System.out.println("════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════");
        System.out.println("                                                     ───✧─✦── SELECTION SORT ──✦─✧───                                                       ");
        System.out.println("════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════");
        System.out.println("   Given Array Elements:"); 
        printArray(array);
        System.out.println("────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────"); 
        System.out.println();
    
        for (int i = 0; i < array.length - 1; i++) {
            int minIdx = i;
    
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIdx]) {
                    minIdx = j;
                }
            }
    
            swap(array, i, minIdx);
    
            System.out.print(i+1 + ". ");
            printArray(array); 
            System.out.println();
        }
        System.out.println("════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════");
        System.out.println("   Sorted Array Elements:");
        printArray(array); 
        System.out.println("════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════");
    }
     
    public static void insertionSort() {
        clearConsole();
        array = original.clone();
        
        System.out.println("════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════");
        System.out.println("                                                     ───✧─✦── INSERTION SORT ──✦─✧───                                                       ");
        System.out.println("════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════");
        System.out.println("   Given Array Elements:"); 
        printArray(array);
        System.out.println("────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────"); 
        System.out.println();
        
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
    
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
    
            
            System.out.print(i+1 + ". ");
            printArray(array); 
            System.out.println();
        }
        System.out.println("════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════");
        System.out.println("   Sorted Array Elements:");
        printArray(array); 
        System.out.println("════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════");
    }
    
    public static boolean exit() {
        clearConsole();
        
        System.out.println("════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════");
        System.out.println("                                                                    TRY AGAIN ?                                                                    ");
        System.out.println("════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════");
        System.out.println("                                                              [Y] Yes       [N] No                                                                 ");
        System.out.println("────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println();
        
        while (true) {
            System.out.print(" ■ Enter your choice : ");
            String action = sc.nextLine().trim();
            if (action.equalsIgnoreCase("Y")) {
                return true;
            } else if (action.equalsIgnoreCase("N")) {
                return false;
            } else 
                System.out.println("\n                                                ✧ Invalid action. Enter [Y] if Yes or [N] if No. ✧                                                  \n");
        }
    }
    
        private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public static void printArray(int[] arr) {
        int printCount = 0;
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%11d", arr[i]);
            printCount++;
            }
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
    
    public static void clearConsole() {
        System.out.print("\f");
        System.out.flush();
    }
    
    public static void enterButton(String prompt) {
        System.out.println();
        System.out.println("────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println(prompt);
        System.out.println("────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        
        sc.nextLine(); 
        clearConsole();
    }
}
