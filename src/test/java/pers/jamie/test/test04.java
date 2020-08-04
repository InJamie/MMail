package pers.jamie.test;

import javax.servlet.GenericServlet;
import javax.servlet.http.HttpServlet;

public class test04 {
    static final int a=1;
    public static void main(String[] args) {
        String message = "helloword";
        String a = "hello";
        String b = "word";
        String c = "hello"+"word";

        System.out.println(message==(a+b));
        System.out.println(message==c);
        GenericServlet asd;
        HttpServlet asdas;
        System.out.println(test03.a);

        test03 test03 = new test03();

    }
    public static int a(int a){
        char f = 'a';
        int f1 = (int)f;
        System.out.println(f1);
        return (int)f;
    }

    public int x(){
        char c = 'a';
        return (int)c;
    }
}
