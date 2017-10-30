'use strict';

angular.module('artistBox').
  directive('artistBox', function() {
    return {
      scope: {
        artist: "=artist"
      },
      template: "<h2>{{artist.name}}</h2> <span ><img ng-src='{{artist.imagemSrc}}' height='150px'>",
      link: function(scope, element, attr) {
        console.log(scope.artist)
      }
    }
  })
