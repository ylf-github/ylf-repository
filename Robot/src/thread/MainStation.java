package thread;

public class MainStation {
          public static void main(String[] args){
        	  Station station1=new Station("窗口1");
        	  Station station2=new Station("窗口2");
        	  Station station3=new Station("窗口3");
        	  //让每一个站台对象各自开始工作
        	  station1.start();
        	  station2.start();
        	  station3.start();
          }
}
