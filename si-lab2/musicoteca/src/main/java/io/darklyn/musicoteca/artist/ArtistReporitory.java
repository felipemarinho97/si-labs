package io.darklyn.musicoteca.artist;

import org.springframework.data.repository.CrudRepository;
import java.lang.String;
import io.darklyn.musicoteca.artist.Artist;
import java.util.List;

public interface ArtistReporitory extends CrudRepository<Artist, String> {
	
	boolean existsByName(String name);	
	Artist findOneByName(String name);
	Artist findOneByImagemSrc(String imagemsrc);

}
