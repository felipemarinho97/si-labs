package io.darklyn.musicoteca.playlists;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.darklyn.musicoteca.exceptions.ConflictException;
import io.darklyn.musicoteca.exceptions.PlaylistNotFoundException;
import io.darklyn.musicoteca.music.Music;
import io.darklyn.musicoteca.usuario.SerialUserDetails;

@CrossOrigin
@RestController
public class PlaylistsController {
	
	@Autowired
	private PlaylistsService playlistService;

	@RequestMapping(method=RequestMethod.GET, value="/playlists")
	public ResponseEntity<List<Playlist>> getAllPlaylists(@AuthenticationPrincipal UserDetails userDetails) {
		ResponseEntity<List<Playlist>> response;
		
		try {
			List<Playlist> allPlaylists = playlistService.getAllPlaylists(userDetails.getUsername());
			response = new ResponseEntity<List<Playlist>>(allPlaylists, HttpStatus.OK);
		} catch (PlaylistNotFoundException pnfe) {
			response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		return response;
	};
	
	@RequestMapping(method=RequestMethod.POST, value="/playlists/{nome}")
	public ResponseEntity<Playlist> putPlaylist(@PathVariable String nome, @AuthenticationPrincipal UserDetails userDetails) {
		ResponseEntity<Playlist> response;
		
		try {
			Playlist playlist = playlistService.addPlaylist(userDetails.getUsername(), nome);
			response = new ResponseEntity<>(playlist, HttpStatus.OK);
		} catch (ConflictException ce) {
			response = new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		
		return response;
	};
	
	@RequestMapping(method=RequestMethod.PUT, value="/playlists/{id}/{musicId}")
	public void putMusicOnPlaylist(@PathVariable Integer id, @PathVariable Integer musicId, @AuthenticationPrincipal UserDetails userDetails) {
		playlistService.addMusic(userDetails.getUsername(), id, musicId);
	};
	
	@RequestMapping(method=RequestMethod.DELETE, value="/playlists/{id}")
	public ResponseEntity deletePlaylist(@PathVariable Integer id) {
		ResponseEntity response;
		
		try {
			playlistService.deletePlaylist(id);
			response = new ResponseEntity<>(HttpStatus.OK);
		} catch (PlaylistNotFoundException pnfe) {
			response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		return response;
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/playlists/{id}/{musicId}")
	public ResponseEntity deletePlaylistMusic(@PathVariable Integer id, @PathVariable Integer musicId) {
		ResponseEntity response;
		
		try {
			playlistService.deleteMusic(id, musicId);
			response = new ResponseEntity<>(HttpStatus.OK);
		} catch (PlaylistNotFoundException pnfe) {
			response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		return response;
	}
}
