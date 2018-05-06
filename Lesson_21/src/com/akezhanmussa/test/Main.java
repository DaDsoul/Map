package com.akezhanmussa.test;

import com.akezhanmussa.impl.KeyValuePair;
import com.akezhanmussa.impl.LLQueueMap;
import com.akezhanmussa.adt.Map;
import com.akezhanmussa.impl.LLStackMap;
import com.akezhanmussa.impl.LinkedListStack;

public class Main {

    public static void main(String[] args) {
        Map<Integer, String> testMap = new LLQueueMap<>();

        try{
            testMap.removeAny();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }

        System.out.println(testMap);

        String value = "";
        for(int i = 0; i<5; i++){
            value = "Adam" + i;
            testMap.define(i, value);
        }


        System.out.println(testMap);
        System.out.println(testMap.getSize());

        testMap.remove(1);
        System.out.println(testMap);
        System.out.println(testMap.getSize());

        testMap.remove(6);
        System.out.println(testMap);
        System.out.println(testMap.getSize());

        for(int i = 0; i<2;i++){
            testMap.define(i, "Adam6");
        }

        System.out.println(testMap);
        System.out.println(testMap.getSize());

        for(int i = 0; i<3; i++){
            testMap.define(5+i,"Adam7");
        }

        System.out.println(testMap);
        System.out.println(testMap.getSize());

        try{
            for(int i = 0; i<2; i++){
                KeyValuePair<Integer, String> pair = testMap.removeAny();
                System.out.println(pair);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }

        System.out.println(testMap);
        System.out.println(testMap.getSize());

        testMap.clear();
        System.out.println(testMap);
        System.out.println(testMap.getSize());

        testMap.define(1, "Adam1");
        testMap.define(2, "Adam2");

        System.out.println(testMap);
        System.out.println(testMap.getSize());

//The another implementation of the MAP ADT by using LLStack
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("----------------------------------");
        System.out.println();

        Map<Integer, String> anotherTestMap = new LLStackMap<>();
        try{
            anotherTestMap.removeAny();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }

        System.out.println(anotherTestMap);

        for(int i = 0; i<5; i++){
            value = "Adam" + i;
            anotherTestMap.define(i, value);
        }


        System.out.println(anotherTestMap);
        System.out.println(anotherTestMap.getSize());

        anotherTestMap.remove(1);
        System.out.println(anotherTestMap);
        System.out.println(anotherTestMap.getSize());

        anotherTestMap.remove(6);
        System.out.println(anotherTestMap);
        System.out.println(anotherTestMap.getSize());

        for(int i = 0; i<2;i++){
            anotherTestMap.define(i, "Adam6");
        }

        System.out.println(anotherTestMap);
        System.out.println(anotherTestMap.getSize());

        for(int i = 0; i<3; i++){
            anotherTestMap.define(5+i,"Adam7");
        }

        System.out.println(anotherTestMap);
        System.out.println(anotherTestMap.getSize());

        try{
            for(int i = 0; i<2; i++){
                KeyValuePair<Integer, String> pair = anotherTestMap.removeAny();
                System.out.println(pair);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }

        System.out.println(anotherTestMap);
        System.out.println(anotherTestMap.getSize());

        anotherTestMap.clear();
        System.out.println(anotherTestMap);
        System.out.println(anotherTestMap.getSize());

        anotherTestMap.define(1, "Adam1");
        anotherTestMap.define(2, "Adam2");

        System.out.println(anotherTestMap);
        System.out.println(anotherTestMap.getSize());
    }
}
