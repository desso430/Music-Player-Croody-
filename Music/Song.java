package Music;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.parser.mp3.Mp3Parser;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Song {

	private String title;
	private String artist;
	private String genre;
	private String album;
    private String releaseDate;
    private String duration;
    private File mp3File;
    
    
	public Song(File mp3File) {
		this.mp3File = mp3File;
		getMp3Information();
	}
	
    
	public String getTitle() {
		return title;
	}
	public String getArtist() {
		return artist;
	}
	public String getGenre() {
		return genre;
	}
	public String getAlbum() {
		return album;
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public String getDuration() {
		return duration;
	}
	public File getMp3File() {
		return mp3File;
	}

	private void getMp3Information() {
		Metadata metadata =  getMetadata();
		setFields(metadata);
	}
	
	
	private Metadata getMetadata() {
		Metadata metadata = null;
		try {	
			InputStream input = new FileInputStream(mp3File);
			ContentHandler handler = new DefaultHandler();
		    metadata = new Metadata();
		    Parser parser = new Mp3Parser();
		    ParseContext parseCtx = new ParseContext();
		    parser.parse(input, handler, metadata, parseCtx);
		    input.close();
		} catch (IOException | SAXException | TikaException e) {
			e.printStackTrace();
		}
	  return metadata;	
	}

	private void setFields(Metadata metadata) {
		title = metadata.get("title");
	    artist = metadata.get("xmpDM:artist");
	    genre = metadata.get("xmpDM:genre");
	    album = metadata.get("xmpDM:album");
	    releaseDate = metadata.get("xmpDM:releaseDate");
	    duration = metadata.get("xmpDM:duration");
	}

	@Override
	public String toString() {
		return "Title = " + title + ", Artist= " + artist + ", Genre= "
				+ genre + ", Album= " + album + ", Release date= " + releaseDate
				+ ", Duration= " + duration ;
	}
    
}
