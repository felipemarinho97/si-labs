package io.darklyn.musicoteca.playlists;

import org.springframework.data.repository.CrudRepository;

public interface PlaylistReporitory extends CrudRepository<Playlist, String> {
	
	Playlist findById(String id);
	Playlist findByName(String name);
	boolean existsByName(String name);

}
