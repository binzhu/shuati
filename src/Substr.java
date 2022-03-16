public class Substr {
    /**
     * @param source:
     * @param target:
     * @return: return the index
     */
    public static int strStr(String source, String target) {
        // Write your code here
        if(target.length() == 0){
            return 0;
        }
        for(int i = 0;i<source.length();i++) {
            for(int j = 0;j<target.length();j++) {
                if(j + i < source.length() && source.toCharArray()[j+i] == target.toCharArray()[j]) {
                    if(j == target.length()-1) {
                        return i;
                    } else {
                        continue;
                    }
                }
                else {
                    break;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("abcdef", "def"));
    }
}
