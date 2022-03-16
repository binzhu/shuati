public class LongestPalindromeSub {
    public static String longestPalindrome(String s) {
        // write your code here

        /*
        loop through and extend, find each palindrome substr
        keep count of the longest one, record start/end index

        start from a center
        extend to both left and right,
            (A)if left = center, use left,center as center, starting point center-1, center
            (B)if center = right, use center,right as center, starting point center, center+1
            (C)if left = right, use all 3 as center, starting point center-1, center+1

        */

        for(int i = 1; i<s.length(); i++) {
            if(s.charAt(i-1) == s.charAt(i+1)) {
                //C
            } else if(s.charAt(i-1) == s.charAt(i)) {
                //A
            } else if (s.charAt(i) == s.charAt(i+1)) {
                //B
            } else {
                //none equal center, continue
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abcdebbccddccbbasd"));
    }
}
