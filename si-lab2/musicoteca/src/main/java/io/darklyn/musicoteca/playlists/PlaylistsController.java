package io.darklyn.musicoteca.playlists;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.darklyn.musicoteca.music.Music;

@RestController
public class PlaylistsController {
	
	@Autowired
	private PlaylistsService playlistService;

	@RequestMapping(method=RequestMethod.GET, value="/playlists")
	public Iterable<Playlist> getAllPlaylists() {
		return playlistService.getAllPlaylists();
	};
	
	@RequestMapping(method=RequestMethod.POST, value="/playlists/{nome}")
	public void putPlaylist(@PathVariable String nome) {
		playlistService.putPlaylist(nome);
	};
	
	@RequestMapping(method=RequestMethod.POST, value="/playlists/{nome}")
	public void putMusicOnPlaylist(@PathVariable String nome, @RequestBody Music music) {
		playlistService.addMusic(nome, music);
	};
}
