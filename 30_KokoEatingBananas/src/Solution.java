class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // The left boundary is 1, the minimum speed to eat a pile
        int left = 1, right = 1;
        // The right boundary is the maximum number of bananas in a pile
        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        // Binary search to find the minimum speed
        while (left < right) {
            int mid = left + (right - left) / 2;
            // If the current speed can eat all the piles within h hours
            if (canEatAll(piles, h, mid)) {
                right = mid;
            } else { 
                left = mid + 1;
            }
        }
        return left; // The minimum speed 
    }

    // Helper function to check if the current speed can eat all the piles within h hours
    private static boolean canEatAll(int[] piles, int h, int speed) {
        int hours = 0;
        for (int pile : piles) {
            // Round up the division to the nearest integer
            hours += (pile + speed - 1) / speed; // Equivalent to ceil(pile / speed)
        }
        return hours <= h;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] piles = {3, 6, 7, 11};
        int h = 8;
        // Output: 4
        System.out.println(solution.minEatingSpeed(piles, h));
    }
}