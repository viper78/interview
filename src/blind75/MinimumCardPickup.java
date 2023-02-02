package blind75;

public class MinimumCardPickup {

    public static void main(String[] args) {

        int[] cards = {3, 4, 2, 3, 4, 7};
        int minCards = Integer.MAX_VALUE;
        int left = 0;
        int duplicateOccurences = 0;
        int[] count = new int[10];

        for (int right = 0; right < cards.length; right++) {
            duplicateOccurences = Math.max(duplicateOccurences, ++count[cards[right]]);
            if (duplicateOccurences > 1) {
                minCards = Math.min(minCards, right - left + 1);
                count[cards[left]]--;
                left++;
            }
        }
        if (minCards > cards.length) {
            System.out.println(-1);
        } else {
            System.out.println(minCards);
        }
    }
}
