package io.darklyn.musicoteca.artist;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class ArtistService {
	private Map<String, Artist> artists;
	
	public ArtistService() {
		this.artists = new HashMap<>();
	}
	
	public void addArtist(String artistName, String imagemSrc) {
		if (artists.containsKey(artistName)) {
			throw new RuntimeException("Artista já existente");
		}
		
		artists.put(artistName, new Artist(artistName, imagemSrc));
	}
	
	public void addArtist(String artistName) {
		addArtist(artistName, null);
	}
	
	public Artist getArtist(String artistName) {
		return artists.get(artistName);
	}
}
