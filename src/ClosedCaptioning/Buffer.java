package ClosedCaptioning;
//Buffer interface with methods called by requester and external service
public interface Buffer {

	//Place String value into the buffer
	public void blockingPut(Recording r) throws InterruptedException;
	
	//return String value from Buffer
	public Recording blockingGet() throws InterruptedException;
}
