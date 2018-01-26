package com.math;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by winston.xie on 27/10/2016 AD.
 */
public class StringCalUtil {

    public static String plus(String a1, String a2) {

        int l1 = a1.length();
        int l2 = a2.length();
        int v1, v2, v;
        List<Integer> s = new ArrayList<>();
        boolean plus = false;
        String sum = "";
        String longStr, smallStr;


        if (l1 > l2) {
            longStr = a1;
            smallStr = a2;
        } else {
            longStr = a2;
            smallStr = a1;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Math.abs(l1-l2); i++) {
            sb.append("0");
        }
        smallStr = sb.append(smallStr).toString();

        int index;
        int len = longStr.length();
        for (int i = 0; i < len; i++) {
            index = len-1-i;
            v1 = Character.getNumericValue(longStr.charAt(index));
            v2 = Character.getNumericValue(smallStr.charAt(index));

            v = v1 + v2;
            if (plus) v++;
            if (v > 9) {
                s.add(v - 10);
                plus = true;
            } else {
                s.add(v);
                plus = false;
            }
        }

        if (plus) {
            s.add(1);
        }

        int size = s.size();
        for (int i = 0; i < size; i++) {
            sum += s.get(size -1 - i);
        }

        return sum;
    }

    /**
     *
     * @param a1 String
     * @param a2 String
     * a1 > a2
     * @return String
     */
    public static String minus(String a1, String a2) {

        int l1 = a1.length();
        int l2 = a2.length();

        if (l1 < l2) return null;

        int v1, v2, v, index = 0;
        List<Integer> s = new ArrayList<>();
        boolean minus = false;
        String result = "";


        for (int i = 0; i < l2; i++) {
            v1 = Character.getNumericValue(a1.charAt(l1-1-i));
            v2 = Character.getNumericValue(a2.charAt(l2-1-i));

            if (minus) v1--;
            if (v1 < v2) {
                v1 = v1 + 10;
                minus = true;
            } else {
                minus = false;
            }
            s.add(v1-v2);
        }
        for (int i = 0; i < l1-l2; i++) {
            index = l1-l2-1-i;
            v = Character.getNumericValue(a1.charAt(index));
            if (minus) {
                v--;
                minus = false;
            }
            if (!(index == 0 && v == 0)) s.add(v);
        }
        int size = s.size();
        for (int i = 0; i < size; i++) {
            if (s.get(size -1 - i) != 0) {
                index = size -1 - i;
                break;
            }
        }
        for (int i = index; i >= 0; i--) {
            result += s.get(i);
        }

        return result;
    }

    public static String multiple(String a, int b) {

        int l = a.length();
        int v, v1, v2=0;
        String sum = "";
        
        List<Integer> s = new ArrayList<>();

        for (int i = 0; i < l; i++) {
            v = Character.getNumericValue(a.charAt(l-1-i));
            v = v * b + v2;
            v1 = v%10;
            s.add(v1);
            v2 = (v-v1)/10;
        }
        if (v2 > 0) {
            s.add(v2);
        }
        int size = s.size();
        for (int i = 0; i < size; i++) {
            sum += s.get(size -1 - i);
        }

        return sum;
    }

    public static String multiple(String a1, String a2) {

//        int l1 = a1.length();
        int l2 = a2.length();

        int v;
        String b1="", b2;

        for (int i = 0; i < l2; i++) {
            v = Character.getNumericValue(a2.charAt(l2-1-i));
            b2 = multiple(a1, v);
            for (int j = 0; j < i; j++) {
                b2 += '0';
            }
            b1 = plus(b1, b2);
        }

        return b1;
    }

    public static String index(String a1, String a2) {

        String result = a1;

        String indexTimes = "1";

        while (lessThan(indexTimes, a2)) {
            result = multiple(result, a1);
            indexTimes = plus(indexTimes, "1");
        }

        return result;

    }

    /**
     *
     * @param numerator String
     * @param denominator String
     * @return List
     *
     * quotient < 10
     */
    public static List<String> singleDivide(String numerator, String denominator) {

        List<String> result = new ArrayList<>();

        if (lessThan(numerator, denominator)) {
            result.add(String.valueOf(0));
            result.add(trimFirstZeros(numerator));
            return result;
        }

        String multiResult = null;
        int quotient = 0;

        boolean end = false;
        for (int i = 9; i > 0 && !end; i--) {
            multiResult = multiple(denominator, i);
            end = noMoreThan(multiResult, numerator);
            quotient = i;
        }
        String remainder = minus(numerator, multiResult);

        result.add(String.valueOf(quotient));
        result.add(remainder);

        return result;
    }

    public static boolean isExactDivide(String numerator, String denominator) {

        List<String> result = divide(numerator, denominator);
        return result.get(1).equals("0");
    }

    public static List<String> divide(String numerator, String denominator) {

        int l1 = numerator.length();
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        List<Integer> s = new ArrayList<>();
        String quotient, remainder = null;
        List<String> r;

        for (int i = 0; i < l1; i++) {
            sb.append(numerator.charAt(i));
            r = singleDivide(sb.toString(), denominator);
            quotient = r.get(0);
            remainder = r.get(1);
            s.add(Integer.valueOf(quotient));
            sb = new StringBuilder(remainder);
        }

        int index = 0;
        for (int i = 0; i < s.size(); i++) {
            if (s.get(i) != 0) {
                index = i;
                break;
            }
        }

        quotient = "";
        for (int i = index; i < s.size(); i++) {
            quotient += String.valueOf(s.get(i));
        }
        result.add(quotient);
        result.add(remainder);

        return result;
    }

    public static boolean equal(String a1, String a2) {

        boolean result = a1.length() == a2.length();
        int b1, b2;

        for (int i = 0; result && i < a1.length(); i++) {
            b1 = Character.getNumericValue(a1.charAt(i));
            b2 = Character.getNumericValue(a2.charAt(i));
            if (b1 != b2) {
                result = false;
                break;
            }
        }
        return result;
    }

    public static boolean lessThan(String a1, String a2) {

        a1 = trimFirstZeros(a1);
        a2 = trimFirstZeros(a2);

        if (a1.length() < a2.length()) return true;

        if (a1.length() > a2.length()) return false;

        boolean result = false;
        for (int i = 0; i < a1.length(); i++) {
            int v1 = Character.getNumericValue(a1.charAt(i));
            int v2 = Character.getNumericValue(a2.charAt(i));
            if (v1 < v2) {
                result = true;
                break;
            } else if (v1 > v2) {
                result = false;
                break;
            }
        }
        return result;
    }

    public static boolean noMoreThan(String a1, String a2) {

        a1 = trimFirstZeros(a1);
        a2 = trimFirstZeros(a2);

        if (a1.length() < a2.length()) return true;

        if (a1.length() > a2.length()) return false;

        boolean result = true;
        for (int i = 0; i < a1.length(); i++) {
            int v1 = Character.getNumericValue(a1.charAt(i));
            int v2 = Character.getNumericValue(a2.charAt(i));
            if (v1 < v2) {
                result = true;
                break;
            } else if (v1 > v2) {
                result = false;
                break;
            }
        }
        return result;
    }

    private static String trimFirstZeros(String input) {

        boolean allZero = true;
        for (int i = 0; allZero && i < input.length(); i++) {
            if (Character.getNumericValue(input.charAt(i)) != 0) {
                allZero = false;
            }
        }

        if (allZero) return "0";

        int index = 0;
        for (int i = 0; i < input.length(); i++) {
            int tmp = Character.getNumericValue(input.charAt(i));
            if (tmp != 0) {
                index = i;
                break;
            }
        }
        return input.substring(index);
    }

    public static void main(String[] args) {
        System.out.println(index("2","77232917"));

        System.out.println("abcdefg".substring(0,3));

        String str = "00000";
        System.out.println(trimFirstZeros(str));

        System.out.println(Math.abs(1-4));
    }
}
