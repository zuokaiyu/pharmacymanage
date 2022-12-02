package com.pyy.pharmacy.order.controller;

import java.util.Comparator;

public  class  Test implements Comparator {
    private static String name;
    private  int age;

    static {
        Test.name="aa";
    }
    public static void run(){
        System.out.println();
    }


    @Override
    public int compare(Object o1, Object o2) {
        return 0;
    }

    public static class test1{
        void name(){
            System.out.println(Test.name);
        }
    }

}
