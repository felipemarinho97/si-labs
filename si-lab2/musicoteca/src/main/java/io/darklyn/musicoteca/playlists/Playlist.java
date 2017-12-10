package io.darklyn.musicoteca.playlists;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.Id;

import io.darklyn.musicoteca.music.Music;

@Entity
public class Playlist {
	
	@Id // primary key
	private String id;
	private String name;
	private List<Music> musicList = new ArrayList<>();
	
	public Playlist(String name) {
		super();
		this.name = name;
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
