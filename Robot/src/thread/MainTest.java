package thread;

public class MainTest {
        public static void main(String[] args){
        	Test1 test1=new Test1("线程1");
        	Test2 test2=new Test2("线程2");
        	test1.start();
        	test2.start();
        }
}
