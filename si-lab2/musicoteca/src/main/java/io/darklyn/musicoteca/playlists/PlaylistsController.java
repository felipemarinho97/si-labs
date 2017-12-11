package io.darklyn.musicoteca.playlists;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.darklyn.musicoteca.exceptions.ConflictException;
import io.darklyn.musicoteca.exceptions.PlaylistNotFoundException;
import io.darklyn.musicoteca.music.Music;

@RestController
public class PlaylistsController {
	
	@Autowired
	private PlaylistsService playlistService;

	@RequestMapping(method=RequestMethod.GET, value="/playlists")
	public ResponseEntity<List<Playlist>> getAllPlaylists() {
		ResponseEntity<List<Playlist>> response;
		
		try {
			List<Playlist> allPlaylists = playlistService.getAllPlaylists();
			response = new ResponseEntity<List<Playlist>>(allPlaylists, HttpStatus.OK);
		} catch (PlaylistNotFoundException pnfe) {
			response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		return response;
	};
	
	@RequestMapping(method=RequestMethod.POST, value="/playlists/{nome}")
	public ResponseEntity<Playlist> putPlaylist(@PathVariable String nome) {
		ResponseEntity<Playlist> response;
		
		try {
			Playlist playlist = playlistService.addPlaylist(nome);
			response = new ResponseEntity<>(playlist, HttpStatus.OK);
		} catch (ConflictException ce) {
			response = new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		
		return response;
	};
	
	@RequestMapping(method=RequestMethod.PUT, value="/playlists/{nome}")
	public void putMusicOnPlaylist(@PathVariable String nome, @RequestBody Music music) {
		playlistService.addMusic(nome, music);
	};
}
