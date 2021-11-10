import java.io.File;

public class MainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String path = "C:\\Users\\omara\\eclipse-workspace\\Loggy\\src\\VideoSample.mp4";
		File file = new File(path);
		String fileName = file.getName();
		int index = fileName.lastIndexOf('.');
		String extension = "";
		String[] extensions = {"mpeg", "avi", "wav"};
		boolean check = false;
		int arrayIndex = 0;
		
		if(index > 0) {
			extension = fileName.substring(index + 1);
		//	System.out.println(fileName + "\n" + extension);
		}
		for(String x : extensions) {
			if(x.equalsIgnoreCase(extension)) {
				check = true;
				System.out.println(x);
				break;
			}else {
				System.out.println("extension not found!");
				break;
			}
		}
		System.out.println(check);
	}

}
