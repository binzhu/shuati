public class IsPalindrome {
    public static boolean isPalindrome(String s) {
        // write your code here
        if(s.length() == 0) return true;
        char[] sarray = s.toCharArray();
        int j = s.length()-1;
        for(int i = 0; i< s.length(); i++) {
            while(!isAlphanumeric(sarray[i]) && i < j){
                i++;
            }
            while(!isAlphanumeric(sarray[j]) && i < j){
                 j--;
            }
            if (!equalsIgnoreCase(sarray[i], sarray[j])){
                return false;
            } else if (j-i == 1 || j == i) {
                 return true;
            }
            j--;
        }
        return false;
    }

    private static boolean isAlphanumeric(char input) {
        return (input >= 48 && input<= 57 ) || (input >= 65 && input<= 90 ) || (input >= 97 && input<= 122 );
    }

    private static boolean equalsIgnoreCase(char a, char b) {
        if(a <= 'Z' && a >= 'A') {
            a += ('a' - 'A');
        }
        if(b <= 'Z' && b >= 'A') {
            b += ('a' - 'A');
        }
        return a == b;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("ab"));
    }
}
