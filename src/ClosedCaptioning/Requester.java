package ClosedCaptioning;
//Requester with a run method that inserts String values in buffer 
public class Requester implements Runnable {
	private final Buffer sharedLocation; //reference to shared object
	private Recording r; //Reference to Recording instance
	
	//constructor
	public Requester(Buffer sharedLocation, Recording r) {
		super();
		this.sharedLocation = sharedLocation;
		this.r = r;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
			try {
				
				sharedLocation.blockingPut(r);
				System.out.println("(" + r.getName() + ") is being processed" + "\n");
			}
			catch(InterruptedException e) {
				Thread.currentThread().interrupt();
			}
	}

}
