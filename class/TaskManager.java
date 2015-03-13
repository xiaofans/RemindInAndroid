package xiaofan.concurrent;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;


public class TaskManager {
	
	 // Sets the initial threadpool size to 8
    private static final int CORE_POOL_SIZE = 8;
    // Sets the maximum threadpool size to 8
    private static final int MAXIMUM_POOL_SIZE = 8;
    // Sets the Time Unit to seconds
    private static final TimeUnit KEEP_ALIVE_TIME_UNIT = TimeUnit.SECONDS;;
    private static final int KEEP_ALIVE_TIME = 1;
	
	private static TaskManager sIntance = null;
	private final BlockingQueue<Runnable> taskQuene;
	private final ThreadPoolExecutor taskThreadPool;
	
	private static  AtomicInteger COUNT = new AtomicInteger(0);
	private static volatile int COUNT2 = 0;
	
	static{
		sIntance = new TaskManager();
	}
	
	private TaskManager(){
		taskQuene = new LinkedBlockingDeque<Runnable>();
		taskThreadPool = new ThreadPoolExecutor(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, KEEP_ALIVE_TIME, KEEP_ALIVE_TIME_UNIT, taskQuene);
	}
	
	
	
	
	public void start(){
		for(int i = 0; i < 100; i ++){
			taskThreadPool.execute(new Task());
		}
	}
	
	
	
	class Task implements Runnable{

		@Override
		public void run() {
			synchronized (COUNT) {
				System.out.println("current thread:" + COUNT.addAndGet(1));
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	public static void main(String[] args) {
		TaskManager.sIntance.start();
	}



}

