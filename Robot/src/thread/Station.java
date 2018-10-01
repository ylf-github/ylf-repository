package thread;

public class Station extends Thread{
       public Station(String name){
    	   super(name);
       }
       static int tick=20;
       static Object ob=1.1;
       @Override
       public void run(){
    	   while(tick>0){
    		   synchronized(ob){
    			   if(tick>0){
    				   System.out.println(getName()+"卖出了第"+tick+"张票");
    				   tick--;
    			   }else{
    				   System.out.println("票买完了");
    			   }
    		   }
    	   try{
    			   sleep(100);//休息一秒
    		   }catch(Exception e){
    			   e.printStackTrace();
    		   }
    	   }
       }
}
