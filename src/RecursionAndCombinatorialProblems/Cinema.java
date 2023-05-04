package RecursionAndCombinatorialProblems;

import java.util.*;
import java.util.stream.Collectors;

public class Cinema {
    private static List<String> variations = new ArrayList<>();

    private static String[] currentVariation;

    private static boolean[] used;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> friends = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());
        Map<String, Integer> pickyFriends = new HashMap<>();

        String pickyFriend = scanner.nextLine();

        while (!pickyFriend.equals("generate")) {
            String[] friendAndSeat = pickyFriend.split(" - ");

            friends.remove(friendAndSeat[0]);
            pickyFriends.put(friendAndSeat[0], Integer.parseInt(friendAndSeat[1]));

            pickyFriend = scanner.nextLine();
        }
        int nonPickyFriends = friends.size();
        used = new boolean[nonPickyFriends];
        currentVariation = new String[nonPickyFriends];

        variation(friends, 0);

        String[] distributedFriends = new String[nonPickyFriends + pickyFriends.size()];

        for (int i = 1; i <= distributedFriends.length; i++) {
            for (Map.Entry<String, Integer> friend : pickyFriends.entrySet()) {

                if (friend.getValue() == i) {
                    distributedFriends[i - 1] = friend.getKey();
                }
            }
        }

        for (String variation : variations) {
            String[] arr = variation.split(" ");

            for (String s : arr) {
                for (int k = 0; k < distributedFriends.length; k++) {

                    if (distributedFriends[k] == null) {
                        distributedFriends[k] = s;
                        break;
                    }
                }
            }
            System.out.println(String.join(" ", distributedFriends));

            for (String s : arr) {
                for (int k = 0; k < distributedFriends.length; k++) {

                    if (distributedFriends[k] != null && distributedFriends[k].equals(s)) {
                        distributedFriends[k] = null;
                        break;
                    }
                }
            }
        }
    }

    private static void variation(List<String> friends, int index) {

        if (index == friends.size()) {
            addToVariations();
            return;
        }

        for (int i = 0; i < friends.size(); i++) {

            if (!used[i]) {
                used[i] = true;
                currentVariation[index] = friends.get(i);
                variation(friends, index + 1);
                used[i] = false;
            }
        }
    }

    private static void addToVariations() {
        StringBuilder sb = new StringBuilder();

        for (String friend : currentVariation) {
            sb.append(friend).append(" ");
        }
        variations.add(sb.toString());
    }
}
