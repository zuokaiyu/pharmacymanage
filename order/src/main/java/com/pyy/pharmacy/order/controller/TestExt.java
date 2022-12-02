package com.pyy.pharmacy.order.controller;




import com.fasterxml.jackson.databind.util.ArrayIterator;

import java.io.*;
import java.util.*;

public class TestExt {


    public static void main(String[] args) {
        File file = new File("D:\\桌面\\a.txt");
        FileOutputStream fileOutputStream=null;
        FileInputStream fileInputStream = null;



        try {
            fileOutputStream = new FileOutputStream(file);
            fileInputStream =new FileInputStream(file);
            try {
                String a="abcde";
                byte[] aByte = a.getBytes();
                System.out.println(aByte);
                fileOutputStream.write(aByte);



                int len;
                byte[] bytes = new byte[2];
                while((len=fileInputStream.read(bytes))!=-1){
                    System.out.println(new String(bytes,0,len));

                }


                Writer writer = new FileWriter(file);
                writer.write("草ace",1,2);
                writer.write(97);

                writer.flush();
                writer.close();


                FileReader fileReader = new FileReader(file);
                char[] chars = new char[3];
                fileReader.read(chars);
                System.out.println(chars);

                fileReader.close();


            } catch (IOException e) {
                e.printStackTrace();
            }



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                fileOutputStream.close();
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



        ArrayList<Test> objects = new ArrayList<>();

        HashSet hashSet = new HashSet();
        HashMap<Object, Object> map = new HashMap<>();
        Iterator iter=objects.iterator();
        LinkedList<Object> objects1 = new LinkedList<>();

        TreeSet<Test> objects2 = new TreeSet<>(new Test());


        while (iter.hasNext()){
            System.out.println(iter.hasNext());

        }
    }



}
