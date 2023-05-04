package RecursionAndCombinatorialProblems;

import java.util.Scanner;

public class NestedLoopsToRecursion {
    public static int[] arr;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        arr = new int[n];
        recursion(0);
    }

    private static void recursion(int n) {

        if (n == arr.length) {
            print();
            return;
        }

        for (int i = 1; i <= arr.length; i++) {
            arr[n] = i;
            recursion(n + 1);
        }
    }

    private static void print() {

        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
