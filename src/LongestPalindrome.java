import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestPalindrome {


    //627 longest palindrome count
    public static int longestPalindromeintCharCount(String s) {
        int[] cnt = new int[52];
        int ans = 0, odd = 0;
        for(char c:s.toCharArray()) {
            if(c>=97) {
                cnt[26 + c - 97]++;
            } else {
                cnt[c - 'A']++;
            }
        }

        for(int i = 0; i<52; i++) {
            ans+=cnt[i]/2*2;
            if(odd == 0 && cnt[i]%2 == 1) {
                odd = 1;
            }
        }
        ans+= odd;
        return ans;
    }

    public static int longestPalindromeintCharCountImproved(String s) {
        int[] cnt = new int[123];
        int ans = 0, odd = 0;
        for(char c:s.toCharArray()) {
            cnt[c]++;
        }

        for(int i = 'A'; i<'A'+26; i++) {
            ans+=cnt[i]/2*2;
            ans+=cnt[i+('a'-'A')]/2*2;
            if(odd == 0 && (cnt[i]%2 == 1 || cnt[i+('a'-'A')]%2 == 1)) {
                odd = 1;
            }
        }
        ans+= odd;
        return ans;
    }

    public static int longestPalindromeintCharCountSinglePass(String s) {
        Set<Character> resource = new HashSet<>();
        int ans = 0;
        for(char c:s.toCharArray()) {
            if(!resource.contains(c)) {
                resource.add(c);
            } else {
                resource.remove(c);
                ans += 2;
            }
        }

        if(resource.size() == 0) {
            return ans;
        } else {
            return ans+1;
        }
    }


    public static int longestPalindrome(String s) {
        // write your code here
        Map<Character, Integer> resource = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(resource.containsKey(ch)) {
                resource.put(ch, resource.get(ch) + 1);
            } else {
                resource.put(ch, 1);
            }
        }
        boolean oddexist = false;

        int ans = 0;
        for (Map.Entry<Character, Integer> entry : resource.entrySet()) {
            ans += entry.getValue()/2*2;
            if(entry.getValue() % 2 == 1) {
                oddexist = true;
            }
        }
        if(oddexist) {
            ans++;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindromeintCharCountSinglePass("aaaaaaaaaaaaaaaaaaaaaaaaaaa"));

    }
}
