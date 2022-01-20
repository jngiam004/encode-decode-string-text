/*class MyTask {
	void executeTask() {
		for(int doc=1; doc<=10; doc++)
		{
			System.out.println("@@ Printing Document #" + doc + " - Printer 2");
		}
	}
}*/
// MyTask is a thread (is a relationship)
/*class MyTask extends Thread {
	@Override
	public void run() {
		for(int doc=1; doc<=10; doc++)
		{
			System.out.println("@@ Printing Document #" + doc + " - Printer 2");
		}
	}
}*/
class CA {
	
}
class MyTask extends CA implements Runnable {
	@Override
	public void run() {
		for(int doc=1; doc<=10; doc++)
		{
			System.out.println("@@ Printing Document #" + doc + " - Printer 2");
		}
	}
}
class YourTask implements Runnable {
	@Override
	public void run() {
		for(int doc=1; doc<=10; doc++)
		{
			System.out.println("@@ Printing Document #" + doc + " - Printer 3");
		}
	}
}
public class App {

	// main method represents main thread
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// whatever we write in here will be executed by main thread
		// thread always execute the jobs in a sequence
		// Execution Context
		
		// Job1
		System.out.println("==Application Started==");
		
		// Job2
		//MyTask task = new MyTask();	// Child Thread / Worker Thread
		//task.executeTask();
		//task.start(); // start shall internally execute run method
		Runnable r = new MyTask();
		Thread task = new Thread(r);
		task.setDaemon(true);
		task.start();
		
		//Thread yourTask = new Thread(new YourTask());
		//yourTask.start();
		new Thread(new YourTask()).start();
		// Till Job2 is not finished, below written jobs are waiting and are not executed
		
		// Now main and MyTask are executing both parallely or concurrently !!
		
		// Job3
		// Some code to print the documents
		for(int doc=1; doc<=10; doc++)
		{
			System.out.println("Printing Document #" + doc + " - Printer 1");
		}
		
		// Job4
		System.out.println("==Application Finished==");
	}

}
