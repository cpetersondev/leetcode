//https://leetcode.com/problems/longest-palindromic-substring/

class Solution {
    public String longestPalindrome(String s) {
        if (s.length() > 1){
            String longestPalindrome = "";
            for (int i=1; i<s.length(); i++){
                // test for even palindrome (if able)
                if (s.charAt(i-1) == s.charAt(i)){
                    int offset = palindrome(s, i, true, 1);
                    if ((offset*2)+2 > longestPalindrome.length()){
                        longestPalindrome = s.substring((i-offset-1),(i+offset+1));
                    }
                }
                // test for odd palindrome
                int offset = palindrome(s, i, false, 1);
                if ((offset*2)+1 > longestPalindrome.length()){
                    longestPalindrome = s.substring((i-offset),(i+offset+1));
                }
            }
            return longestPalindrome;
        }
        return s;
    }

    public int palindrome(String s, int pivot, boolean isEven, int offset){
        int i0 = isEven ? (pivot-offset-1) : (pivot-offset);
        int i1 = (pivot+offset);
        if ((i0>=0) && i1<s.length()){
            char before = s.charAt(i0);
            char after = s.charAt(i1);
            if (before == after){
                return 1 + palindrome(s, pivot, isEven, offset+1);
            }
            return 0;
        }
        return 0;
    }

    public static void main(String[] args){
        Solution test = new Solution();
        System.out.println(test.longestPalindrome("bab"));
    }
}