package RecursionAndCombinatorialProblems;

import java.util.Arrays;
import java.util.Scanner;

public class ReverseArray {
    public static int[] reversedArr;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        reversedArr = new int[arr.length];
        reverseArr(arr, arr.length - 1);
    }

    private static void reverseArr(int[] arr, int length) {

        if (length == -1) {
            print();
            return;
        }
        reversedArr[arr.length - 1 - length] = arr[length];
        reverseArr(arr, length - 1);
    }

    private static void print() {

        for (int i : reversedArr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
