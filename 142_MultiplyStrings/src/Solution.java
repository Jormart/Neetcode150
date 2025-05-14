// 43. Multiply Strings
// https://leetcode.com/problems/multiply-strings/description/
class Solution {
    // Approach:
    // 1. Initialize a result array of size m + n, where m and n are the lengths of
    // num1 and num2 respectively.
    // 2. Iterate through each digit of num1 and num2 in reverse order.
    // 3. For each pair of digits, multiply them and add the result to the
    // appropriate position in the result array.
    // 4. Handle carry for each position in the result array.
    // 5. Convert the result array back to a string, skipping leading zeros.
    // 6. Return the final result string.
    // Time Complexity: O(m * n), where m and n are the lengths of num1 and num2
    // respectively.
    // Space Complexity: O(m + n), for the result array.
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int m = num1.length();
        int n = num2.length();
        int[] result = new int[m + n];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = mul + result[i + j + 1];

                result[i + j + 1] = sum % 10;
                result[i + j] += sum / 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int num : result) {
            if (!(sb.length() == 0 && num == 0)) {
                sb.append(num);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String num1 = "123";
        String num2 = "456";
        System.out.println(solution.multiply(num1, num2)); // Output: "56088"
    }
}