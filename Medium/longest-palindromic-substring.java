//https://leetcode.com/problems/longest-palindromic-substring/

class Solution {
    public String longestPalindrome(String s) {
        String palindrome = "";
        if (s.length() > 0){
            palindrome = ""+s.charAt(0);
            for (int i=1; i<s.length(); i++){
                boolean couldBeEven = false;
                // test for even condition
                if (s.charAt(i)==s.charAt(i-1)){
                    couldBeEven = true;
                    palindrome = palindrome.length()<2 ? ""+s.charAt(i)+s.charAt(i-1) : palindrome;
                }
                // look for 3+ char palindrome
                boolean isPalindrome = true;
                int offset = 1;
                while (isPalindrome && (offset <= i) && (offset+i < s.length())){
                    boolean isEvenPalindrome = false;
                    boolean isOddPalindrome = false;
                    if (couldBeEven && i-offset-1>=0){
                        char before = s.charAt(i-offset-1);
                        char after = s.charAt(i+offset);
                        if (before == after){
                            isEvenPalindrome = true;
                            String newPalindrome = s.substring((i-offset-1), (i+offset+1));
                            if (palindrome.length() < newPalindrome.length()){
                                palindrome = newPalindrome;
                            }
                        } else {
                            couldBeEven = false;
                        }
                    }
                    char before = s.charAt(i-offset);
                    char after = s.charAt(i+offset);
                    if (before == after){
                        isOddPalindrome = true;
                        String newPalindrome = s.substring((i-offset), (i+offset+1));
                        if (palindrome.length() < newPalindrome.length()){
                            palindrome = newPalindrome;
                        }
                    }
                    if (!(isEvenPalindrome || isOddPalindrome)) {
                        isPalindrome = false;
                    }
                    offset++;
                }
            }
        }
        return palindrome;
    }

    public static void main(String[] args){
        Solution test = new Solution();
        System.out.println(test.longestPalindrome("fkwwkkf"));
    }
}