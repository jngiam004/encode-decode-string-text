class Printer {
	// This synchronized keyword will acquire a lock, we call it an intrinsic lock.
	// Once the lock is acquired, no other thread can access the print documents
	// So rather than having the join function call, so if multiple threads are
	// going to access the same method again and again, synchronize them
	synchronized void printDocuments(int numOfCopies, String docName) {
	//void printDocuments(int numOfCopies, String docName) {
		for(int i = 1; i <= numOfCopies; i++)
		{
			// sleep method will temporary pause the execution
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(">> Printing Document " + docName + " " + i);
		}
	}
}

class MyThread extends Thread {
	
	Printer pRef;
	MyThread(Printer p){
		pRef = p;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		//super.run();
//		synchronized(pRef) {
//			pRef.printDocuments(10, "JohnsProfile.pdf");
//		}
		pRef.printDocuments(10, "JohnsProfile.pdf");
	}
	
}
class YourThread extends Thread {
	
	Printer pRef;
	YourThread(Printer p){
		pRef = p;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		//super.run();
		pRef.printDocuments(10, "FionnasProfile.pdf");
	}
	
}
public class SyncApp {

	// main method represents main thread
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("==Application Started==");
		
		// We have only 1 single object of Printer
		Printer printer = new Printer();
		//printer.printDocuments(10, "IshantsProfile.pdf");
		
		// Scenario is that we have multiple thread working on the same Printer Object
		// if multiple threads are going to work on the same single object, we must synchronize them
		MyThread mRef = new MyThread(printer);		// MyThread is having reference to the Printer Object
		YourThread yRef = new YourThread(printer);	// YourThread is having reference to the Printer Object
		
		mRef.start();
		/*
		try {
			// synchronization coming into action
			mRef.join(); // wait for MyThread to finish/complete its job before proceeding to start YourThread 
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		yRef.start();
		System.out.println("==Application Finished==");
	}

}
