package io.darklyn.musicoteca.artist;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import io.darklyn.musicoteca.music.Album;

@Entity
public class Artist {
	
	@Id @GeneratedValue
	private Integer Id;
	private String name;
	private String imagemSrc;
	@OneToMany
	private Map<String, Album> albums; 
	
	public Artist(String name, String imagemSrc) {
		this(name);
		this.imagemSrc = imagemSrc;
	}

	public Artist(String name) {
		super();
		this.name = name;
		this.albums = new HashMap<>();
	}

	public void addAlbum(String albumName) {
		if (albums.containsKey(albumName)) {
			throw new RuntimeException("Album já existe");
		}
		
		albums.put(albumName, new Album(albumName, this.name));
	}
	
	public Album getAlbum(String albumName) {
		return albums.get(albumName);
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getImagemSrc() {
		return imagemSrc;
	}
	
	public void setImagemSrc(String imagemSrc) {
		this.imagemSrc = imagemSrc;
	}

}
