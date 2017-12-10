package io.darklyn.musicoteca.music;

public class Music {

	private String name;
	private String artist;
	private String album;
	private String releaseYear;
	private String length;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public String getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(String releaseYear) {
		this.releaseYear = releaseYear;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public Music(String name, String artist, String album, String releaseYear, String length) {
		super();
		this.name = name;
		this.artist = artist;
		this.album = album;
		this.releaseYear = releaseYear;
		this.length = length;
	}

}
