/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarysearch;

import java.util.ArrayList;

public class LongestPalindromicSubstring {

    public void LongestPalindromicSubstring() {
        String s = "mactacocatbook";
        int iResult = 0;
        for (int i = 0; i < s.length(); i++) {
            if (positions(s.substring(i), s.charAt(i), i) > iResult) {
                iResult = positions(s.substring(i), s.charAt(i), i);
            }
        }
        System.out.println(iResult);
    }

    public int positions(String sValue, char cValue, int i) {
        int iMayor = 0;
        StringBuilder sNewValue = new StringBuilder(sValue);
        sNewValue.setCharAt(0, '-');
        int iSearch = sNewValue.indexOf("" + cValue);
        while (iSearch != -1) {
            sNewValue.setCharAt(iSearch, '-');
            StringBuilder sReverse = new StringBuilder(sNewValue.substring(0, iSearch + 1));
            if (sNewValue.substring(0, iSearch + 1).toString()
                    .equals(sReverse.reverse().toString())) {
                if (sReverse.length() > iMayor) {
                    iMayor = sReverse.length();
                }
            }
            iSearch = sNewValue.indexOf("" + cValue);
        }
        return iMayor;
    }
}
