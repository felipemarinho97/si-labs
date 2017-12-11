package io.darklyn.musicoteca.artist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArtistController {
	
	@Autowired
	ArtistService artistService;

	@RequestMapping(method=RequestMethod.POST, value="/artist")
	public ResponseEntity<Artist> addArtist(@RequestBody Artist artist) {
		Artist a = artistService.addArtist(artist.getName(), artist.getImagemSrc());
		
		return new ResponseEntity<>(a, HttpStatus.OK);
	}

	
	@RequestMapping(method=RequestMethod.GET, value="/artists")
	public ResponseEntity<Iterable<Artist>> getAllArtists() {
		Iterable<Artist> a = artistService.getAllArtists();
		return new ResponseEntity<>(a, HttpStatus.OK);
	}
}
