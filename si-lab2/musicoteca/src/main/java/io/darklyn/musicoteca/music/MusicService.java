package io.darklyn.musicoteca.music;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.darklyn.musicoteca.artist.ArtistService;

@Service
public class MusicService {
	
	@Autowired
	private ArtistService artistService;
	
	public void addMusic(String musicName, String artistName, String albumName,
			String releaseYear, String length) {
		try {
			artistService.addArtist(artistName);
		} finally {
			try {
				artistService
					.getArtist(artistName)
					.addAlbum(albumName);
			} finally {
				artistService
					.getArtist(artistName)
					.getAlbum(albumName)
					.addTrack(new Music(musicName, artistName, albumName,
							releaseYear, length));
			}
		}
	}

}
