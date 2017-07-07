package song;

public class Song {
	
	private String ext;
	private String path;

	public Song(String ext, String path) {
		this.ext = ext;
		this.path = path;
	}
	
	public String print() {
		return ext + "\n" + path;
		
	}
}
