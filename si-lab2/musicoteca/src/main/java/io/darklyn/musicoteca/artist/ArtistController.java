package io.darklyn.musicoteca.artist;

import io.darklyn.musicoteca.exceptions.ConflictException;
import io.darklyn.musicoteca.model.ArtistUpdateObject;
import io.darklyn.musicoteca.usuario.SerialUserDetails;
import io.darklyn.musicoteca.usuario.User;
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

@CrossOrigin
@RestController
public class ArtistController {
	
	@Autowired
	ArtistService artistService;

	@RequestMapping(method=RequestMethod.GET, value="/artist/{name}")
	public ResponseEntity<Artist> getArtist(@PathVariable String name, 
			@AuthenticationPrincipal UserDetails userDetails) {
		Artist a = artistService.getArtist(userDetails.getUsername(), name);
		
		return new ResponseEntity<>(a, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/artist")
	public ResponseEntity<Artist> addArtist(@RequestBody Artist artist, 
			@AuthenticationPrincipal SerialUserDetails userDetails) {
		Artist a = null;
		try {
			a = artistService.addArtist(userDetails.getUsername(), artist.getName(), artist.getImagemSrc(), 
					artist.getClassification(), artist.isFavorite());
		} catch (ConflictException ce) {
			return new ResponseEntity<>(artist, HttpStatus.CONFLICT);
		}
		
		return new ResponseEntity<>(a, HttpStatus.OK);
	}

	
	@RequestMapping(method=RequestMethod.GET, value="/artists")
	public ResponseEntity<Iterable<Artist>> getAllArtists(@AuthenticationPrincipal SerialUserDetails userDetails) {
		Iterable<Artist> a = artistService.getAllArtists(userDetails.getUsername());
		return new ResponseEntity<>(a, HttpStatus.OK);
	}

	@RequestMapping(method=RequestMethod.PUT, value="/artist/classification")
	public ResponseEntity<Artist> updateClassification(@RequestBody ArtistUpdateObject ac) {
		Artist a = artistService.addClassification(ac);
		return new ResponseEntity<>(a, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/artist/favorite")
	public ResponseEntity<Artist> favorite(@RequestBody ArtistUpdateObject ac) {
		Artist a = artistService.favorite(ac);
		return new ResponseEntity<>(a, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/artist/{artistName}/{musicId}")
	public ResponseEntity<Artist> updateLastMusic(@PathVariable String artistName, @PathVariable Integer musicId, 
			@AuthenticationPrincipal UserDetails userDetails) {
		Artist a = artistService.addLastMusic(userDetails.getUsername(), artistName, musicId);
		return new ResponseEntity<>(a, HttpStatus.OK);
	}

}
