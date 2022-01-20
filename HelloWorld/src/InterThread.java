

class Q
{
	int num;
	boolean valueSet = false;
	
	public synchronized void put(int num)
	{
		while(valueSet)
		{
			try { wait(); } catch(Exception e) {}
		}
		System.out.println("Put : " + num);
		this.num = num;
		valueSet = true;
		notify();
	}
	public synchronized void get()
	{
		while(!valueSet)
		{
			try { wait(); } catch(Exception e) {}
		}
		System.out.println("Get : " + num);
		valueSet = false;
		notify();
	}
}

class Producer implements Runnable
{
	// Queue object
	Q q;

	public Producer(Q q) {
		this.q = q;
		// second argument is thread name
		Thread t = new Thread(this, "Producer");
		t.start();
	}
	public void run()
	{
		int i = 0;
		//Infinite loop
		while(true)
		{
			q.put(i++);
			try { Thread.sleep(1000); } catch (Exception e) {}
		}
	}
}
class Consumer implements Runnable
{
	// Queue object
	Q q;
	
	public Consumer(Q q) {
		this.q = q;
		Thread t = new Thread(this, "Consumer");
		t.start();
	}
	public void run()
	{
		//Infinite loop
		while(true)
		{
			q.get();
			try { Thread.sleep(1000); } catch (Exception e) {}
		}
	}
}
public class InterThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Q q = new Q();
		new Producer(q);
		new Consumer(q);
	}

}
