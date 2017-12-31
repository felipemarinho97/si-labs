package io.darklyn.musicoteca.model;

import io.darklyn.musicoteca.music.Music;

public class ArtistUpdateObject {
	
	private Integer classification;
	private Integer artistId;
	private Music lastMusic;
	private boolean favorite;
	
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
	public Integer getArtistId() {
		return artistId;
	}
	public void setArtistId(Integer artistId) {
		this.artistId = artistId;
	}
	public void setLastMusic(Music lastMusic) {
		this.lastMusic = lastMusic;
	}
	public Music getLastMusic() {
		return this.lastMusic;
	}

}
