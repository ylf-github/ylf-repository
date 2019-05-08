package com.ylf.Clazz;

public class NoName {
    int i=3;

    public void no(){
        final int p=99;
        System.out.println(p);
    }

    public void test(){
//        int k=1;
//        System.out.println(k);
        Sys sys=new Sys() {
                int r=3;
            @Override
            public void out() {
               System.out.println(r);
            }
        };
        sys.out();
    }



    public static void main(String[] args){
//         Sys s=new Sys() {
//             @Override
//             public void out() {
//                 System.out.println("haha");
//             }
//         };
//         s.out();
        new NoName().test();
    }
}
class Syc{
    public void show(int a){
        System.out.println(a);
    }
}
interface Sys{
    void out();
}