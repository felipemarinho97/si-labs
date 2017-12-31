package io.darklyn.musicoteca.artist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.darklyn.musicoteca.album.Album;
import io.darklyn.musicoteca.music.Music;
import io.darklyn.musicoteca.usuario.User;

@Entity
public class Artist {
	
	@Id @GeneratedValue
	private Integer Id;
	private String name;
	private String imagemSrc;
	@OneToMany
	private List<Album> albums;
	private boolean favorite;
	private Integer classification;
	@OneToOne
	private Music lastMusic;
	@JsonIgnore
	private String username;
	
	public Artist() {}
	
	public Artist(String name, String imagemSrc, Integer classification,
			boolean favorite, String username) {
		this(name, imagemSrc, username);
		this.classification = classification;
		this.favorite = favorite;
	}
	
	public Artist(String name, String imagemSrc, String username) {
		this(name, username);
		this.imagemSrc = imagemSrc;
	}

	public Artist(String name, String username) {
		super();
		this.name = name;
		this.albums = new ArrayList<>();
		this.username = username;
	}

	public Album addAlbum(String albumName) {
		if (contains(albumName)) {
			throw new RuntimeException("Album já existe");
		}
		Album a = new Album(albumName, this.name);
		a.setArtistObj(this);
		albums.add(a);
		return a;
	}
	
	private boolean contains(String albumName) {
		for (Album album : albums) {
			if (album.getName().equals(albumName)) {
				return true;
			}
		}
		return false;
	}

	public Album getAlbum(String albumName) {
		for (Album album : albums) {
			if (album.getName().equals(albumName)) {
				return album;
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
	
	public String getImagemSrc() {
		return imagemSrc;
	}
	
	public void setImagemSrc(String imagemSrc) {
		this.imagemSrc = imagemSrc;
	}
	
	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public List<Album> getAlbums() {
		return albums;
	}

	public void setAlbums(List<Album> albums) {
		this.albums = albums;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public boolean isFavorite() {
		return favorite;
	}

	public void setFavorite(boolean favorite) {
		this.favorite = favorite;
	}

	public Integer getClassification() {
		return classification;
	}

	public void setClassification(Integer classification) {
		this.classification = classification;
	}

	public Music getLastMusic() {
		return lastMusic;
	}

	public void setLastMusic(Music lastMusic) {
		this.lastMusic = lastMusic;
	}

}
