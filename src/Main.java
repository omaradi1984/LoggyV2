import java.io.File;
import java.util.Scanner;
import java.util.UUID;

public class Main {
		public static String in = "";
		public static Scanner sc = new Scanner(System.in);
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		logOptionMessage();
		
		logTypeValidation();
		
	}
	
	public static void logOptionMessage() {
		System.out.println("Please choose the type of log: " + "\n" +
							"1. TextLog"+ "\n" + "2. VideoLog"  + "\n" + "3. PhotoLog"  + "\n" + "4. AudioLog" + "\n" +
							"Type the number: ");
		in = sc.next();
	}
	
	public static void logTypeValidation() {
		switch(in) {
		case "1":
			createTextLog();
		break;
		case "2": 
			createVideoLog();
		break;
		case "3": createPhotoLog();
		break;
		case "4": 
			createAudioLog();
		break;
		default:
			System.out.println("Please choose a log type from the above list." + "\n" + "Type the number: ");
			in = sc.next();
		}
	}
	
	public static void createTextLog() {
		String path = "/Loggy/src/TestFile.txt";
		Log tl = new TextLog("My first TextLog", "This is a description!", new File(path));
		tl.translate();
		tl.validate(tl.getFile(), tl.getFile().length());
					System.out.println("TextLog ID: " + tl.getId() + "\n" +
										"Code: " + tl.getCode() + "\n" +
										"Date: " + tl.getDate() + "\n" +
										"Name: " + tl.getName() + "\n" +
										"Description: " + tl.getDescription() + "\n" + 
										"Name Translation: " + tl.translate().getNameTranslation() + "\n" +
										"Description Translation: " + tl.translate().getDescriptionTranslation() + "\n" +
										"Attachment: " + tl.getFile().exists());
	}
	
	public static void createVideoLog() {
		String path = "C:\\Users\\omara\\eclipse-workspace\\Loggy\\src\\VideoSample.mp4";
		Log vl = new VideoLog("First VideoLog","This is my first VideoLog", new File(path));
		vl.caption();
		vl.transcode();
		vl.validate(vl.getFile(), vl.getFile().length());
		System.out.println("VideoLog ID: " + vl.getId() + "\n" +
				"Code: " + vl.getCode() + "\n" +
				"Date: " + vl.getDate() + "\n" +
				"Name: " + vl.getName() + "\n" +
				"Description: " + vl.getDescription() + "\n" + 
				"Caption: " + vl.caption().getCaption() + "\n" +
				"Attachment: " + vl.getFile().exists());
	}
	
	public static void createAudioLog() {
		String path = "";
		Log al = new AudioLog("First AudioLog","This is my first AudioLog", new File(path));
		al.caption();
		al.transcode();
		al.validate(al.getFile(), al.getFile().length());
		System.out.println("VideoLog ID: " + al.getId() + "\n" +
				"Code: " + al.getCode() + "\n" +
				"Date: " + al.getDate() + "\n" +
				"Name: " + al.getName() + "\n" +
				"Description: " + al.getDescription() + "\n" + 
				"Caption: " + al.caption().getCaption() + "\n" +
				"Attachment: " + al.getFile().exists());
	}
	
	public static void createPhotoLog() {
		String path = "";
		Log pl = new PhotoLog("First PhotoLog","This is my first PhotoLog", new File(path));
		pl.annotate();
		pl.validate(pl.getFile(), pl.getFile().length());
		System.out.println("VideoLog ID: " + pl.getId() + "\n" +
				"Code: " + pl.getCode() + "\n" +
				"Date: " + pl.getDate() + "\n" +
				"Name: " + pl.getName() + "\n" +
				"Description: " + pl.getDescription() + "\n" + 
				"Attachment: " + pl.getFile().exists());
	}
}
