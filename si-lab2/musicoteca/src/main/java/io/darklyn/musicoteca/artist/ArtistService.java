package io.darklyn.musicoteca.artist;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.darklyn.musicoteca.exceptions.ConflictException;
import io.darklyn.musicoteca.model.ArtistUpdateObject;
import io.darklyn.musicoteca.music.Music;
import io.darklyn.musicoteca.music.MusicRepository;

@Service
public class ArtistService {
	private Map<String, Artist> artists;
	
	@Autowired
	private ArtistReporitory artistRepository;
	@Autowired
	private MusicRepository musicRepository;
	
	public Artist addArtist(String username, String artistName, String imagemSrc, 
			Integer classification, boolean favorite) {
		if (artistRepository.existsByNameAndUsername(artistName, username)) {
			throw new ConflictException("Artista já existente");
		}
		
		return artistRepository.save(new Artist(artistName, imagemSrc, classification,
				favorite, username));
	}
	
	public Artist addArtist(String username, String artistName) {
		return addArtist(username, artistName, null, 0, false);
	}

	
	public Artist getArtist(String username, String artistName) {
		if (!artistRepository.existsByNameAndUsername(artistName, username)) {
			throw new RuntimeException("Artista " + artistName + " não existente");
		}
		return artistRepository.findOneByNameAndUsername(artistName, username);
	}

	private Artist getArtist(Integer artistId) {
		return artistRepository.findOne(artistId);
	}
	
	public Iterable<Artist> getAllArtists(String username) {
		return artistRepository.findByUsername(username);
	}

	public Artist addClassification(ArtistUpdateObject ac) {
		Artist a = getArtist(ac.getArtistId());
		a.setClassification(ac.getClassification());
		return artistRepository.save(a);
	}

	public Artist addLastMusic(String username, String artistName, Integer musicId) {
		Artist a = getArtist(username, artistName);	
		Music m = musicRepository.findOne(musicId);
		a.setLastMusic(m);
		
		return artistRepository.save(a);
	}

	public Artist favorite(ArtistUpdateObject ac) {
		Artist a = getArtist(ac.getArtistId());
		a.setFavorite(ac.isFavorite());
		return artistRepository.save(a);
	}

	public Artist updateArtist(Artist a) {
		return artistRepository.save(a);
	}

}
