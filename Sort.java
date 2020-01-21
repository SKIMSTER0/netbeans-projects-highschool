package sort;

import java.util.Random;
import java.util.Scanner;

public class Sort {

    public static void menu() {
        System.out.println("Sort Seeker V1.0");
        System.out.println("<1> Selection Sort");
        System.out.println("<2> Insertion Sort");
        System.out.println("<3> Merge Sort");
        System.out.println("<4> Quick Sort");
        System.out.println("<5> Binary Search");
        System.out.println("<6> Configure list size");
        System.out.println("<7> Quit");
    }

    public static int[] shuffleList(int[] list) {    ///randomly shuffles array
        for (int i = 0; i < list.length; i++) {     ///unique int for each array element
            Random getRand = new Random();
            int rand = getRand.nextInt(list.length) + 0;
            list[i] = rand;
            //for(int n=0;n<i;n++)if(list[n]==list[i])i--;
        }
        return (list);
    }

    public static void selectionSort(int[] list) {
        int hold;
        final long startTime = System.currentTimeMillis();     ///System.nanoTime() for shorter times
        for (int i = 0; i < list.length; i++) {
            for (int n = i; n < list.length; n++) {
                if (list[n] < list[i]) {
                    hold = list[i];
                    list[i] = list[n];
                    list[n] = hold;
                }
            }
        }
        final long endTime = System.currentTimeMillis();      ///System.nanotime()
        System.out.println("Total execution Time: " + (endTime - startTime) + " milliseconds");
//        for(int i=0;i<list.length;i++)System.out.println(list[i]);
    }

    public static void insertionSort(int[] list) {
        int hold;
        int prevIndex;
        final long startTime = System.currentTimeMillis();
        for (int i = 1; i < list.length; i++) {
            hold = list[i];
            prevIndex = i - 1;
            while (list[prevIndex] > hold && prevIndex > 0) {
                list[prevIndex + 1] = list[prevIndex];
                prevIndex -= 1;
            }
            if (list[prevIndex] > hold) {
                list[prevIndex + 1] = list[prevIndex];
                list[prevIndex] = hold;
            } else {
                list[prevIndex + 1] = hold;
            }
        }
        final long endTime = System.currentTimeMillis();
        System.out.println("Total execution Time: " + (endTime - startTime) + " milliseconds");
//        for(int i=0;i<list.length;i++)System.out.println(list[i]);
    }

    public static void mergeSort(int[] list, int start, int end) { ///SLOWER THAN INSERTION?
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(list, start, mid);
            mergeSort(list, mid + 1, end);
            merge(list, start, mid, end);
        }
    }

    private static void merge(int[] list, int start, int mid, int end) {
        int[] temp = new int[list.length];
        int pos1 = start;
        int pos2 = mid + 1;
        int spot = start;

        while (!(pos1 > mid && pos2 > end)) {
            if ((pos1 > mid) || ((pos2 <= end) && (list[pos2] < list[pos1]))) {
                temp[spot] = list[pos2];
                pos2++;
            } else {
                temp[spot] = list[pos1];
                pos1++;
            }
            spot++;
        }
        for (int i = start; i <= end; i++) {
            list[i] = temp[i];
        }
    }

    public static void quickSort(int[] list) {

    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] list = new int[10000];
        int choice;

        System.out.println("Shuffling list...");
        list = shuffleList(list);
        menu();
        do {
            choice = input.nextInt();
            if (choice == 1) {
                selectionSort(list);
            }
            if (choice == 2) {
                insertionSort(list);
            }
            if (choice == 3) {
                final long startTime = System.currentTimeMillis();
                mergeSort(list, 0, list.length - 1);
                final long endTime = System.currentTimeMillis();
                System.out.println("Total execution Time: " + (endTime - startTime) + " milliseconds");
            }
            if (choice == 4) {
                quickSort(list);
            }
        } while (choice != 6);
    }

}
