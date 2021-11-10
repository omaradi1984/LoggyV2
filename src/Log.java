import java.util.Date;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.UUID;

public abstract class Log implements Features {
	   	
	private final UUID id = UUID.randomUUID();
	private final String code = "abc-abc-abc";
	private String name;
	private String description;
	private final SimpleDateFormat f = new SimpleDateFormat("MMMM, dd yyyy @ HH:mm"); private Date d = new Date();
	private final String date = f.format(d);
	private File file;

	public Log() {
		super();
	}

	public Log(String name) {
		super();
		this.name = name;
	}

	public Log(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

	public Log(String name, String description, File file) {
		super();
		this.name = name;
		this.description = description;
		this.file = file;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public UUID getId() {
		return id;
	}

	public String getCode() {
		return code;
	}

	public String getDate() {
		return date;
	}

	public void create() {
		System.out.println("Log is created");
	}
	
	public void delete() {
		System.out.println("Log is deleted");
	}

	public void update() {
		System.out.println("Log is updated");
	}
	
	public void read() {
		System.out.println("Log is read");
	}
	
	public void validate(File f, long b) {
		
	}
}