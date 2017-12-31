package io.darklyn.musicoteca.playlists;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


public interface PlaylistReporitory extends CrudRepository<Playlist, Integer> {
	
	List<Playlist> findByUsername(String username);
	Playlist findOneByNameAndUsername(String name, String username);
	boolean existsByNameAndUsername(String name, String username);
	boolean existsByIdAndUsername(Integer id, String username);

}
