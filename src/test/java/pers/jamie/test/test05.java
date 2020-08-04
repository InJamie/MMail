package pers.jamie.test;

public class test05 {

    public static void main(String[] args) {
        String s= "helloword";
        s+='a';

        test05.asd asd = new test05.asd();
        System.out.println(asd.b);
        System.out.println(asd.p);
    }


    public class as{
        private int a =1;

        void test(){
            System.out.println(a);
        }
    };

    public static class asd{
        static int p=4 ;
      private int b =2;
      void test(){
          System.out.println(p+b);
      }
    };

}
