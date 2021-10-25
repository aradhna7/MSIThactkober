package com.Company;

import java.util.Locale;

public class Palindrome {
    public static void main(String[] args) {
        String str = "A man, a plan, a canal: Panama";
        str.toLowerCase(Locale.ROOT);
        System.out.println(str);
        System.out.println(isPalindrome("naman"));
    }

    static boolean isPalindrome(String a){
        int s=0, e=a.length()-1;

        while(s<e){
            char start = a.charAt(s);
            char end = a.charAt(e);
            if(start != end){
                return false;
            }
            s++;
            e--;
        }
        return true;
    }
}
