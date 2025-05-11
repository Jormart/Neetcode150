import java.util.*;
// 846. Hand of Straights
// https://leetcode.com/problems/hand-of-straights/description/

class Solution {
    // Greedy approach to check if we can form groups of consecutive numbers
    // from the given hand of cards.
    // The idea is to sort the hand and then try to form groups of size groupSize
    // by checking if the next group of consecutive numbers can be formed.
    // If we can form all groups, we return true; otherwise, we return false.
    // Time complexity: O(n log n) for sorting the hand, where n is the number of
    // cards.
    // Space complexity: O(n) for storing the frequency of cards in a HashMap.
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false; // If the total number of cards is not divisible by groupSize, return false
        }

        HashMap<Integer, Integer> cardCount = new HashMap<>();
        for (int card : hand) {
            cardCount.put(card, cardCount.getOrDefault(card, 0) + 1);
        }

        Arrays.sort(hand); // Sort the hand to process cards in ascending order

        for (int card : hand) {
            if (cardCount.get(card) == 0) {
                continue; // Skip if this card has already been used in a group
            }
            for (int i = 0; i < groupSize; i++) {
                int nextCard = card + i;
                if (cardCount.getOrDefault(nextCard, 0) == 0) {
                    return false; // If we can't find the next card in the group, return false
                }
                cardCount.put(nextCard, cardCount.get(nextCard) - 1); // Decrease the count of the used card
            }
        }

        return true; // All groups can be formed successfully
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] hand = { 1, 2, 3, 4, 5 };
        int groupSize = 4;
        System.out.println(solution.isNStraightHand(hand, groupSize)); // Output: false
    }
}