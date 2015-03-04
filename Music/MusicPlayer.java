package Music;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Queue;
import java.util.Scanner;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class MusicPlayer { 
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("        Music player is started!!!  ");
		System.out.println(" Wait a few seconds to load local library....  ");
		Library library = new Library(new File("D:\\Music\\New Music 2014\\Nickelback"));
		
		System.out.println(" Please enter genre!!! ");
		String mood = input.nextLine();
		Queue<Song> list = new CreatePlaylist(mood, library.getLibrary()).getPlaylist();
		Playlist playlist = new Playlist(list, " New Playlist 2015");
		playlist.shuffle();
		play(playlist);
	 }

    private static void play(Playlist playlist) {
       Queue<Song> queueToPlay =  playlist.getPlaylist();
       FileInputStream fis = null;
       Player playMP3 = null;
       Song song = null; 
       
       System.out.println("Playing playlist: " + playlist.getName() +  "    Songs: " + playlist.getNumberOfSongs());
       playlist.showPlaylist();
       while(!queueToPlay.isEmpty()) {		
		   try {
				song =  queueToPlay.poll();	
				fis = new FileInputStream(song.getMp3File());
				playMP3 = new Player(fis);
				System.out.println("Now Playing...  \n" + song);
	    		System.out.println("Next Song:  \n" + queueToPlay.peek());
	    		playMP3.play();	    	
			} catch (FileNotFoundException | JavaLayerException e) {
				e.printStackTrace();
			}
    	}		
    }
}
