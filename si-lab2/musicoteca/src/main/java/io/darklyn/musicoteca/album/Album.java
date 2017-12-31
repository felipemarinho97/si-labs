package io.darklyn.musicoteca.album;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.darklyn.musicoteca.artist.Artist;
import io.darklyn.musicoteca.music.Music;

@Entity
public class Album {
	@Id @GeneratedValue
	private Integer Id;
	private String name;
	private String artist;
	private String releaseYear;
	private Integer classification;
	
	@OneToMany
	private List<Music> musics;
	
	@JsonIgnore
	@ManyToOne
	private Artist artistObj;
	
	public Album() {}
	
	public Album(String name, String artist) {
		super();
		this.name = name;
		this.artist = artist;
		this.musics = new ArrayList<>();
	}

	public Music addTrack(Music track) {
		if (musics.contains(track)) {
			throw new RuntimeException("Música já existente");
		}
		track.setAlbumObj(this);
		musics.add(track);
		return track;
	}

	public Music removeTrack(Music track) {
		musics.remove(track);
		return track;
	}
	
	public Music getTrack(String trackName) {
		for (Music music : musics) {
			if (trackName.equals(music.getName())) {
				return music;
			}
		}
		return null;
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

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public Integer getClassification() {
		return classification;
	}

	public void setClassification(Integer classification) {
		this.classification = classification;
	}

	public void setArtistObj(Artist artist) {
		this.artistObj = artist;
	}

	public List<Music> getMusics() {
		return musics;
	}

	public void setMusics(List<Music> musics) {
		this.musics = musics;
	}
	
	

}
