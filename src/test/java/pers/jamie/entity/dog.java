package pers.jamie.entity;

public class dog extends animal {
    @Override
    public void move() {
        System.out.println("狗子可以跑");;
    }

    public void bark(){
        System.out.println("狗子再叫");
    }
}
