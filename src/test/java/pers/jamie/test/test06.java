package pers.jamie.test;

public class test06 {
    public static void main(String[] args) {
        System.out.println(new String("asd").equals(new String("asd")));
        String a= new String("asd");
        String b = new String("asd");
        System.out.println(a == b);
        String c =null ;
        String d =null;
//        System.out.println(c.equals(d));
        String asd = "a";
        System.out.println(asd+"b");
        System.out.println(test());
    }
    public static int test(){
        int x = 1;
        try {
            return ++x;
        }finally {
             ++x;
        }
    }
}
