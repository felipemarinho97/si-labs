package io.darklyn.musicoteca.playlists;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.darklyn.musicoteca.exceptions.ConflictException;
import io.darklyn.musicoteca.exceptions.PlaylistNotFoundException;
import io.darklyn.musicoteca.music.Music;

@Service
public class PlaylistsService {
	
	@Autowired
	private PlaylistReporitory playlistRepository;
	
	public Playlist addPlaylist(String name) {
		if (!playlistRepository.existsByName(name)) {
			return playlistRepository.save(new Playlist(name));
		} else {
			throw new ConflictException("Playlist já existe");
		}
	}
	
	public Playlist getPlaylist(String name) {
		Playlist p = playlistRepository.findByName(name);
		
		if (p == null) {
			throw new PlaylistNotFoundException("Playlist inexistente");
		}
		
		return p;
	}

	public List<Playlist> getAllPlaylists() {
		List<Playlist> l = new ArrayList<Playlist>();
		
		Iterable<Playlist> i = playlistRepository.findAll();
		i.forEach(l::add);
		
		return l;
	}

	public void addMusic(String nome, Music music) {
		Playlist p = this.getPlaylist(nome);
		
		p.putMusic(music);
		
		playlistRepository.save(p);		
	}

}
