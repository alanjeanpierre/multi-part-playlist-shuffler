package files;

public class M3UFile {

	private String file;
	private int tuple;
	
	public M3UFile(String file, int tuple) {
		this.file = file;
		this.tuple = tuple;
	}
	
	public String file() { return file;}
	public int tuple() { return tuple;}
}
