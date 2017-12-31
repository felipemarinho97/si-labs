package io.darklyn.musicoteca.album;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.darklyn.musicoteca.artist.Artist;
import io.darklyn.musicoteca.artist.ArtistService;
import io.darklyn.musicoteca.usuario.SerialUserDetails;

@CrossOrigin
@RestController
public class AlbumController {
	
	@Autowired
	AlbumService albumService;
	
	@RequestMapping(method=RequestMethod.GET, value="/albums/{artistName}")
	public ResponseEntity<List<Album>> getAllAlbums(@AuthenticationPrincipal SerialUserDetails userDetails,
			@PathVariable String artistName) {
		List<Album> a = albumService.getAllAlbums(userDetails.getUsername(), artistName);
		return new ResponseEntity<>(a, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/album/{artistName}/{albumName}")
	public ResponseEntity<Album> getAlbum(@AuthenticationPrincipal UserDetails userDetails,
			@PathVariable String artistName, @PathVariable String albumName) {
		Album a = albumService.getAlbum(userDetails.getUsername(), artistName, albumName);
		return new ResponseEntity<>(a, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/album/{albumId}/{classification}")
	public ResponseEntity<Album> updateAlbum(@AuthenticationPrincipal UserDetails userDetails,
			@PathVariable Integer albumId, @PathVariable Integer classification) {
		Album a = albumService.updateAlbum(albumId,classification);
		return new ResponseEntity<>(a, HttpStatus.OK);
	}
}
