'use strict';

angular.module('artistBox').
  directive('artistBox', function() {
    return {
      scope: {
        artist: "=artist"
      },
      template: "<div class='card' style='width: 20rem;'><img class='card-img-top' ng-src='{{artist.imagemSrc}}'><div class='card-block p-2'><h4 class='card-title'>{{artist.name}}</h4></div></div>",
      link: function(scope, element, attr) {
        if (scope.artist.imagemSrc === '' || !scope.artist.imagemSrc) {
          scope.artist.imagemSrc = "/images/blank_artist.png";
        }
      }
    }
  })
