import java.io.File;

public class TextLog extends Log {

	private final String[] extensions = {".txt", ".doc", ".docx"};
	private final double maxFileSize = 100;
	
	public TextLog() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TextLog(String name, String description, File file) {
		super(name, description, file);
		// TODO Auto-generated constructor stub
	}

	public TextLog(String name, String description) {
		super(name, description);
		// TODO Auto-generated constructor stub
	}

	public TextLog(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
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

	@Override
	public Translation translate() {
		Translation t = new Translation();
		t.setNameTranslation("The translation of the log name (" + this.getName() + ") is (This is a translation of the name.)");
		t.setDescriptionTranslation("The translation of the log description (" + this.getDescription() + ") is (This is a translation of the description.)");
		return t;
	}

	@Override
	public Annotation annotate() {
		// TODO Auto-generated method stub
		return null;
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
}
