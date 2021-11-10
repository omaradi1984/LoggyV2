package ClosedCaptioning;
import java.util.concurrent.ArrayBlockingQueue;

public class SynchronizedBuffer implements Buffer{

	private final ArrayBlockingQueue<Recording> buffer; //buffer to synchronize threads
	
	public SynchronizedBuffer() {
		this.buffer = new ArrayBlockingQueue<Recording>(5);
	}

	@Override
	public void blockingPut(Recording r) throws InterruptedException {
		// TODO Auto-generated method stub
		buffer.put(r);//Place value in buffer
	}

	@Override
	public Recording blockingGet() throws InterruptedException {
		// TODO Auto-generated method stub
		Recording r = buffer.take();//Remove value from buffer
		return r;
	}
}
