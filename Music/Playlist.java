package Music;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Iterator;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Playlist {
	
	private Queue<Song> playlist = new ConcurrentLinkedQueue<Song>();
	private String name;
	private LocalDate dateOfCreating;
	
	public Playlist(Queue<Song> playlist, String name) {
		dateOfCreating = LocalDate.now();
		this.playlist = playlist;
		this.name = name;
	}

	public Queue<Song> getPlaylist() {
		return playlist;
	}
	public String getName() {
		return name;
	}
	public LocalDate getDateOfCreating() {
		return dateOfCreating;
	}
		
	public int getNumberOfSongs() {
		return playlist.size();
	}

	public void addToPlaylist(Song song) {
		if(song != null)
		  playlist.add(song);
	}
	
	public boolean removeFromPlaylist(Song song) {
		if(song != null)
		  return  playlist.remove(song);
	  return false;
	}
	
	public void showPlaylist() {
		for(Iterator<Song> it = playlist.iterator(); it.hasNext();) {
			System.out.println(it.next());
		}
	}
	

	void shuffle() {// shuffle all songs in playlist
		Random random = new Random();
		Song[] songs = new Song[playlist.size()];
		playlist.toArray(songs);
		playlist.clear();
		Song temp = null;
	
		for(int i = 0; i< songs.length; i++) {
			int rand = random.nextInt(songs.length-1);
			temp = songs[rand];
			songs[rand] = songs[i];
			songs[i] = temp;
		}
		Collections.addAll(playlist, songs);
	}
	
//	public int getDurationOfAllSongs() {
//	int duration = 0;
//	for(Iterator<Song> it = playlist.iterator(); it.hasNext();) {
//		duration = it.next().getDuration();
//	}
//  return duration;
//}
}
