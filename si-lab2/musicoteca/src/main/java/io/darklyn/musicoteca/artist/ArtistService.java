package io.darklyn.musicoteca.artist;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtistService {
	private Map<String, Artist> artists;
	
	@Autowired
	private ArtistReporitory artistRepository;
	
	public Artist addArtist(String artistName, String imagemSrc) {
		if (!artistRepository.existsByName(artistName)) {
			throw new RuntimeException("Artista já existente");
		}
		
		return artistRepository.save(new Artist(artistName, imagemSrc));
	}
	
	public Artist addArtist(String artistName) {
		return addArtist(artistName, null);
	}
	
	public Artist getArtist(String artistName) {
		return artistRepository.findOneByName(artistName);
	}
	
	public Iterable<Artist> getAllArtists() {
		return artistRepository.findAll();
	}
}
