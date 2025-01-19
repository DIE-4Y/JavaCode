package com.nenu.map_;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Homework03 {
    public static void main(String[] args) {
        HashMap m = new HashMap();
        m.put("jack", 650);
        m.put("tom", 1200);
        m.put("smith", 2900);

        System.out.println("=========第一次遍历");
        System.out.println(m);
        m.put("jack", 2700);

        Set entrySet = m.entrySet();

        System.out.println("=======第二次遍历=========");
        Iterator iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);
        }

        System.out.println("============第三次遍历=============");
        for (Object o : entrySet) {
            Map.Entry entry = (Map.Entry) o;
            m.put(entry.getKey(), (int) entry.getValue() + 1000);
            System.out.println("name:" + entry.getKey() + " salary:" + entry.getValue());
        }

    }

}
