package org.interview.task.okta;

import org.testng.Assert;

public class Substring {
    public static void main(String[] args) {
        String input = "oktaforokta";
        int len = lengthOfLongestSubstring(input);
        System.out.println("The length of the longest substring without repeating characters: " + len);

        //the length should be 6 for "ktafor" substring
        Assert.assertEquals(len, 6);
    }

    //Length of the longest substring without repeating characters
    //ex: oktaforokta
    public static int lengthOfLongestSubstring(String inputString) {
        // Get the length of the input string.
        int n = inputString.length();
        // Initialize result to store the length of the longest substring without repeating characters.
        int result = 0;

        // 'i' is the left pointer to indicate the starting index of the current substring.
        int i = 0;

        // 'j' is the right pointer to indicate the ending index of the current substring.
        int j = 0;

        // A set to store characters in the current substring.
        // It helps in constant-time lookups to check if a character is repeating or not.
        java.util.Set<Character> set = new java.util.HashSet<>();

        // The loop continues as long as neither 'i' nor 'j' exceed the string length.
        while (i < n && j < n) {
            // If the character at the 'j' position is not in the set, it's a new unique character for the current substring.
            if (!set.contains(inputString.charAt(j))) {
                // Add the character to the set.
                set.add(inputString.charAt(j));

                // Update the result if the current substring length (j - i + 1) is greater than previous results.
                result = Math.max(result, j - i + 1);

                // Move the 'j' pointer to the next position to continue expanding the substring.
                j++;
            } else {
                // If the character at the 'j' position is already in the set, it means the substring has a repeating character.

                // Remove the character at the 'i' position from the set to shrink the current substring from the left.
                set.remove(inputString.charAt(i));

                // Move the 'i' pointer to the next position.
                i++;
            }
        }
        // Return the length of the longest substring without repeating characters.
        return result;
    }

}
