import java.util.*;

class Solution {
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        // if the list is empty, return the empty string
        if (strs.size() == 0)
            return Character.toString((char) 258);
        // if the list is not empty, return the string with the strings separated by the
        // character with ASCII value 257
        String separate = Character.toString((char) 257);
        StringBuilder sb = new StringBuilder();
        // append all the strings to the string builder
        for (String s : strs) {
            sb.append(s);
            sb.append(separate);
        }
        // remove the last separator
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String str) {
        // if the string is empty, return an empty list
        if (str.equals(Character.toString((char) 258)))
            return new ArrayList<>();
        // if the string is not empty, split the string by the character with ASCII
        // value 257 and return the list
        String separate = Character.toString((char) 257);
        // -1 is used to keep the empty strings at the end of the list
        return Arrays.asList(str.split(separate, -1));
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        List<String> strs = new ArrayList<>();
        strs.add("Hello");
        strs.add("World");
        strs.add("!");
        String encoded = sol.encode(strs);
        System.out.println(encoded);
        List<String> decoded = sol.decode(encoded);
        System.out.println(decoded);
    }
}