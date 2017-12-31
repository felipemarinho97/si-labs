package io.darklyn.musicoteca.music;

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

@CrossOrigin
@RestController
public class MusicController {
	
	@Autowired
	private MusicService musicService;
	
	@RequestMapping(method=RequestMethod.POST, value="/music")
	public ResponseEntity<Music> register(@RequestBody Music music,
			@AuthenticationPrincipal UserDetails userDetails) {
		ResponseEntity<Music> response;
		
		try {
			Music m = musicService.addMusic(userDetails.getUsername(),
					music.getName(), music.getArtist(), music.getAlbum(), 
					music.getReleaseYear(), music.getLength());
			response = new ResponseEntity<>(m, HttpStatus.OK);
		} catch (ConflictException ce) {
			response = new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		
		return response;
		
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/musics/{artistName}/{albumName}")
	public ResponseEntity<List<Music>> register(@PathVariable String artistName, @PathVariable String albumName,
			@AuthenticationPrincipal UserDetails userDetails) {
		ResponseEntity<List<Music>> response;
		
		try {
			List<Music> musics = musicService.getAllMusics(userDetails.getUsername(), artistName, albumName);
			response = new ResponseEntity<>(musics, HttpStatus.OK);
		} catch (ConflictException ce) {
			response = new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		
		return response;
		
	}
	
//	@RequestMapping(method=RequestMethod.POST, value="/music")
//	public ResponseEntity<Music> register(@RequestBody Music music,
//			@AuthenticationPrincipal UserDetails userDetails) {
//		ResponseEntity<Music> response;
//		
//		try {
//			Music m = musicService.addMusic(userDetails.getUsername(),
//					music.getName(), music.getArtist(), music.getAlbum(), 
//					music.getReleaseYear(), music.getLength());
//			response = new ResponseEntity<>(m, HttpStatus.OK);
//		} catch (ConflictException ce) {
//			response = new ResponseEntity<>(HttpStatus.CONFLICT);
//		}
//		
//		return response;
//		
//	}
}
