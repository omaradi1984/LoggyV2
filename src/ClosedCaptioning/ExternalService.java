package ClosedCaptioning;
//External service with a run method that loops to read the strings
public class ExternalService implements Runnable{

	private final Buffer sharedLocation; //reference to shared object
	
	//constructor
	public ExternalService(Buffer sharedLocation) {
		super();
		this.sharedLocation = sharedLocation;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
				try {
					Recording r = sharedLocation.blockingGet();
					String readValue = r.getName();
					Thread.sleep(r.getLength()*100);
					System.out.println("(" + readValue + ") has been processed" + "\n");
				}
				catch(InterruptedException e) {
					Thread.currentThread().interrupt();
				}
	}
}
