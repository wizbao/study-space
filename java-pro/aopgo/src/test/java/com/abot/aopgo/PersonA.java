package com.abot.aopgo;

/**
 * @author weibao
 */
public class PersonA extends Person{
    public void a(){
        super.show();
    }

    public static void main(String[] args) {
    }
}
class A{
    private String name;
    public class B{
        public String bName;
        public void bShow(){
            System.out.println(name);
            System.out.println("bShow");
        }

    }

}

class C{
    public static void main(String[] args) {
        A.B b = new A().new B();

        b.bShow();
    }
}