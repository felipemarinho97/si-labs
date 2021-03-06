'use strict';

angular.module('albumBox').
  directive('albumBox', ["LastFM", "Data", function(LastFM, Data) {
    return {
      scope: {
        album: "=album",
        properties: "=properties"
      },
      templateUrl: '/templates/album-box.html',
      link: function(scope, element, attr, ctrl) {
        var check = function(atribute, value) {
          if (!atribute || atribute === '') {
            return value;
          } else {
            return atribute;
          }
        };

        scope.album.imagemSrc = check(scope.album.imagemSrc, "/images/blank_artist.png");

        // Busca capas dos albuns no lastfm
        LastFM.Album.getInfo(scope.album.artist, scope.album.name).then((response) => {
          scope.album.imagemSrc =  response.image[3]["#text"];
        });

        scope.updateClassification = () => {
          Data.classificateAlbum(scope.album.id, scope.album.classification);
        }

        // setTimeout(function(){
        //   scope.album.imagemSrc = a.$$state.value.image[3]["#text"];
        // }, 1000)
      }
    }
  }])
