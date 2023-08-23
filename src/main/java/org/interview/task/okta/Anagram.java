package org.interview.task.okta;

import org.testng.Assert;

public class Anagram {
    public static void main(String[] args) {

        String str1 = "okta";
        String str2 = "atko";
        boolean isAnagram1 = isAnagram(str1, str2);
        Assert.assertTrue(isAnagram1);
        System.out.println("Strings " + str1 + " and " + str2 + " are " + (isAnagram1 ? "anagrams" : "not anagrams"));

        String str3 = "listen";
        String str4 = "silent";
        boolean isAnagram2 = isAnagram(str3, str4);
        Assert.assertTrue(isAnagram2);
        System.out.println("Strings " + str3 + " and " + str4 + " are " + (isAnagram2 ? "anagrams" : "not anagrams"));

        String str5 = "listen";
        String str6 = "loosen";
        boolean isAnagram3 = isAnagram(str5, str6);
        Assert.assertFalse(isAnagram3);
        System.out.println("Strings " + str5 + " and " + str6 + " are " + (isAnagram3 ? "anagrams" : "not anagrams"));

    }

    //Check if the 2 given strings are anagram
    // Ex: str1= okta str2= atko
    // str1 = “listen”  str2 = “silent”
    public static boolean isAnagram(String str1, String str2) {
        // Check if lengths of both strings are the same. If not, they cannot be anagrams.
        if (str1.length() != str2.length()) return false;

        // Convert the first string to lowercase and then to a character array.
        // This ensures the anagram check is case-insensitive.
        char[] str1Chars = str1.toLowerCase().toCharArray();

        // Convert the second string to lowercase and then to a character array.
        char[] str2Chars = str2.toLowerCase().toCharArray();

        // Use Java's built-in sort method to sort the characters in the first string.
        java.util.Arrays.sort(str1Chars);

        // Similarly, sort the characters in the second string.
        java.util.Arrays.sort(str2Chars);

        // Convert the sorted character arrays back to strings.
        // If they are anagrams, the sorted strings should be identical.
        // The 'equals' method checks if the sorted strings are the same.
        return new String(str1Chars).equals(new String(str2Chars));
    }
}
