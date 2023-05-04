package RecursionAndCombinatorialProblems;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ConnectedAreasInMatrix {
    private static char[][] matrix;

    private static int size = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());
        matrix = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
            matrix[i] = scanner.nextLine().toCharArray();
        }

        Map<int[], Integer> areasAndSizes = new HashMap<>();

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                if (matrix[row][col] == '-') {
                    findArea(row, col);
                    int[] rowAndCol = {row, col};
                    areasAndSizes.put(rowAndCol, size);
                    size = 0;
                }
            }
        }
        print(areasAndSizes);
    }

    private static void print(Map<int[], Integer> areasAndSizes) {
        System.out.println("Total areas found: " + areasAndSizes.size());
        AtomicInteger counter = new AtomicInteger(1);

        areasAndSizes.entrySet().stream()
                .sorted((first, sec) -> {
                    int compare = sec.getValue().compareTo(first.getValue());

                    if (compare == 0) {
                        int[] firstArr = first.getKey();
                        int[] secArr = sec.getKey();

                        if (firstArr[0] != secArr[0]) {
                            return firstArr[0] - secArr[0];
                        }
                        return firstArr[1] - secArr[1];
                    }
                    return compare;
                })
                .forEach(e -> System.out.println("Area #" + counter.getAndIncrement() + " at " +
                        Arrays.toString(e.getKey())
                                .replaceAll("\\[", "(")
                                .replaceAll("]", ")") + ", size: " + e.getValue()));
    }

    private static void findArea(int row, int col) {

        if (!isInBounds(row, col) || matrix[row][col] == 'V' || matrix[row][col] == '*') {
            return;
        }

        matrix[row][col] = 'V';

        findArea(row, col + 1);
        findArea(row, col - 1);
        findArea(row + 1, col);
        findArea(row - 1, col);

        size++;
    }

    private static boolean isInBounds(int row, int col) {
        return row < matrix.length && row >= 0 && col < matrix[row].length && col >= 0;
    }
}
