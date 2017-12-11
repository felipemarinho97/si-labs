package io.darklyn.musicoteca.music;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Album {
	@Id @GeneratedValue
	private Integer Id;
	private String name;
	private String artist;
	private String releaseYear;
	
	@OneToMany
	private Map<String, Music> tracks;
	
	public Album(String name, String artist) {
		super();
		this.name = name;
		this.artist = artist;
		this.tracks = new HashMap<>();
	}

	public void addTrack(Music track) {
		if (tracks.containsKey(track.getName())) {
			throw new RuntimeException("Música já existente");
		}
		
		tracks.put(track.getName(), track);
	}
	
	public Music getTrack(String trackName) {
		return tracks.get(trackName);
	}
	
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

	public String getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(String releaseYear) {
		this.releaseYear = releaseYear;
	}
	
	

}
