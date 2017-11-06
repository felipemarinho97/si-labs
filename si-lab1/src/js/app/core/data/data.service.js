'use strict';

var data = angular.module('data');

data.factory('Data', function($resource) {
  var artistList = {};

  var toArray = function(obj) {
    return $.map(obj, function(value, index) {
      return [value];
    });
  }

  return {
    queryArtists: function() {
      return toArray(artistList);
    },

    queryAlbums: function(artistName) {
      var artist = this.getArtist(artistName);
      return toArray(artist.albums);
    },

    queryMusics: function(artistName, albumName) {
      var album = this.getAlbum(albumName, artistName);
      return toArray(album.musics);
    },

    getArtist: function(name) {
      return artistList[name];
    },

    putArtist: function(data) {
      if (!artistList[data.name]) {
        artistList[data.name] = data;
      }
    },

    getAlbum: function(albumName, artistName) {
      if (artistList[artistName]) {
        return artistList[artistName].albums[albumName];
      }
    },

    setAlbum: function(album) {
      if (!artistList[album.artist]) { // If artist is undefned, create a new.
        this.putArtist({
          name: album.artist,
          imagemSrc: "",
          albums: {lenght:0},
          musicQtd: 0
        })
      }

      // Then assign the album to the artist.
      artistList[album.artist].albums[album.name] = album;
      artistList[album.artist].albums.lenght++;
    },

    getMusic: function(music) {
      if (this.getAlbum(music.album, music.artist)) {
        return this.getAlbum(music.album, music.artist).musics[music.name];
      }
    },

    putMusic: function(music) {
      // If album is undefined, create a new album.
      if (!this.getAlbum(music.album, music.artist)) {
        this.setAlbum({
          name: music.album,
          artist: music.artist,
          musics: {lenght:0}
        });
      }

      // Then put the music in the album.
      this.getAlbum(music.album, music.artist).musics[music.name] = music;
      this.getAlbum(music.album, music.artist).musics.lenght++;
      artistList[music.artist].musicQtd++;
    }
  }

});
