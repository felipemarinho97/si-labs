package io.darklyn.musicoteca.artist;

import org.springframework.data.repository.CrudRepository;
import java.lang.String;
import io.darklyn.musicoteca.artist.Artist;
import java.util.List;
import java.lang.Integer;

public interface ArtistReporitory extends CrudRepository<Artist, Integer> {
	
	boolean existsByNameAndUsername(String name, String username);
	boolean existsByName(String name);
	Artist findOneByName(String name);
	Artist findOneByImagemSrc(String imagemsrc);
	Artist findOneByNameAndUsername(String artistName, String username);
	List<Artist> findByUsername(String username);

}
