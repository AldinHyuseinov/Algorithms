package RecursionAndCombinatorialProblems;

import java.util.Scanner;

public class CombinationsWithRepetition {
    public static int[] arr;

    public static int[] elements;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int k = Integer.parseInt(scanner.nextLine());
        arr = new int[k];
        elements = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            elements[i] = i;
        }

        combination(0, 1);
    }

    private static void combination(int index, int start) {

        if (index == arr.length) {
            print();
            return;
        }

        for (int i = start; i < elements.length; i++) {
            arr[index] = elements[i];
            combination(index + 1, i);
        }
    }

    private static void print() {

        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
