package ClosedCaptioning;
//A class Recording representing a media file (audio or video) and it attributes.
import java.util.UUID;

public class Recording {
	
	private final UUID id = UUID.randomUUID(); // A unique file ID
	private String name; //File name
	private long length; //File length

	public Recording(String name, long length) {
		super();
		this.name = name;
		this.length = length;
	}
	//Attributes getters and setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getLength() {
		return length;
	}	
	public void setLength(long length) {
		this.length = length;
	}
	public UUID getId() {
		return id;
	}
}
