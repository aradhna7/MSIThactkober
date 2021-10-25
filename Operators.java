package com.Company;

import java.util.ArrayList;

public class Operators {
    public static void main(String[] args) {
        System.out.println('a' + 'b');
        System.out.println("a" + "b");
        System.out.println((char)('a' + 1));
        System.out.println("a" + 1);

        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(1000);
        System.out.println("sumit" + a);

        System.out.println("sumit" + new Integer(56));

        System.out.println(new Integer(56) + "" + a);
    }
}
