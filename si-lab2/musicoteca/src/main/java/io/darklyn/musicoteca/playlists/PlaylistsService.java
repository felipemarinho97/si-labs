package io.darklyn.musicoteca.playlists;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.darklyn.musicoteca.music.Music;

@Service
public class PlaylistsService {
	
	@Autowired
	private PlaylistReporitory playlistRepository;
	
	public void putPlaylist(String name) {
		playlistRepository.save(new Playlist(name));
	}
	
	public Playlist getPlaylist(String name) {
		return playlistRepository.findOne(name);
	}

	public Iterable<Playlist> getAllPlaylists() {
		return playlistRepository.findAll();
	}

	public void addMusic(String nome, Music music) {
		Playlist p = this.getPlaylist(nome);
		p.putMusic(music);
		playlistRepository.save(p);		
	}

}
