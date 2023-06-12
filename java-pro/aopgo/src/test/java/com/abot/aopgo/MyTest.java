package com.abot.aopgo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Predicate;

/**
 * @author weibao
 */
class MyTest {
    @Test
    void test1(){
//        List<String> list = Arrays.asList("1","2","3");
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        /*for (int i = 0; i < list.size() ;i++) {
            System.out.println(list.get(i));
            if (list.get(0).equals("1")) {
                list.remove(0);
            }
        }*/
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            if (next.equals("2")) {
                iterator.remove();
            }
        }
//        list.removeIf(s -> s.equals("2"));
        System.out.println(list.toString());
    }

    @Test
     void test2(){
        String str = "";
        String ￥void = "人民币";
        String[] split = str.split(".");
        System.out.println(Arrays.toString(split));
        System.out.println(split.length);
        System.out.println(￥void);
    }

    @Test
    void test3(){
        Collection<Person> collection = new ArrayList();
        collection.add(new Person("张三", 22, "男"));
        collection.add(new Person("李四", 19, "女"));
        collection.add(new Person("王五", 34, "男"));
        collection.add(new Person("赵六", 30, "男"));
        collection.add(new Person("田七", 25, "女"));
//过滤30岁以上的求职者
//        Iterator<Person> iterator = collection.iterator();
//        while (iterator.hasNext()) {
//            Person person = iterator.next();
//            if (person.getAge() >= 30)
//                iterator.remove();
//        }
        collection.removeIf(
                person -> person.getAge() >= 30
        );//过滤30岁以上的求职者

        System.out.println(collection.toString());//查看结果

    }

    @Test
    void test4(){
        System.out.println(Person.class);
    }
}
class Animal{
    protected void show(){
        System.out.println("show Animal");
    }
    protected float getNum(){
        return 3.0f;
    }
}
class Cat extends Animal{

    public void show(String name) {
        System.out.println("show Cat");
    }
    public void getNum(double d){}
    public double getNum(double d,float f){return 4.0d;}
    public float getNum(float d){
        return 4F;
    }
}