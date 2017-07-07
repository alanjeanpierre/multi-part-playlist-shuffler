package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import files.M3UFile;
import song.Song;
import song.Tuplet;

public class Main {

	public static void main(String args[]) {
		Scanner file = null;
		ArrayList<M3UFile> playlists = new ArrayList<>();
		ArrayList<Tuplet> finalList = new ArrayList<>();
		try {
			file = new Scanner(new File(args[0]));
			
			while (file.hasNext()) {
				String line = file.nextLine();
				String[] elements = line.split(" ");
				String path = elements[0];
				int tuple = Integer.parseInt(elements[1]);
				playlists.add(new M3UFile(path, tuple));
			}
		}
		catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		
		file.close();
		
		playlists.stream().forEach(p -> {
			parse(p, finalList);
		});
		
		Collections.shuffle(finalList);
		
		System.out.println("#EXTM3U");
		finalList.stream().forEach(p -> System.out.println(p.print()));
	}

	private static void parse(M3UFile p, ArrayList<Tuplet> finalList) {
		Scanner file = null;
		ArrayList<Song> songs = new ArrayList<>();
		try {
			file = new Scanner(new File(p.file()));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		}
		
		if (file.hasNextLine()) { 
			String header = file.nextLine(); // #ext header
			if (!header.equals("#EXTM3U")) {
				System.err.println(String.format("%s is not a valid M3U playlist", p.file()));
				return;
			}
		}
		else {
			System.err.println(String.format("%s is not a valid M3U playlist", p.file()));
			return;
		}
		
		while (file.hasNextLine()) {
			String ext = file.nextLine();
			String path = null;
			if (file.hasNextLine()) {
				path = file.nextLine();
				Song song = new Song(ext, path);
				songs.add(song);
			}
			else {
				System.err.println(String.format("Playlist %s has invalid syntax, not including in final playlist", p.file()));
				return; // bad file, mismatched lines
			}
			
		}

		file.close();
		
		if (songs.size() % p.tuple() != 0) { // mismatched playlist file
			System.err.println("Mismatched playlist file");
			System.err.println(String.format("Playlist %s should have tuplets of %d, not including in final playlist", p.file(), p.tuple()));
			return;
		}
		
		for (int i = 0; i < songs.size(); i += p.tuple()) {
			Tuplet t = new Tuplet();
			for (int j = i; j < p.tuple()+i; j++) {
				t.addSong(songs.get(j));				
			}
			finalList.add(t);
		}
		
	}
}
