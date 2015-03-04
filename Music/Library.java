package Music;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public class Library {

	private ArrayList<Song> library;
	private File directory;
	
	public Library(File directory) {
		library = new ArrayList<Song>();
		this.directory = directory;
		loadLibrary(directory);
	}

	private void loadLibrary(File directory) {
	  for(File file: directory.listFiles()) {
		 if(file.isDirectory())
			 loadLibrary(file);
	     else{
	    	library.add(new Song(file));	
	     }
	  }
    }

	public ArrayList<Song> getLibrary() {
		return library;
	}
	public File getDirectory() {
		return directory;
	}	
	
	public void showLibrary() {
		for(Iterator<Song> it = library.iterator(); it.hasNext();) {
			System.out.println(it.next());
		}
	}
}
