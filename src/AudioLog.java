import java.io.File;

public class AudioLog extends Log {

	private final String[] extensions = {".wav", ".mp3", ".midi"};
	private final double maxFileSize = 100;
	
	public AudioLog() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AudioLog(String name, String description, File file) {
		super(name, description, file);
		// TODO Auto-generated constructor stub
	}

	public AudioLog(String name, String description) {
		super(name, description);
		// TODO Auto-generated constructor stub
	}

	public AudioLog(String name) {
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
		return null;
	}

	@Override
	public Captioning caption() {
		// TODO Auto-generated method stub
		Captioning c = new Captioning();
		c.setCaption("This is a caption");
		return c;
	}

	@Override
	public Transcoding transcode() {
		// TODO Auto-generated method stub
		Transcoding tc = new Transcoding();
		return tc;
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
