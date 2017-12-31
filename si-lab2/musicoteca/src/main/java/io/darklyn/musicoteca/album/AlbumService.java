package io.darklyn.musicoteca.album;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.darklyn.musicoteca.artist.Artist;
import io.darklyn.musicoteca.artist.ArtistService;

@Service
public class AlbumService {
	@Autowired
	private ArtistService artistService;
	@Autowired
	private AlbumRepository albumRepository;
	
	public List<Album> getAllAlbums(String username, String artistName) {
		Artist a = artistService.getArtist(username, artistName);

		return a.getAlbums();
	}
	
	public Album getAlbum(String username, String artistName, String albumName) {
		Artist a = artistService.getArtist(username, artistName);
		Album al = a.getAlbum(albumName);
		return al;
	}
	
	public Album save(Album a) {
		return albumRepository.save(a);
	}

	public Album addAlbum(Artist a, String albumName) {
		Album al = a.addAlbum(albumName);
		return albumRepository.save(al);
	}

	public Album updateAlbum(Integer albumId, Integer classification) {
		Album a = albumRepository.findOne(albumId);
		a.setClassification(classification);
		return albumRepository.save(a);
	}
}
