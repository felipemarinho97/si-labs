package io.darklyn.musicoteca.music;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.darklyn.musicoteca.album.Album;
import io.darklyn.musicoteca.album.AlbumService;
import io.darklyn.musicoteca.artist.Artist;
import io.darklyn.musicoteca.artist.ArtistService;

@Service
public class MusicService {
	
	@Autowired
	private ArtistService artistService;
	@Autowired
	private AlbumService albumService;
	@Autowired
	private MusicRepository musicRepository;
	
	public Music addMusic(String username, String musicName, String artistName, String albumName,
			String releaseYear, String length) {
		Artist a = null;
		Album ab = null;
		try {
			a = artistService.addArtist(username, artistName);
		} catch (Exception e) {
			e.printStackTrace();
			a = artistService.getArtist(username, artistName);
		}
		
		try {
			ab = albumService.addAlbum(a, albumName);
		} catch (Exception e) {
			e.printStackTrace();
			ab = albumService.getAlbum(username, artistName, albumName);
		}
	
		Music m = new Music(musicName, artistName, albumName,
				releaseYear, length);
		ab.addTrack(m);
		musicRepository.save(m);
		
		artistService.updateArtist(a);
		
		return m;
		
	}
		
		
	
	// non used
	public void removeMusic(String username, Music music) {
		Artist a = artistService.getArtist(username, music.getArtist());
		Album al = a.getAlbum(music.getAlbum());
		
		if (al != null) {
			al.removeTrack(music);
		}
	}



	public List<Music> getAllMusics(String username, String artistName, String albumName) {
		Album al = albumService.getAlbum(username, artistName, albumName);
		System.out.println(username + artistName + albumName);
		return al.getMusics();
	}

}
