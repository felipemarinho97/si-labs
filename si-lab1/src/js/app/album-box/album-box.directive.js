'use strict';

angular.module('albumBox').
  directive('albumBox', [function(data) {
    return {
      scope: {
        album: "=album",
        properties: "=properties"
      },
      templateUrl: '/templates/album-box.html',
      link: function(scope, element, attr) {
        var check = function(atribute, value) {
          if (!atribute || atribute === '') {
            return value;
          } else {
            return atribute;
          }
        };

        scope.album.imagemSrc = check(scope.album.imagemSrc, "/images/blank_artist.png");
      }
    }
  }])
