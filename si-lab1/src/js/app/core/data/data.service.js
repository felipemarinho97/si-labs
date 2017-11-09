'use strict';

var data = angular.module('data');

data.factory('Data', function($resource) {
  var artistList = {
      "Jethro Tull": {
      name: "Jethro Tull",
      imagemSrc: "http://www.prog-sphere.com/wp-content/uploads/2017/05/Jethro-Tull.jpg",
      albums: {
        "Aqualung": {
          name: "Aqualung",
          artist: "Jethro Tull",
          musics: {
            "Aqualung": {
              name: "Aqualung",
              artist: "Jethro Tull",
              album: "Aqualung",
              anoDeLancamento: "02/02/169",
              duracao: "600"
            },
            "Cross-Eyed Mary": {
              name: "Cross-Eyed Mary",
              artist: "Jethro Tull",
              album: "Aqualung",
              anoDeLancamento: "02/02/169",
              duracao: "600"
            },
            "Cheap Day Return": {
              name: "Cheap Day Return",
              artist: "Jethro Tull",
              album: "Aqualung",
              anoDeLancamento: "02/02/169",
              duracao: "600"
            },
            "Up To Me": {
              name: "Up To Me",
              artist: "Jethro Tull",
              album: "Aqualung",
              anoDeLancamento: "02/02/169",
              duracao: "600"
            },
            "Hymn 43": {
              name: "Hymn 43",
              artist: "Jethro Tull",
              album: "Aqualung",
              anoDeLancamento: "02/02/169",
              duracao: "600"
            }
          }
        },
        "Thick as a Brick": {
          name: "Thick as a Brick",
          artist: "Jethro Tull",
          musics: {
            "Thick as a Brick": {
              name: "Thick as a Brick",
              artist: "Jethro Tull",
              album: "Thick as a Brick",
              anoDeLancamento: "02/02/169",
              duracao: "600"
            }
          }
        },
        lenght: 3
      },
      musicQtd: 15
    },
    "Pink Floyd": {
      name: "Pink Floyd",
      imagemSrc: "https://upload.wikimedia.org/wikipedia/en/d/d6/Pink_Floyd_-_all_members.jpg",
      albums: {},
      musicQtd: 0
    }, "Serginho Groisman": {
      name: "Serginho Groisman",
      imagemSrc: "https://upload.wikimedia.org/wikipedia/commons/2/2c/Serginho_Groisman_%282012%29_cropped.jpg",
      albums: {},
      musicQtd: 0
    }, "Iron Maiden": {
      name: "Iron Maiden",
      imageSrc: "",
      albums: {},
      musicQtd: 0
    }, "System of a Down": {
      name: "System of a Down",
      imageSrc: "",
      albums: {},
      musicQtd: 0
    }, "Led Zeppelin": {
      name: "Led Zeppelin",
      imageSrc: "",
      albums: {},
      musicQtd: 0
    }
  };

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
