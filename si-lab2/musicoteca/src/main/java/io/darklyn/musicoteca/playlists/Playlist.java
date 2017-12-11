package io.darklyn.musicoteca.playlists;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import io.darklyn.musicoteca.music.Music;

@Entity
public class Playlist implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue // primary key
	private Integer id;
	private String name;
	@ManyToMany
	private List<Music> musicList;
	
	public Playlist() {
		
	}
	
	public Playlist(String name) {
		super();
		this.name = name;
		this.musicList = new ArrayList<>();
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Music> getMusicList() {
		return musicList;
	}

	public void setMusicList(List<Music> musicList) {
		this.musicList = musicList;
	}

	public void putMusic(String name, String artist, String album, String releaseYear, String length) {
		putMusic(new Music(name, artist, album, releaseYear, length));
	}

	public void putMusic(Music music) {
		musicList.add(music);
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

}
