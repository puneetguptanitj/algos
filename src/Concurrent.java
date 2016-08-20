import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class Concurrent {
	public static List<String> iterateOver = new ArrayList<String>();
	public static void main(String []args) throws InterruptedException{
		iterateOver.add("one");
		iterateOver.add("two");
		iterateOver.add("three");
		final SynchronousQueue<Integer> test = new SynchronousQueue<>();
		Thread thread1 = new Thread(new Runnable(){

			@Override
			public void run() {
				try {
					System.out.println("Trying to take");
					test.take();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				iterateOver = new ArrayList<String>();
				iterateOver.add("five");
				iterateOver.add("six");
			}
			
		});
		Thread thread2 = new Thread(new Runnable(){

			@Override
			public void run() {
				
				for(String i: iterateOver){	
					System.out.println(i);
					try {
						System.out.println("Trying to put");
						test.put(1);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
		});
		thread2.start();
		Thread.sleep(5000);
		thread1.start();
		
	}
}
