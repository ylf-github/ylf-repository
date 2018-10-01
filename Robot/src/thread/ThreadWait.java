package thread;

public class ThreadWait {
          public static void main(String[] args){
        	final Object obj=new Object();
        	System.out.println("main线程开始了");
        	  Thread t1=new Thread(){
        		  public void run(){
        			  synchronized(obj){
        				  System.out.println("T1 start!");
        				  try{
        					  obj.wait();
        				  }
        				  catch(Exception e){
        					  e.printStackTrace();
        				  }
        				  System.out.println("T1 end!");;
        			  }
        		  }
        	  };
        	  Thread t2=new Thread(){
        		  public void run(){
        			   synchronized(obj){
        				   System.out.println("T2 start!");
        				   try{
        					   obj.notify();
        				   }catch(Exception e){
        					   e.printStackTrace();
        				   }
        				   System.out.println("T2 end!");
        			   }
        		  }
        	  };
        	  
        	  t1.start();
        	  t2.start();
           try {
        	   synchronized(t1){
			t1.wait();
			System.out.println("test!");
        	   }
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}try{
			synchronized(t1){
				t1.notify();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
        	  System.out.println("main线程结束了！");
          }
}
