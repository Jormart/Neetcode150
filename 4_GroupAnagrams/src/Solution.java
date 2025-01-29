import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Check if the input is null or empty
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        // Create a map to store the anagrams as key and the list of anagrams as value
        Map<String, List<String>> map = new HashMap<>();

        int[] count = new int[26]; // Create an array to store the count of each character

        // Iterate through the input array
        for (String str : strs) {
            Arrays.fill(count, 0); // Reset the count array for each string
            // Iterate through each character in the string
            for (char c : str.toCharArray()) {
                count[c - 'a']++; // Increment the count of the character
            }

            // Create a key by converting the count array to a string
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                sb.append("#"); // Add a delimiter to separate the counts
                sb.append(count[i]); // Add the count of the character
            }

            String key = sb.toString(); // Convert the StringBuilder to a string

            // If the key is not present in the map, add it
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            // Add the string to the list of anagrams
            map.get(key).add(str);
        }

        // Return the list of anagrams
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
        System.out.println("Grouped Anagrams: " + sol.groupAnagrams(strs));
    }
}