/**
 * A library of string functions.
 */
public class MyString {
    public static void main(String args[]) {
        String hello = "hello";
        System.out.println(countChar(hello, 'h'));
        System.out.println(countChar(hello, 'l'));
        System.out.println(countChar(hello, 'z'));
        System.out.println(spacedString(hello));
        System.out.println("Test 1: " + countChar("Center", 'e'));
        System.out.println("Test 2: " + countChar("Center", 'c'));
        System.out.println("Test 3: " + subsetOf("pass", "space"));  // false
        System.out.println("Test 4: " + subsetOf("c", "space"));     // true
        System.out.println(subsetOf("sap", "space")); //returns true
        System.out.println(subsetOf("spa", "space")); //returns true
        System.out.println(subsetOf("pass", "space")); //returns false
        System.out.println(subsetOf("c", "space")); //returns true
        System.out.println(subsetOf("a", "c"));
        System.out.println(spacedString("silent")); // returns "s i l e n t"
        System.out.println(randomStringOfLetters(3));

    }

    /**
     * Returns the number of times the given character appears in the given string.
     * Example: countChar("Center",'e') returns 2 and countChar("Center",'c') returns 0.
     *
     * @param str - a string
     * @param ch  - a character
     * @return the number of times c appears in str
     */
    public static int countChar(String str, char ch) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char x = str.charAt(i);
            if (x == ch) {
                count++;
            }
        }
        return count;
    }

    /**
     * Returns true if str1 is a subset string str2, false otherwise
     * Examples:
     * subsetOf("sap","space") returns true
     * subsetOf("spa","space") returns true
     * subsetOf("pass","space") returns false
     * subsetOf("c","space") returns true
     *
     * @param str1 - a string
     * @param str2 - a string
     * @return true is str1 is a subset of str2, false otherwise
     */
    public static boolean subsetOf(String str1, String str2) {
        boolean foundChar = false;
        for (int i = 0; i < str1.length(); i++) {
            foundChar = false;
            char x1 = str1.charAt(i);
            for (int j = 0; j < str2.length(); j++) {
                char x2 = str2.charAt(j);
                if (x1 == x2) {
                    foundChar = true;
                    break;
                }
            }
            if (countChar(str1, x1) > countChar(str2, x1)) {
                return false;
            }
        }
        return foundChar;
    }


    /**
     * Returns a string which is the same as the given string, with a space
     * character inserted after each character in the given string, except
     * for the last character.
     * Example: spacedString("silent") returns "s i l e n t"
     *
     * @param str - a string
     * @return a string consisting of the characters of str, separated by spaces.
     */
    public static String spacedString(String str) {
        String strNew = "";
        for (int i = 0; i < str.length(); i++) {
            char x = str.charAt(i);
            strNew = strNew + x + " ";
        }
        strNew = strNew.substring(0, strNew.length() - 1);
        return strNew;
    }

    /**
     * Returns a string of n lowercase letters, selected randomly from
     * the English alphabet 'a', 'b', 'c', ..., 'z'. Note that the same
     * letter can be selected more than once.
     * <p>
     * Example: randomStringOfLetters(3) can return "zoo"
     *
     * @param n - the number of letter to select
     * @return a randomly generated string, consisting of 'n' lowercase letters
     */
    public static String randomStringOfLetters(int n) {
        String randomStr = "";
        char[] alphabet = new char[26];
        for (int i = 0; i < alphabet.length; i++) {
            alphabet[i] = (char) ('a' + i);
        }
        for (int i = 0; i < n; i++) {
            int randomNumber = (int) (Math.random() * 26);
            randomStr = randomStr + alphabet[randomNumber];
        }
        return randomStr;
    }

    /**
     * Returns a string consisting of the string str1, minus all the characters in the
     * string str2. Assumes (without checking) that str2 is a subset of str1.
     * Example: remove("meet","committee") returns "comit"
     *
     * @param str1 - a string (committee)
     * @param str2 - a string (meet)
     * @return a string consisting of str1 minus all the characters of str2
     */
    public static String remove(String str1, String str2) {
        for(int i = 0; i < str2.length(); i++){
            char current = str2.charAt(i);
            int x = str1.indexOf(current);
            str1 = str1.substring(0,x) + str1.substring(x+1);
        }
        return str1;
    }

    /**
     * Returns a string consisting of the given string, with the given
     * character inserted randomly somewhere in the string.
     * For example, insertRandomly("s","cat") can return "scat", or "csat", or "cast", or "cats".
     *
     * @param ch  - a character
     * @param str - a string
     * @return a string consisting of str with ch inserted somewhere
     */
    public static String insertRandomly(char ch, String str) {
        // Generate a random index between 0 and str.length()
        int randomIndex = (int) (Math.random() * (str.length() + 1));
        // Insert the character at the random index
        String result = str.substring(0, randomIndex) + ch + str.substring(randomIndex);
        return result;
    }
}
