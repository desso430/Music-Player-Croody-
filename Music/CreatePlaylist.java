package Music;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class CreatePlaylist {

	private Queue<Song> playlist = new ConcurrentLinkedQueue<Song>();
	private ArrayList<Song> library;
	private String mood;
	
	public CreatePlaylist(String mood, ArrayList<Song> library) {
		this.library = library;
		this.mood = mood;
		createPLaylist();
	}
	
	private void createPLaylist(){
		Song song = null;
		for(Iterator<Song> it = library.iterator(); it.hasNext();) {
			song = it.next();
			if(song.getGenre().equalsIgnoreCase(mood)) {
				playlist.add(song);
			}
		}	
	}

	public Queue<Song> getPlaylist() {
		return playlist;
	}
	public String getMood() {
		return mood;
	}

}
