//https://leetcode.com/problems/longest-palindromic-substring/

class Solution {
    public String longestPalindrome(String s) {
        String palindrome = "";
        for (int i=1; i<s.length(); i++){
            // test for 2 char palindrome
            if (s.charAt(i)==s.charAt(i-1)){
                palindrome = ""+s.charAt(i)+s.charAt(i-1);
            }
            // look for 3+ char palindrome 
            boolean isPalindrome = true;
            int offset = 1;
            while (isPalindrome && (offset <= i) && (offset+i < s.length())){
                char before = s.charAt(i-offset);
                char after = s.charAt(i+offset);
                if (before == after){
                    String newPalindrome = s.substring((i-offset), (i+offset+1));
                    if (palindrome.length() < newPalindrome.length()){
                        palindrome = newPalindrome;  
                    } 
                } 
                else {
                    isPalindrome = false;    
                }
                offset++;
            }
        }
        return palindrome; 
    }
}
