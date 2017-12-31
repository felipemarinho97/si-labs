'use strict';

var data = angular.module('data');

data.factory('Data', function($resource, $window, $http, base64) {

  var user;
  var apiUrl = 'http://localhost:8080/';

  return {
    queryArtists: function() {
      return $http.get(apiUrl + 'artists', {});
    },

    queryAlbums: function(artistName) {
      return $http.get(apiUrl + 'albums/' + artistName);
    },

    queryMusics: function(artistName, albumName) {
      return $http.get(apiUrl + 'musics/' + artistName + '/' + albumName);
    },

    queryPlaylists: function() {
      return $http.get(apiUrl + 'playlists');
    },

    queryPlaylistMusics: function(playlistName) {
      return toArray(playlistList[playlistName].musics);
    },

    getArtist: function(name) {
      return $http.get(apiUrl + 'artist/' + name);
    },

    putArtist: function(data) {
      return $http.post(apiUrl + 'artist', {"name": data.name,
                            "imagemSrc": data.imagemSrc,
                            "classification": data.classification,
                            "favorite": data.favorite == 1 ? true : false
                            });
    },

    favoriteArtist: (updateObject) => {
      return $http.put(apiUrl + 'artist/favorite', updateObject);
    },

    classificateArtist: (updateObject) => {
      return $http.put(apiUrl + 'artist/classification', updateObject);
    },

    setLastMusic: function(music) {
      return $http.put(apiUrl + 'artist/' + music.artist + '/' + music.id);
    },

    classificateAlbum: (albumId, classification) => {
      return $http.put(apiUrl + 'album/' + albumId + '/' + classification);
    },

    getAlbum: function(albumName, artistName) {
      return $http.get(apiUrl + 'album/' + artistName + '/' + albumName);
    },

    putMusic: function(music) {
      return $http.post(apiUrl + 'music', music);
    },

    putPlaylist: function(data) {
      return $http.post(apiUrl + 'playlists/' + data.name);
    },

    removePlaylist: function(playlistId) {
      return $http.delete(apiUrl + 'playlists/' + playlistId);
    },

    addMusic: function(playlistId, music) {
      return $http.put(apiUrl + 'playlists/' + playlistId + '/' + music.id);
    },

    removeMusic: function(playlistId, musicId) {
      return $http.delete(apiUrl + 'playlists/' + playlistId + '/' + musicId);
    },

    auth: (email, pass, remember) => {
      $http.defaults.headers.common['Authorization'] = 'Basic ' + base64.encode(email + ':' + pass);

      if (remember) {
        $window.sessionStorage.token = base64.encode(email + ':' + pass);
      }

      $http.post(apiUrl + 'login', {}, {"method": "POST"}).then((response) => {
        user = response.data;
      }).catch(() => {})

      return $http.post(apiUrl + 'login', {}, {"method": "POST"});
    },

    login: () => {
      $http.defaults.headers.common['Authorization'] = 'Basic ' + $window.sessionStorage.token;
      $http.post(apiUrl + 'login', {}, {"method": "POST"}).then((response) => {
        user = response.data;
      })
    },

    // getUserCredentials: () => {
    //   return $http.post(apiUrl + 'login', {}, {"method": "POST"});
    // },

    getUserCredentials: () => {
      return user;
    },

    logout: () => {
      delete $window.sessionStorage.token;
      delete $http.defaults.headers.common['Authorization'];
      user = undefined;
    },

    register: (email, pass, name) => {
      delete $http.defaults.headers.common['Authorization'];
      return $http.post(apiUrl + 'register', {"email": email, "password": pass, "nome": name}, {"method": "POST", "headers": {"Content-Type": "application/json"}});
    }

  }

});
