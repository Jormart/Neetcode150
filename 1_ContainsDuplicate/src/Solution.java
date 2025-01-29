import java.util.HashSet;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        // Create a HashSet to store elements from the array
        HashSet<Integer> set = new HashSet<>();

        // Iterate through the array
        for (int num : nums) {
            // If the element is already in the set, return true
            if (set.contains(num)) {
                return true; // Duplicate found
            }

            // Otherwise, add the element to the set
            set.add(num);
        }
        return false; // No duplicates found
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Should return true
        System.out.println(solution.containsDuplicate(new int[] { 1, 2, 3, 1 }));

        // Should return false
        System.out.println(solution.containsDuplicate(new int[] { 1, 2, 3, 4 }));

        // Should return true
        System.out.println(solution.containsDuplicate(new int[] { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 }));
    }
}
