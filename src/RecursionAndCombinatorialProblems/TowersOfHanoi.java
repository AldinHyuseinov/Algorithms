package RecursionAndCombinatorialProblems;

import java.util.*;

public class TowersOfHanoi {
    private static int counter;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int diskSize = Integer.parseInt(scanner.nextLine());

        Deque<Integer> source = new ArrayDeque<>();
        Deque<Integer> destination = new ArrayDeque<>();
        Deque<Integer> spare = new ArrayDeque<>();

        for (int i = diskSize; i >= 1; i--) {
            source.push(i);
        }

        printDiskState(source, destination, spare);
        solve(diskSize, source, destination, spare);
    }

    private static void solve(int disk, Deque<Integer> source, Deque<Integer> destination, Deque<Integer> spare) {

        if (disk == 0) {
            return;
        }
        solve(disk - 1, source, spare, destination);

        if (!source.isEmpty()) {
            destination.push(source.pop());
        }
        print(source, destination, spare);
        solve(disk - 1, spare, destination, source);
    }

    private static void print(Deque<Integer> source, Deque<Integer> destination, Deque<Integer> spare) {
        counter++;
        printStep();
        printDiskState(source, destination, spare);
    }

    private static void printDiskState(Deque<Integer> source, Deque<Integer> destination, Deque<Integer> spare) {
        System.out.println("Source: " + formatStack(source));
        System.out.println("Destination: " + formatStack(destination));
        System.out.println("Spare: " + formatStack(spare));
        System.out.println();
    }

    private static String formatStack(Deque<Integer> stack) {
        StringBuilder sb = new StringBuilder();
        Iterator<Integer> iterator = stack.descendingIterator();

        while (iterator.hasNext()) {
            sb.append(iterator.next());

            if (iterator.hasNext()) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    private static void printStep() {
        System.out.println("Step #" + counter + ": Moved disk");
    }
}
