package com.abot.testservice;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * @author weibao
 */
public class TestCase {
   @Test
   void testIntegerCache(){
       Integer i01 = 59;
       Integer i02 = 59;
       Integer i03 = Integer.valueOf(59);
       Integer i04 = new Integer(59);
       System.out.println(i01==i02); // true
       System.out.println(i01==i03); // true
       System.out.println(i03==i04); // false
       System.out.println(i02==i04); // false
   }

   @Test
    void test2(){
       Map<Integer,Integer> map = new Hashtable<>();
       map.put(null,2);
       Integer a;

   }
}
