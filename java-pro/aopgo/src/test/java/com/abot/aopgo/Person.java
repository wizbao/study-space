package com.abot.aopgo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author weibao
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private String name;
    private Integer age;
    private String gender;

    public void show(){
        System.out.println("person show");
    }

    private static void staticShow(){
        System.out.println("staticShow");
    }
}
