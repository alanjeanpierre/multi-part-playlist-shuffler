package song;

import java.util.*;

public class Tuplet {
	
	private List<Song> tuplet;

	public Tuplet() {
		tuplet = new ArrayList<Song>();
	}
	
	public String print() {
		StringBuilder s = new StringBuilder();
		
		tuplet.forEach(song -> s.append(song.print() + "\n"));
		
		return s.toString();
	}
	
	public void addSong(Song s) {
		tuplet.add(s);
	}
}
