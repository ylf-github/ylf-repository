package thread;

public class Test2 extends Thread{
	
	static String name;
	
	Test2(String name){
		super(name);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int i=0;
		while(i<3){
			i++;
			System.out.println(getName()+"执行!");
			try{
				//sleep(1000);
				}catch(Exception e){
				e.printStackTrace();
			}
		}
	
	}


}
