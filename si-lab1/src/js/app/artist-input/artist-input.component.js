'use strict';

angular.module('artistInput').
  component('artistInput', {
    templateUrl: '/templates/artist-input.html',
    styleUrls: ['/css/artist-input.component.css'],
    controller: function($scope, $rootScope) {

      function clone(obj) {
          if (null == obj || "object" != typeof obj) return obj;
          var copy = obj.constructor();
          for (var attr in obj) {
              if (obj.hasOwnProperty(attr)) copy[attr] = obj[attr];
          }
          return copy;
      }

      if (!$rootScope.list) {
        $rootScope.list = [];
      }
      if (!$rootScope.index) {
        $rootScope.index = 0;
      }

      $scope.artist = {
        name: "",
        imagemSrc: ""
      }

      $scope.createNewArtist = function() {
        if ($scope.artist.name === '') {
          alert("Nome do artista obrigatório");
        } else if ($rootScope.list[$scope.artist.name]) {
          alert("Artista já existe");
        } else {
          $rootScope.list[$rootScope.index++] = clone($scope.artist);

          $scope.artist.name = "";
          $scope.artist.imagemSrc = "/images/blank_artist.png";

          alert("Adiconado!");
        }
      }
    }
  });
