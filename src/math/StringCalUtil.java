package math;

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

        int l = l1 < l2 ? l1 : l2;
        int m = l1 > l2 ? l1 : l2;

        for (int i = 0; i < l; i++) {
            v1 = Character.getNumericValue(a1.charAt(l1-1-i));
            v2 = Character.getNumericValue(a2.charAt(l2-1-i));

            v = v1 + v2;
            if (plus) v++;
            if (v > 9) {
                s.add(i, v - 10);
                plus = true;
            } else {
                s.add(i, v);
                plus = false;
            }
        }
        String h = l1 > l2 ? a1 : a2;
        for (int i = 0; i < m-l; i++) {
            v = Character.getNumericValue(h.charAt(m-l-1-i));
            if (plus) {
                s.add(v+1);
            } else {
                s.add(v);
            }
            plus = false;
        }
        if (m==l && plus) {
            s.add(1);
        }

        int size = s.size();
        for (int i = 0; i < size; i++) {
            sum += s.get(size -1 - i);
        }

        return sum;
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

        int l1 = a1.length();
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

    public static void main(String[] args) {
        System.out.println(multiple("2342342","35345334235434656456456456457"));
    }
}
