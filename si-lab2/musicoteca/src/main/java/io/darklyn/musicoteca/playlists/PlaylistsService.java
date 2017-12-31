package io.darklyn.musicoteca.playlists;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.darklyn.musicoteca.exceptions.ConflictException;
import io.darklyn.musicoteca.exceptions.MusicNotFoundException;
import io.darklyn.musicoteca.exceptions.PlaylistNotFoundException;
import io.darklyn.musicoteca.music.Music;
import io.darklyn.musicoteca.music.MusicRepository;

@Service
public class PlaylistsService {
	
	@Autowired
	private PlaylistReporitory playlistRepository;
	@Autowired
	private MusicRepository musicRepository;
	
	public Playlist addPlaylist(String username, String name) {
		if (!playlistRepository.existsByNameAndUsername(name, username)) {
			return playlistRepository.save(new Playlist(username, name));
		} else {
			throw new ConflictException("Playlist já existe");
		}
	}
	
	public void deletePlaylist(Integer id) {
		if (playlistRepository.exists(id)) {
			playlistRepository.delete(id);
		} else {
			throw new PlaylistNotFoundException("Playlist inexistente");
		}
	}
	
	public Playlist getPlaylist(String name, String username) {
		Playlist p = playlistRepository.findOneByNameAndUsername(name, username);
		
		if (p == null) {
			throw new PlaylistNotFoundException("Playlist inexistente");
		}
		
		return p;
	}

	private Playlist getPlaylist(Integer id) {
		Playlist p = playlistRepository.findOne(id);
		
		if (p == null) {
			throw new PlaylistNotFoundException("Playlist inexistente");
		}
		
		return p;
	}
	
	public List<Playlist> getAllPlaylists(String username) {
		List<Playlist> list = new ArrayList<Playlist>();
		
		Iterable<Playlist> iterable = playlistRepository.findByUsername(username);
		iterable.forEach(list::add);
		
		return list;
	}

	public void addMusic(String username, Integer id, Integer musicId) {
		Playlist p = this.getPlaylist(id);
		
		Music m = musicRepository.findOne(musicId);
		if (!p.getMusicList().contains(m)) {
			p.putMusic(m);
			
			playlistRepository.save(p);	
		}
	
	}
	
	public void deleteMusic(Integer id, Integer musicId) {
		Playlist p = this.getPlaylist(id);
		p.removeMusic(musicId);
		playlistRepository.save(p);
	}

}
