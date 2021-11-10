package ClosedCaptioning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ClosedCaptioningTester {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//Create recording instances
		Recording r1 = new Recording("Men in Black.rm", 100);
		Recording r2 = new Recording("Power Rangers.mp4", 120);
		Recording r3 = new Recording("Sonic.mp4", 60);
		Recording r4 = new Recording("Bionic Six.mp4", 90);
		Recording r5 = new Recording("Ghostbusters.mp4", 140);
		Recording r6 = new Recording("Gone with the Wind.mid", 210);
		Recording r7 = new Recording("I am blue.qck", 5);
		Recording r8 = new Recording("Smooth Criminal.mp3", 5);
		Recording r9 = new Recording("TMNT.mp4", 180);
				
		//Adding recording instances to array
		ArrayList<Recording> array = new ArrayList<Recording>();
		array.add(r1);
		array.add(r2);
		array.add(r3);
		array.add(r4);
		array.add(r5);
		array.add(r6);
		array.add(r7);
		array.add(r8);
		array.add(r9);
		
		validateFileType(array);
		
		createCaption(array);
	}
	public static void validateFileType(ArrayList<Recording> array) {
		String[] extensionArray = {"mp4", "avi", "mp3", "wav", "wmv", "wma"};//Array containing media extensions
		String fileName = "";
		int index = 0;
		String extension = "";

		for (int i = 0 ; i < array.size() ; i++) {
			for (Recording r : array) {
				fileName = r.getName();
				index = fileName.lastIndexOf(".");
				extension = fileName.substring(index+1);
				if(!Arrays.asList(extensionArray).contains(extension)) {
					array.remove(r);
					System.out.println("(" + r.getName() + ") has invalid file format. it has been removed from the queue." + "\n");
					break;
				}
			}
		}
	}

	public static void createCaption(ArrayList<Recording> array) throws InterruptedException {
		
		// Create new thread pool (5 threads)
		ExecutorService executor = Executors.newFixedThreadPool(5);
		
		// Create synchronized buffer to store objects
		Buffer sharedLocation = new SynchronizedBuffer();
		int counter = 0;// to tally how many files got processed
		
		for (int i = 0 ; i < array.size() ; i++) {
			executor.execute(new Requester(sharedLocation, array.get(i)));
			executor.execute(new ExternalService(sharedLocation));
			counter++;
		}
		
		//Shutting down ExecutorService
		executor.shutdown();
		executor.awaitTermination(1, TimeUnit.MINUTES);
		System.out.println("\n" + counter + " files have been processed.");
	}
}
