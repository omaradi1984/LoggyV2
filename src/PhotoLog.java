import java.io.File;

public class PhotoLog extends Log {
	
	private final String[] extensions = {".jpeg", ".gif", ".bmp"};
	private final double maxFileSize = 50;

	public PhotoLog() {
		// TODO Auto-generated constructor stub
	}

	public PhotoLog(String name, String description, File file) {
		super(name, description, file);
		// TODO Auto-generated constructor stub
	}

	public PhotoLog(String name, String description) {
		super(name, description);
		// TODO Auto-generated constructor stub
	}

	public PhotoLog(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Translation translate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Annotation annotate() {
		// TODO Auto-generated method stub
		Annotation a = new Annotation();
		return a;
	}

	@Override
	public Captioning caption() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Transcoding transcode() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void validate(File f, long b) {
		if(f.exists()) {
			for(String extension : extensions) {
				if(f.getName().contains(extension)) {
					b = f.length();
					double mb = Math.pow(1024, 2);
					if((b / mb) <= maxFileSize) {
						System.out.println("File is validated.");
						break;
					}else {
						System.out.println("File size exceeded size limit!");
						break;
					}
				}else {
					System.out.println("File type is invalid!");
				}
			}
		}
	}

}
