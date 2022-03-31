public class LongestPalindromeSub {
    public static String longestPalindrome(String s) {
        // write your code here

        /*
        loop through and extend, find each palindrome substr
        keep count of the longest one, record start/end index

        start from a center
        extend to both left and right,
            (A)if left = right, use all 3 as center, starting point center-1, center+1
            (B)if left = center, use left,center as center, starting point center-1, center
            (C)if center = right, use center,right as center, starting point center, center+1


        */
        if(s.length() <=1) {
            return s;
        } else if(s.length() <=2) {
            return s.charAt(0) == s.charAt(1)? s:null;
        }
        int left = 0,right=0;
        String result = "";
        for(int i = 1; i<s.length()-1; i++) {
            if(s.charAt(i-1) == s.charAt(i+1)) {
                //A
                left = i-1;
                right = i+1;
                while(left>=0 && right < s.length()) {
                    if(s.charAt(left) == s.charAt(right)) {
                        left--;
                        right++;
                    } else {
                        break;
                    }
                }//once exit loop, left,right compose of current longest palisub
                //compare with previous longest
                if(right - left - 1 > result.length()) {
                    result = s.substring(left+1, right);
                }
            }
            if(s.charAt(i-1) == s.charAt(i)) {
                //B
                left = i-1;
                right = i;
                while(left>=0 && right < s.length()) {
                    if(s.charAt(left) == s.charAt(right)) {
                        left--;
                        right++;
                    } else {
                        break;
                    }
                }//once exit loop, left,right compose of current longest palisub
                if(right - left - 1 > result.length()) {
                    result = s.substring(left+1, right);
                }
            }
            if (s.charAt(i) == s.charAt(i+1)) {
                //C
                left = i;
                right = i+1;
                while(left>=0 && right < s.length()) {
                    if(s.charAt(left) == s.charAt(right)) {
                        left--;
                        right++;
                    } else {
                        break;
                    }
                }//once exit loop, left,right compose of current longest palisub
                if(right - left - 1 > result.length()) {
                    result = s.substring(left+1, right);
                }
            }
        }
        return result;
    }


    public static String longestPalindromeKMP(String s) {
        return null;
    }
    public static void main(String[] args) {
        System.out.println(longestPalindrome("acccac"));
    }
}
